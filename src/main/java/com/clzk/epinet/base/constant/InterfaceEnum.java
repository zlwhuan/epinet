package com.clzk.epinet.base.constant;

import com.clzk.epinet.base.dto.DictionaryDataDTO;
import lombok.Getter;

@Getter
public enum InterfaceEnum {
    emrPatientInfo("emrPatientInfo", "患者基本信息"),
    emrActivityInfo("emrActivityInfo", "诊疗活动信息"),
    emrInfReport("emrInfReport", "传染病报告卡"),
    emrOutpatientRecord("emrOutpatientRecord", "门(急)诊病历"),
    emrOutpatientObs("emrOutpatientObs", "门(急)诊留观记录"),
    emrAdmissionInfo("emrAdmissionInfo", "入院记录"),
    emrFirstCourse("emrFirstCourse", "住院首次病程记录"),
    emrDailyCourse("emrDailyCourse", "住院日常病程记录"),
    emrAdmissionRecord("emrAdmissionRecord", "住院病案页"),
    emrDischargeInfo("emrDischargeInfo", "出院记录"),
    emrExClinical("emrExClinical", "检查报告"),
    emrExClinicalItem("emrExClinicalItem", "检查报告项目"),
    emrExLab("emrExLab", "检验报告"),
    emrExLabItem("emrExLabItem", "检验报告项目"),
    emrOrder("emrOrder", "医嘱处方信息"),
    emrOrderItem("emrOrderItem", "医嘱处方条目"),
    emrDeathInfo("emrDeathInfo", "死亡信息"),
    emrVitalSignsRecord("emrVitalSignsRecord", "生命体征护理记录单"),
    baseUser("baseUser", "用户信息"),
    baseDept("baseDept", "科室信息");

    private final String code;
    private final String name;


    InterfaceEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public DictionaryDataDTO toDictionaryDataDTO() {
        return new DictionaryDataDTO(this.code, this.name, null);
    }
}
