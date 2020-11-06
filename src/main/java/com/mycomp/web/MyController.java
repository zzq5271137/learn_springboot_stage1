package com.mycomp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class MyController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/hello")
    public String hello() {
        return "hello from spring boot";
    }

    @RequestMapping("/testdb")
    public String testdb() {
        return dataSource.toString();
    }

}
