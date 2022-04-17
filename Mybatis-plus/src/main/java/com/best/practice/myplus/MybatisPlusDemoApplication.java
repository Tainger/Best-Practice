package com.best.practice.myplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jiazhiyuan
 * @date 2022/2/6 8:05 下午
 */

@SpringBootApplication
@MapperScan("com.best.practice.myplus.mapper")
public class MybatisPlusDemoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.close();
    }
}



    
