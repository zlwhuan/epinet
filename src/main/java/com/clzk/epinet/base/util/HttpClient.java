package com.clzk.epinet.base.util;

import com.clzk.epinet.base.dto.ApiResponse;
import com.clzk.epinet.base.model.ApiLog;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class HttpClient {

    private final RestTemplate restTemplate;

    public HttpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ApiResponse get(String url) {
        return sendRequest(url, HttpMethod.GET);
    }

    @ApiLog("同步数据")
    public ApiResponse post(String url, Object requestBody) {
        return sendRequest(url, HttpMethod.POST, requestBody);
    }

    public ApiResponse delete(String url) {
        return sendRequest(url, HttpMethod.DELETE);
    }

    // 发起请求，返回 ApiResponse
    public ApiResponse sendRequest(String url, HttpMethod method, Object requestBody) {
        try {
            // 创建请求头
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // 创建请求实体
            HttpEntity<Object> entity = new HttpEntity<>(requestBody, headers);

            // 发送请求并获取响应
            ResponseEntity<ApiResponse> responseEntity = restTemplate.exchange(url, method, entity, ApiResponse.class);
// 使用 Jackson 转换为 JSON 字符串
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonBody = objectMapper.writeValueAsString(requestBody);
            System.out.println("Request Body JSON: " + jsonBody);
            // 返回封装后的响应数据
            return responseEntity.getBody();
        } catch (Exception e) {
            // 异常处理，返回错误信息
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setResult(false);
            apiResponse.setDesc(e.getMessage());
            return apiResponse;
        }
    }

    // 不需要请求体的请求
    public ApiResponse sendRequest(String url, HttpMethod method) {
        try {
            // 发送请求并获取响应
            ResponseEntity<ApiResponse> responseEntity = restTemplate.exchange(url, method, null, ApiResponse.class);

            // 返回封装后的响应数据
            return responseEntity.getBody();
        } catch (Exception e) {
            // 异常处理，返回错误信息
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setResult(false);
            apiResponse.setDesc(e.getMessage());
            return apiResponse;
        }
    }
}
