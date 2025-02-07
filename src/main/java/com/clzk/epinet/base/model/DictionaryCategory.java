package com.clzk.epinet.base.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dictionary_category")
@Data
public class DictionaryCategory {

    @Id
    private String id;

    @Column(name = "category_code", unique = true, nullable = false, length = 50)
    private String categoryCode;  // 类别代码，如 gender, nationality, education_level

    @Column(name = "category_name", nullable = false, length = 100)
    private String categoryName;  // 类别名称，如 "性别代码表"

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;   // 类别描述

//    @Transient
//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<DictionaryData> dictionaryDataList;  // 关联的值域数据
}
