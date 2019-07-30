//package com.nexign.utils;
//
//import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
//import org.hibernate.SessionFactory;
////import org.hibernate.cfg.Configuration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import java.util.Properties;
//
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan
//public class HibernateConf {
//
//    @Bean
////    public SessionFactory sessionFactory() {
////        return new Configuration().configure().buildSessionFactory();
////    }
//
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan(
//                "com.nexign.models");
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }
//
//    @Bean
//    public BasicDataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/newtestbase?useLegacyDatetimeCode=false&serverTimezone=UTC");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        return dataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager hibernateTransactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//        return transactionManager;
//    }
//
//    private final Properties hibernateProperties() {
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty(
//                "hibernate.hbm2ddl.auto", "validate");
//        hibernateProperties.setProperty(
//                "hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
//        hibernateProperties.setProperty(
//                "show_sql", "true");
//        return hibernateProperties;
//    }
//}