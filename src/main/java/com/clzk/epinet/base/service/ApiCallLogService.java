package com.clzk.epinet.base.service;

import com.clzk.epinet.base.model.ApiCallLog;
import com.clzk.epinet.base.repository.ApiCallLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ApiCallLogService {

    @Autowired
    private ApiCallLogRepository apiCallLogRepository;

    public void logApiCall(String interfaceName, String requestParams, String responseResult, 
                           String status, String errorMessage, Long durationMs) {
        ApiCallLog log = new ApiCallLog();
        log.setInterfaceName(interfaceName);
        log.setRequestTime(LocalDateTime.now());
        log.setResponseTime(LocalDateTime.now());
        log.setRequestParams(requestParams);
        log.setResponseResult(responseResult);
        log.setStatus(status);
        log.setErrorMessage(errorMessage);
        log.setDurationMs(durationMs);
        log.setCreatedAt(LocalDateTime.now());

        apiCallLogRepository.save(log);
    }
}
