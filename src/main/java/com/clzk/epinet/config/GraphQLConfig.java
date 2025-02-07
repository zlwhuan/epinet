package com.clzk.epinet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.util.List;

@Configuration
public class GraphQLConfig {
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder
                .type("Query", builder -> builder.dataFetcher("books", env -> {
                    // 这里可以定义默认的 Query 解析方式
                    return List.of("1", "Spring Boot GraphQL", "John Doe");
                }));
    }
}