package com.clzk.epinet.base.aspect;

import com.clzk.epinet.base.service.ApiCallLogService;
import com.clzk.epinet.config.EmrApiConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class ApiLogAspect {

    @Autowired
    private ApiCallLogService apiCallLogService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmrApiConfig emrApiConfig;

    @Around("@annotation(com.clzk.epinet.base.model.ApiLog)")
    public Object logApiCall(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
//        LocalDateTime requestTime = LocalDateTime.now();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
//        ApiLog apiLogAnnotation = method.getAnnotation(ApiLog.class);

        String interfaceName = joinPoint.getArgs()[0].toString().replace(emrApiConfig.getBaseUrl() + "/hclient/emr/receive/", "");

        String requestParams = getParamsJson(joinPoint.getArgs()[1]);

        String status = "success";
        String responseResult = null;
        String errorMessage = null;

        try {
            Object result = joinPoint.proceed(); // 执行目标方法
            responseResult = objectMapper.writeValueAsString(result);
            if (responseResult != null && responseResult.contains("false")) {
                status = "failed";
            }
            return result;
        } catch (Throwable ex) {
            status = "failed";
            errorMessage = ex.getMessage();
            throw ex;
        } finally {
            long duration = System.currentTimeMillis() - start;
            apiCallLogService.logApiCall(
                    interfaceName,
                    requestParams,
                    responseResult,
                    status,
                    errorMessage,
                    duration
            );
            log.info("接口 [{}] 调用完成，用时 {} ms", interfaceName, duration);
        }
    }

    private String getParamsJson(Object arg) {
        try {
            return objectMapper.writeValueAsString(arg);
        } catch (Exception e) {
            return arg.toString();
        }
    }
}
