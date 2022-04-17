package com.best.practice;

import com.best.practice.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Halo main class.
 *
 * @author ryanwang
 * @date 2017-11-14
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // Run application
        SpringApplication.run(Application.class, args);
    }

}
