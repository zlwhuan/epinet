package com.clzk.epinet.emr.model;

import com.clzk.epinet.base.model.BaseEntity;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 医院信息系统用户信息实体
 */
@Entity
@Table(name = "emr_base_user")
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseUser extends BaseEntity {

    /**
     * 所属机构代码
     */
    @Column(name = "org_code", nullable = false, length = 50)
    private String orgCode;

    /**
     * 所属科室代码
     */
    @Column(name = "dept_code", nullable = false, length = 50)
    private String deptCode;

    /**
     * 用户姓名
     */
    @Column(name = "user_name", nullable = false, length = 100)
    private String userName;

    /**
     * 身份证件类别代码
     */
    @Column(name = "id_card_type_code", length = 10)
    private String idCardTypeCode;

    /**
     * 身份证件号码
     */
    @Column(name = "id_card", length = 20)
    private String idCard;

    /**
     * 联系电话
     */
    @Column(name = "tel", length = 20)
    private String tel;

    /**
     * 医师执业资格证号
     */
    @Column(name = "physician_no", length = 50)
    private String physicianNo;

    /**
     * 登录名
     */
    @Column(name = "login_name", nullable = false, length = 50)
    private String loginName;

    /**
     * 用户类型代码
     */
    @Column(name = "user_type_code", length = 10)
    private String userTypeCode;

    /**
     * 用户创建时间
     */
    @Column(name = "create_time", nullable = false)
    private String createTime;
}
