package com.clzk.epinet.base.controller;

import com.clzk.epinet.emr.model.BaseUser;
import com.clzk.epinet.emr.repository.BaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emr/user")
public class EmrUserController {

    //查询部门视图
    @Autowired
    private BaseUserRepository baseUserRepository;

    @GetMapping("/list")
    public List<BaseUser> getByCategoryCode() {
        // 查询某个类别的所有数据，例如 "gender"（性别代码表）
        return baseUserRepository.findAll();
    }

}
