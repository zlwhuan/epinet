package com.clzk.epinet.enmu;

public enum TreatmentType {
        MEDICATION(1, "药物"),
        SURGERY(2, "手术"),
        NO_TREATMENT(3, "未治疗"),
        RESPIRATORY_ASSISTANCE(4, "呼吸辅助"),
        INITIAL_MEDICATION(5, "首次用药"),
        FOLLOW_UP_MEDICATION(6, "随访用药"),
        OTHER(99, "其他");

        private final int code;
        private final String description;

        TreatmentType(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }