package com.clzk.epinet.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.clzk.epinet.base.repository",
        entityManagerFactoryRef = "baseEntityManagerFactory",
        transactionManagerRef = "baseTransactionManager"
)
public class BaseJpaConfig {

    // 手动创建 EntityManagerFactoryBuilder，不依赖默认 DataSource
    @Primary
    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder(JpaVendorAdapter jpaVendorAdapter) {
        // 可以在这里加全局 hibernate 属性，如果 application.yml 里 spring.jpa.* 没生效
        Map<String, Object> vendorProperties = new HashMap<>();
//        vendorProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        vendorProperties.put("hibernate.ddl-auto", "none");
        vendorProperties.put("hibernate.physical_naming_strategy",
                "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");

        return new EntityManagerFactoryBuilder(
                jpaVendorAdapter,
                vendorProperties,
                null  // persistenceUnitManager 可以为 null
        );
    }

    @Primary
    @Bean(name = "baseEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean baseEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {  // ← 用上面手动创建的 builder

        return builder
                .dataSource(baseDataSource())  // ← 手动注入你的主 DataSource
                .packages("com.clzk.epinet.base.model")
                .persistenceUnit("base")
                .build();
    }

    // 重新加回主 DataSource bean（用 spring.datasource 前缀绑定）
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource-base")
    public DataSource baseDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "baseTransactionManager")
    public PlatformTransactionManager baseTransactionManager(
            @Qualifier("baseEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}