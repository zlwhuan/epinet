package com.clzk.epinet.enmu;

public enum Gender {
        UNKNOWN(0, "未知的性别"),
        MALE(1, "男"),
        FEMALE(2, "女"),
        UNDISCLOSED(9, "未说明的性别");

        private final int code;
        private final String description;

        Gender(int code, String description) {
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