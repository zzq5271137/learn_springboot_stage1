package com.mycomp.config;

/*
 * @Configuration: 声明一个类作为配置类, 代替xml文件
 * @Bean: 声明在方法上, 将方法的返回值加入Bean容器, 代替<bean>标签
 * @value: 属性注入
 * @PropertySource: 指定外部属性文件
 */

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
// @PropertySource("classpath:jdbc.properties")
// @EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {

    /*
     * 方式一:
     * 直接将jdbc.properties属性文件内的值, 注入进来使用;
     * 需要在配置类上使用@PropertySource注解, 注明属性文件的位置, 例如:
     * @PropertySource("classpath:jdbc.properties")
     */
    // @Value("${jdbc.driver}")
    // private String driver;
    // @Value("${jdbc.url}")
    // private String url;
    // @Value("${jdbc.username}")
    // private String username;
    // @Value("${jdbc.password}")
    // private String password;

    /*
     * 方式二(1):
     * 使用属性类来管理属性文件的方式(属性文件的名称必须为"application.properties"), 属性类详见: JdbcProperties.java
     * 需要在配置类上使用@EnableConfigurationProperties注解, 注明属性类, 例如:
     * @EnableConfigurationProperties(JdbcProperties.class)
     *
     * 此处, 演示直接将属性类的对象注入进来
     */
    // @Autowired
    // private JdbcProperties jdbcProperties;

    /*
     * 方式二(2):
     * 使用属性类来管理属性文件的方式(属性文件的名称必须为"application.properties"), 属性类详见: JdbcProperties.java
     * 需要在配置类上使用@EnableConfigurationProperties注解, 注明属性类, 例如:
     * @EnableConfigurationProperties(JdbcProperties.class)
     *
     * 此处, 演示将属性类的对象作为参数传进来
     */
    // @Bean
    // public DataSource dataSource(JdbcProperties jdbcProperties) {
    //     DruidDataSource dataSource = new DruidDataSource();
    //     dataSource.setDriverClassName(jdbcProperties.getDriver());
    //     dataSource.setUrl(jdbcProperties.getUrl());
    //     dataSource.setUsername(jdbcProperties.getUsername());
    //     dataSource.setPassword(jdbcProperties.getPassword());
    //     return dataSource;
    // }

    /*
     * 方式三:
     * 使用属性直接注入的方式(不需要JdbcProperties.java了), 要求属性文件中的属性名称, 与该类中的属性名称相同;
     * 所以这里, 需要将application.properties中的”jdbc.driver“改成"jdbc.driverClassName";
     *
     * 这种方式, 只适用于prefix为"jdbc"的这些属性, 只会给DataSource这一个对象使用,
     * 因为@ConfigurationProperties(prefix = "jdbc")注解中的prefix值, 全局只能存在一份;
     * 当属性值是公用的时候, 推荐使用方式二, 即属性类的方式, 去管理属性值;
     *
     * 为了演示, 需要把JdbcProperties.java中的@ConfigurationProperties(prefix = "jdbc")注解给注释掉,
     * 因为@ConfigurationProperties(prefix = "jdbc")注解中的prefix值, 全局只能存在一份;
     */
    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

}
