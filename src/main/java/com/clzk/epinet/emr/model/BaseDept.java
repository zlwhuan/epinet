package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 医院信息系统科室信息实体
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CRB_BASE_DEPT")
@Data
public class BaseDept extends BaseEntity {

    @Id
    @Column(name = "DEPT_CODE", length = 20)
    private String deptCode;
    @Column(name = "DEPT_NAME", length = 50)
    private String deptName;
    @Column(name = "TARGET_DEPT_CODE", length = 20)
    private String targetDeptCode;
    @Column(name = "TARGET_DEPT_NAME", length = 50)
    private String targetDeptName;
    @Column(name = "CREATE_TIME", length = 20)
    private LocalDateTime createTime;

}
