package com.mycomp.config;

/*
 * 属性类:
 * 属性文件的名称必须为"application.properties"
 */

import lombok.Data;

/*
 * 为了演示JdbcConfig.java中的方式三, 需要把此处的注解给注释掉,
 * 因为@ConfigurationProperties(prefix = "jdbc")注解中的prefix值, 全局只能存在一份
 */
//@ConfigurationProperties(prefix = "jdbc")
@Data
public class JdbcProperties {

    private String driver;
    private String url;
    private String username;
    private String password;

}
