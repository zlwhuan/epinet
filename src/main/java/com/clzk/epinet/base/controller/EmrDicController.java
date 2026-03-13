package com.clzk.epinet.base.controller;

import com.clzk.epinet.base.dto.DictionaryDataDTO;
import com.clzk.epinet.base.dto.ApiResponse;
import com.clzk.epinet.base.constant.CodeTypeEnum;
import com.clzk.epinet.base.dto.SyncResult;
import com.clzk.epinet.base.executor.IncrementalSyncExecutor;
import com.clzk.epinet.base.initialize.DictionaryInitializer;
import com.clzk.epinet.base.model.EmrDic;
import com.clzk.epinet.emr.model.BaseDept;
import com.clzk.epinet.emr.model.EmrPatientInfo;
import com.clzk.epinet.base.repository.EmrDicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/emr/dic")
@Slf4j
public class EmrDicController {

    @Autowired
    private EmrDicRepository emrDicRepository;

    @Autowired
    private IncrementalSyncExecutor incrementalSyncExecutor;

    @Autowired
    private DictionaryInitializer dictionaryInitializer;

    @GetMapping("/{categoryCode}")
    public List<EmrDic> getByCategoryCode(@PathVariable String categoryCode) {
        // 查询某个类别的所有数据，例如 "gender"（性别代码表）
        return emrDicRepository.findByCategoryCode(categoryCode);
    }

    @GetMapping()
    public List<DictionaryDataDTO> getCategoryList() {
        CodeTypeEnum[] values = CodeTypeEnum.values();
        List<DictionaryDataDTO> result = new ArrayList<>();
// 先放 DEPARTMENT（如果存在）
        Arrays.stream(values)
                .filter(e -> e != CodeTypeEnum.DEPARTMENT)
                .map(CodeTypeEnum::toDictionaryDataDTO)
                .forEach(result::add);
        return result;
    }

    @PostMapping("/{categoryCode}")
    public ApiResponse saveByCategoryCode(@PathVariable String categoryCode, @RequestBody List<EmrDic> updatedList) {
        // 校验每条数据是否都属于相同的 categoryCode（防止错误提交）
        for (EmrDic dic : updatedList) {
            dic.setCategoryCode(categoryCode); // 保证每条数据的 categoryCode 一致
        }

        // 批量保存（根据 ID 区分新增或更新）
        try {
            if (CodeTypeEnum.DEPARTMENT.getCode().equals(categoryCode)) {
//                String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                LocalDateTime now = LocalDateTime.now();
                List<BaseDept> dataList = updatedList.stream().map(dic -> {
                    BaseDept dept = new BaseDept();
                    dept.setDeptCode(dic.getCode());
                    dept.setDeptName(dic.getName());
                    dept.setTargetDeptCode(dic.getStdCode());
                    dept.setTargetDeptName(dic.getStdName());
                    dept.setCreateTime(now);
                    return dept;
                }).toList();
                SyncResult syncResult = incrementalSyncExecutor.syncIncrementalManual(BaseDept.class, dataList);
                log.info(syncResult.toString());
            }
            emrDicRepository.saveAll(updatedList);
            dictionaryInitializer.refreshDictionaries();
            // 如果是部门字典更新了，需要同步到数据中台
            return ApiResponse.ok();
        } catch (DataIntegrityViolationException e) {
            return ApiResponse.error("保存失败，存在重复的 code 值");
        } catch (Exception e) {
            return ApiResponse.error("保存失败，发生异常: " + e.getLocalizedMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ApiResponse deleteById(@PathVariable Long id) {
        emrDicRepository.deleteById(id);
        return ApiResponse.ok();
    }


}
