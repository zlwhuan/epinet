package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医院信息系统科室信息实体
 */
@Entity
@Table(name = "emr_base_dept")
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseDept extends BaseEntity {

    /**
     * 院内科室代码
     */
    @Column(name = "dept_code", nullable = false, length = 50)
    private String deptCode;

    /**
     * 院内科室名称
     */
    @Column(name = "dept_name", nullable = false, length = 100)
    private String deptName;

    /**
     * 对应的前置软件科室代码
     */
    @Column(name = "target_dept_code", length = 50)
    private String targetDeptCode;

    /**
     * 对应的前置软件科室名称
     */
    @Column(name = "target_dept_name", length = 100)
    private String targetDeptName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;
}
