package com.clzk.epinet.base.controller;

import com.clzk.epinet.base.constant.CodeTypeEnum;
import com.clzk.epinet.base.dto.ApiResponse;
import com.clzk.epinet.base.dto.SyncResult;
import com.clzk.epinet.base.executor.IncrementalSyncExecutor;
import com.clzk.epinet.base.model.EmrBaseUser;
import com.clzk.epinet.base.model.EmrDic;
import com.clzk.epinet.base.repository.EmrBaseUserRepository;
import com.clzk.epinet.base.repository.EmrDicRepository;
import com.clzk.epinet.base.service.QueryService;
import com.clzk.epinet.emr.model.BaseDept;
import com.clzk.epinet.emr.model.BaseUser;
import com.clzk.epinet.emr.model.EmrActivityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/emr/sync")
public class EmrSyncController {

    @Autowired
    private EmrDicRepository emrDicRepository;

    @Autowired
    private EmrBaseUserRepository emrBaseUserRepository;

    @Autowired
    private IncrementalSyncExecutor incrementalSyncExecutor;

    @Autowired
    private QueryService queryService;


    @GetMapping("/activity")
    public ApiResponse syncActivity(@RequestParam String orgCode, @RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        if (start == null || end == null) {
            return ApiResponse.error("参数错误：start 和 end 不能为空");
        }
        List<EmrActivityInfo> dataList = queryService.queryViewIncremental(EmrActivityInfo.class, orgCode, start, end);
        SyncResult syncResult = incrementalSyncExecutor.syncIncrementalManual(EmrActivityInfo.class, dataList);
        return ApiResponse.ok(syncResult.toString());

    }

    @GetMapping("/dept")
    public ApiResponse syncDept() {
        List<EmrDic> dicList = emrDicRepository.findByCategoryCode(CodeTypeEnum.DEPARTMENT.getCode(), true);
//        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime now = LocalDateTime.now();
        List<BaseDept> dataList = dicList.stream().map(dic -> {
            BaseDept dept = new BaseDept();
            dept.setDeptCode(dic.getCode());
            dept.setDeptName(dic.getName());
            dept.setTargetDeptCode(dic.getStdCode());
            dept.setTargetDeptName(dic.getStdName());
            dept.setCreateTime(now);
            return dept;
        }).toList();
        SyncResult syncResult = incrementalSyncExecutor.syncIncrementalManual(BaseDept.class, dataList);
        return ApiResponse.ok(syncResult.toString());
    }

    @GetMapping("/user")
    public ApiResponse syncUser(@RequestParam(required = false) String orgCode,
                                @RequestParam(required = false) LocalDateTime start,
                                @RequestParam(required = false) LocalDateTime end) {
//        List<BaseUser> dataList = queryService.queryViewIncremental(BaseUser.class, orgCode, start, end);
        List<EmrBaseUser> userList = emrBaseUserRepository.findAll();
        List<BaseUser> dataList = userList.stream().map(user -> {
            BaseUser baseUser = new BaseUser();
            baseUser.setId(user.getId());
            baseUser.setOrgCode(user.getOrgCode());
            baseUser.setDeptCode(user.getDeptCode());
            baseUser.setUserName(user.getUserName());
            baseUser.setIdCardTypeCode(user.getIdCardTypeCode());
            baseUser.setIdCard(user.getIdCard());
            baseUser.setTel(user.getTel());
            baseUser.setPhysicianNo(user.getPhysicianNo());
            baseUser.setLoginName(user.getLoginName());
            baseUser.setCreateTime(user.getCreateTime());
            baseUser.setUserTypeCode(user.getUserTypeCode());
            return baseUser;
        }).toList();
//        dataList = dataList.stream().limit(100).toList();
        SyncResult syncResult = incrementalSyncExecutor.syncIncrementalManual(BaseUser.class, dataList);
        return ApiResponse.ok(syncResult.toString());
    }
}
