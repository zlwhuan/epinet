package com.clzk.epinet.enmu;

public enum MaritalStatus {
        SINGLE(1, "未婚"),
        MARRIED(2, "已婚或有配偶"),
        DIVORCED_WIDOWED(3, "离异或丧偶"),
        UNKNOWN(4, "不详");

        private final int code;
        private final String description;

        MaritalStatus(int code, String description) {
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