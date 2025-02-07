package com.clzk.epinet.base.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dictionary_data")
@Data
public class DictionaryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_code", nullable = false, length = 50)
    private String categoryCode;  // 关联的类别

    @Column(name = "code", nullable = false, length = 50)
    private String code;  // 代码值，例如 '1', '2', '3'

    @Column(name = "name", nullable = false, length = 100)
    private String name;  // 代码含义，例如 '男性', '女性'

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;  // 代码说明
}
