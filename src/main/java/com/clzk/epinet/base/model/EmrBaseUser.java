package com.clzk.epinet.base.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 医院信息系统用户信息实体
 */
@Entity
@Table(name = "crb_base_user")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmrBaseUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 80)
    private String id;

    /**
     * 所属机构代码
     */
    @Column(name = "ORG_CODE", length = 9)
    private String orgCode;

    /**
     * 所属科室代码
     */
    @Column(name = "DEPT_CODE", length = 20)
    private String deptCode;

    /**
     * 用户姓名
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 身份证件类别代码
     */
    @Column(name = "ID_CARD_TYPE_CODE", length = 2)
    private String idCardTypeCode;

    /**
     * 身份证件号码
     */
    @Column(name = "ID_CARD", length = 50)
    private String idCard;

    /**
     * 联系电话
     */
    @Column(name = "TEL", length = 70)
    private String tel;

    /**
     * 医师执业资格证号
     */
    @Column(name = "PHYSICIAN_NO")
    private String physicianNo;

    /**
     * 登录名
     */
    @Column(name = "LOGIN_NAME")
    private String loginName;

    /**
     * 用户类型代码
     */
    @Column(name = "USER_TYPE_CODE")
    private String userTypeCode;

    /**
     * 用户创建时间
     */
    @Column(name = "CREATE_TIME", columnDefinition = "DATE")
    private Timestamp createTime;
}
