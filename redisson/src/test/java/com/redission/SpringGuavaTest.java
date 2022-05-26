package com.redission;

/**
 * @author jiazhiyuan
 * @date 2022/5/22 12:13 下午
 */

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 集成spring/springboot
 * 1. spring: xml 或者 @Configuration
 * 2. springboot: starter和@Configuration
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:guava/spring-guava.xml"})
public class SpringGuavaTest {


}



    
