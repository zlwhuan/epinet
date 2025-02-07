package com.clzk.epinet.enmu;

public enum RiskLevel {
        NONE(1, "无"),
        LOW(2, "低"),
        MEDIUM(3, "中"),
        HIGH(4, "高"),
        VERY_HIGH(5, "极高");

        private final int code;
        private final String description;

        RiskLevel(int code, String description) {
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