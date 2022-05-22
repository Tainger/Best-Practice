package com.redission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

import javax.sql.DataSource;

/**
 * @author jiazhiyuan
 * @date 2022/5/20 9:47 下午
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching
public class RedissionApplication {

    public static void main(String[] args) {
        // Run application
        SpringApplication.run(RedissionApplication.class, args);
    }
}



    
