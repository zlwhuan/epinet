package com.clzk.epinet.enmu;

public enum CaseClassification {
        CLINICAL(1, "临床诊断病例"),
        CONFIRMED(2, "实验室确诊病例"),
        SUSPECTED(3, "疑似病例"),
        CARRIER(4, "病原携带者"),
        POSITIVE_TEST(5, "阳性检测"),
        EBOLA_OBSERVATION(6, "埃博拉留观病例");

        private final int code;
        private final String description;

        CaseClassification(int code, String description) {
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
