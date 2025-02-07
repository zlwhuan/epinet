package com.clzk.epinet.enmu;

public enum DiseaseSeverity {
        MILD(2, "轻型"),
        SEVERE(3, "重型"),
        CRITICAL(4, "危重型"),
        ASYMPTOMATIC(5, "无症状感染者"),
        MODERATE(6, "中型"),
        NON_HOSPITALIZED(7, "非住院病例"),
        HOSPITALIZED(8, "普通住院病例"),
        ICU(9, "ICU 病例");

        private final int code;
        private final String description;

        DiseaseSeverity(int code, String description) {
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