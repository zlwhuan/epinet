package com.clzk.epinet.base.controller;

import com.clzk.epinet.base.dto.DictionaryDataDTO;
import com.clzk.epinet.base.model.ApiCallLog;
import com.clzk.epinet.base.repository.ApiCallLogRepository;
import com.clzk.epinet.base.dto.LogQueryRequest;
import com.clzk.epinet.base.constant.InterfaceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/logs")
public class ApiCallLogController {

    @Autowired
    private ApiCallLogRepository apiCallLogRepository;

    @GetMapping("/interface")
    public List<DictionaryDataDTO> queryLogs() {
        return Arrays.stream(InterfaceEnum.values()).map(InterfaceEnum::toDictionaryDataDTO).collect(Collectors.toList());
    }

    @PostMapping("/query")
    public Page<ApiCallLog> queryLogs(@RequestBody LogQueryRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), Sort.by(Sort.Direction.DESC, "requestTime"));

        Specification<ApiCallLog> spec = Specification.where(null);

        // 接口名称模糊查询
        if (StringUtils.hasText(request.getInterfaceName())) {
            spec = spec.and((root, query, cb) ->
                    cb.like(root.get("interfaceName"), "%" + request.getInterfaceName() + "%"));
        }

        // 接口名称模糊查询
        if (StringUtils.hasText(request.getRequestParams())) {
            spec = spec.and((root, query, cb) ->
                    cb.like(root.get("requestParams"), "%" + request.getRequestParams() + "%"));
        }

        // 状态精确匹配
        if (StringUtils.hasText(request.getStatus())) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("status"), request.getStatus()));
        }

        // 时间范围
        if (request.getStartTime() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.greaterThanOrEqualTo(root.get("requestTime"), request.getStartTime()));
        }
        if (request.getEndTime() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.lessThanOrEqualTo(root.get("requestTime"), request.getEndTime()));
        }

        return apiCallLogRepository.findAll(spec, pageable);
    }
}