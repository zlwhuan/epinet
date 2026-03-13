package com.clzk.epinet.base.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "emr_dictionary")
@Data
public class EmrDic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false, length = 50)
    private String categoryCode;  // 关联的类别

    @Column(name = "code", nullable = false, length = 50)
    private String code;  // 代码值，例如 '1', '2', '3'

    @Column(name = "name", nullable = false, length = 100)
    private String name;  // 代码含义，例如 '男性', '女性'

    @Column(name = "std_code", nullable = false, length = 50)
    private String stdCode;  // 代码值，例如 '1', '2', '3'

    @Column(name = "std_name", nullable = false, length = 100)
    private String stdName;  // 代码含义，例如 '男性', '女性'

    @Column(name = "std_desc")
    private String stdDesc;

    @Column(name = "is_new")
    private Boolean isNew = false;

    public Boolean getNew() {
        return isNew != null && isNew;
    }
}
