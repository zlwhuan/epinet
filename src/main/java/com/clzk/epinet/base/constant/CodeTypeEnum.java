package com.clzk.epinet.base.constant;

import com.clzk.epinet.base.dto.DictionaryDataDTO;
import lombok.Getter;

@Getter
public enum CodeTypeEnum {

    ORG("0", "组织机构编码", "orgCode"),
    DEPARTMENT("24", "科室代码表", "deptCode"),
    ID_DOCUMENT_TYPE("1", "身份证件类别代码", "idCardTypeCode"),
    GENDER("2", "性别代码", "genderCode"),
    ETHNICITY("3", "民族代码", "nationCode"),
    MARITAL_STATUS("4", "婚姻状况代码", "maritalStatusCode"),
//    REGION_OR_ORG("5", "地区/机构代码", "orgCode"),
    MEDICINE("6", "药品代码", "drugCode"),
    //    EXAM_CATEGORY("7", "检查类别代码", "examinationTypeCode"),
//    EXAM_ITEM("8", "检查项目代码", "itemCode"),
    EXAM_RESULT("9", "检查结果代码", "examinationResultCodeClinical"),
    TEST_RESULT("10", "检验结果代码", "examinationResultCodeLab"),
    ICD10_INFECTIOUS("11", "传染病诊断 ICD10 代码", "wmDiseaseCode"),
    //    NATIONALITY("12", "国籍代码", "nationalityCode"),
    EDUCATION_LEVEL("13", "文化程度代码", "educationCode"),
    REGISTERED_ADDRESS_TYPE("14", "户籍地址类别代码", "permanentAddrCode"),
    CURRENT_ADDRESS_TYPE("15", "现住址类别代码", "currentAddrCode"),
    POPULATION_CATEGORY("16", "人群分类代码", "nultitudeTypeCode"),
    CASE_CLASSIFICATION("17", "病例分类代码", "diagnoseStateCode"),
    //    DIAGNOSIS_STATUS("18", "诊断状态代码", "caseTypeCode"),
//    INFECTIOUS_ROUTE("19", "传染病报告卡-血源及性传播/感染途径代码", "bsTransmissionCode"),
//    INFECTIOUS_DIRECT_CAUSE("20", "传染病报告卡-直接死亡诊断代码", "symptomsCode"),
//    DISCOVERY_METHOD("21", "发现方式代码", "discoveryModeCode"),
//    CONTACT_METHOD("22", "传染病报告卡-接触方式代码", "contactTypeCode"),
//    COVID_SEVERITY("23", "传染病报告卡-新冠临床严重程度代码", "ncvSeverityCode"),
    TREATMENT_TYPE("25", "诊疗活动类型代码", "activityTypeCode");
//    TCM_DISEASE_SYNDROME("26", "中医病证分类与代码", "Code"),
//    TCM_TERMINOLOGY("27", "中医临床诊疗术语代码", "Code"),
//    FAMILY_RELATIONSHIP("28", "家庭关系代码", "Code"),
//    PAYMENT_METHOD("29", "医疗付费方式代码", "payMethodCode"),
//    SAMPLE_TYPE("30", "标本类别代码", "specimenCategoryCode"),
//    MEDICINE_DOSE_UNIT("31", "药物剂量单位代码", "drugDosageUnitCode"),
//    CONDITION_OUTCOME("32", "病情转归代码表", "diseaseProgressionCode");

    private final String code;
    private final String name;
    private final String fieldName;

    CodeTypeEnum(String code, String name, String fieldName) {
        this.code = code;
        this.name = name;
        this.fieldName = fieldName;
    }

    public static CodeTypeEnum fromCode(String code) {
        for (CodeTypeEnum value : CodeTypeEnum.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }

    public DictionaryDataDTO toDictionaryDataDTO() {
        return new DictionaryDataDTO(this.code, this.name, null);
    }
}
