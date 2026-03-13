package com.clzk.epinet.base.controller;

import com.clzk.epinet.base.constant.CodeTypeEnum;
import com.clzk.epinet.base.model.EmrDic;
import com.clzk.epinet.base.repository.EmrDicRepository;
import com.clzk.epinet.emr.model.BaseDept;
import com.clzk.epinet.emr.repository.BaseDeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/emr/dept")
public class EmrDeptController {

    @Autowired
    private EmrDicRepository emrDicRepository;

    @Autowired
    private BaseDeptRepository baseDeptRepository;


    @GetMapping("/standards")
    public List<EmrDic> getStandards() {
        return emrDicRepository.findByCategoryCode(CodeTypeEnum.DEPARTMENT.getCode()).stream().filter(v -> v.getIsNew() == null).toList();
    }

    @GetMapping("/list")
    public List<EmrDic> getAll() {
        List<EmrDic> localDepts = emrDicRepository.findByCategoryCode(CodeTypeEnum.DEPARTMENT.getCode(), true);
        Map<String, EmrDic> localDeptsMap = localDepts.stream().collect(Collectors.toMap(EmrDic::getCode, v -> v));
        List<BaseDept> remoteDepts = baseDeptRepository.findAll();

        List<EmrDic> newDepts = remoteDepts.stream().filter(v -> !localDeptsMap.containsKey(v.getDeptCode())).map(v -> {
            EmrDic dic = new EmrDic();
            dic.setCategoryCode(CodeTypeEnum.DEPARTMENT.getCode());
            dic.setCode(v.getDeptCode());
            dic.setName(v.getDeptName());
            dic.setIsNew(true);
            return dic;
        }).toList();
        if (!CollectionUtils.isEmpty(newDepts)) {
            emrDicRepository.saveAll(newDepts);
            localDepts = emrDicRepository.findByCategoryCode(CodeTypeEnum.DEPARTMENT.getCode(), true);
        }
        return localDepts;
    }

}
