package com.charon.boot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @description: 配置主数据源
 * @author: charon
 * @create: 2020-01-06 15:48
 **/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryPrimary",
        transactionManagerRef="transactionManagerPrimary",
        // 设置Repository所在位置
        basePackages= { "com.charon.boot.jpa.bootjpa" })
public class JPAPrimaryConfig {

    @Resource
    @Qualifier("primaryDataSource")
    // primary数据源注入
    private DataSource primaryDataSource;

    /**
     * primary实体管理器
     *
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "entityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }


    /**
     *primary实体工厂
     *
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "entityManagerFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(primaryDataSource)
                .properties(getVendorProperties())
                // 设置实体类所在位置
                .packages("com.charon.boot.jpa.bootjpa")
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }



    @Resource
    private JpaProperties jpaProperties;

    private Map getVendorProperties() {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }


    /**
     * primary事务管理器
     *
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "transactionManagerPrimary")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }
}
