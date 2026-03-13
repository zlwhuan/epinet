package com.clzk.epinet.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.clzk.epinet.emr.repository",
        entityManagerFactoryRef = "viewEntityManagerFactory",
        transactionManagerRef = "viewTransactionManager"
)
public class ViewJpaConfig {

    @Bean(name = "viewDataSource")
    @ConfigurationProperties(prefix = "spring.datasource-view")
    public DataSource viewDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "viewEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean viewEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("viewDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.clzk.epinet.emr.model")
                .persistenceUnit("view")
                .properties(jpaProperties())
                .build();
    }

    @Bean(name = "viewTransactionManager")
    public PlatformTransactionManager viewTransactionManager(
            @Qualifier("viewEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    private Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
        props.put("hibernate.format_sql", true);

        // 连接初始化 SQL：自动设置 NLS 格式
        props.put("hibernate.connection.init_sql",
                "ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS'; " +
                        "ALTER SESSION SET NLS_TIMESTAMP_FORMAT = 'YYYY-MM-DD HH24:MI:SS.FF'");

        return props;
    }
}