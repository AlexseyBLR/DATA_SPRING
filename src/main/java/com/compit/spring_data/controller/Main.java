package com.compit.spring_data.controller;

import com.compit.spring_data.entity.Test;
import com.compit.spring_data.service.TestService;
import com.compit.spring_data.utils.DataConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
        TestService testService = context.getBean(TestService.class);
        for (Test test : testService.getAll()) {
            System.out.println(test);
        }
    }

}
