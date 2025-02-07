package com.clzk.epinet.base.controller;

import com.clzk.epinet.base.dto.DictionaryDataDTO;
import com.clzk.epinet.base.model.DictionaryCategory;
import com.clzk.epinet.base.repository.DictionaryCategoryRepository;
import com.clzk.epinet.base.repository.DictionaryDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryDataRepository dataRepository;

    @Autowired
    private DictionaryCategoryRepository categoryRepository;

    @GetMapping("/{categoryCode}")
    public List<DictionaryDataDTO> getByCategoryCode(@PathVariable String categoryCode) {
        // 查询某个类别的所有数据，例如 "gender"（性别代码表）
        return dataRepository.findByCategoryCode(categoryCode);
    }

    @GetMapping("/")
    public List<DictionaryCategory> getAllCategories() {
        return categoryRepository.findAll();
    }


}
