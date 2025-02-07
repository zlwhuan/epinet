package com.clzk.epinet.enmu;

public enum EducationLevel {
        ILLITERATE(1, "文盲"),
        PRIMARY(2, "小学"),
        MIDDLE_SCHOOL(3, "初中"),
        HIGH_SCHOOL(4, "高中或中专"),
        COLLEGE(5, "大专及以上");

        private final int code;
        private final String description;

        EducationLevel(int code, String description) {
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