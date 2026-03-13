package com.clzk.epinet.base.dto;

import lombok.Data;

@Data
public class ApiResponse {

    private Boolean result = true;
    private String desc;
    private String errorCode;
    private String errorName;

    /**
     * 01	数据入库失败	数据接收接口无法存储入库时提示
     * 02	授权错误	无权限访问API 接口时提示
     * 03	参数格式错误	调用接口格式异常时提示
     * 04	数据校验错误	数据接收无法通过校验时提示
     * 05	文档转换异常	接收到 API 接口无法识别的参数格式时提示
     * 99	系统异常	API 接口遇到无法捕获或处理的异常时提示
     */
    private String msg;


    private String id;

    public static ApiResponse ok() {
        ApiResponse response = new ApiResponse();
        response.setResult(true);
        response.setDesc("操作成功");
        return response;
    }

    public static ApiResponse ok(String msg) {
        ApiResponse response = new ApiResponse();
        response.setResult(true);
        response.setDesc(msg);
        return response;
    }


    public static ApiResponse error(String errorMsg) {
        ApiResponse response = new ApiResponse();
        response.setResult(false);
        response.setMsg(errorMsg);
        return response;
    }

}
