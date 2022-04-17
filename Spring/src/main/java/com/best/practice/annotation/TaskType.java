package com.best.practice.annotation;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Component
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TaskType {

    int type() ;

    String name() default "";

    Class handle() default  Void.class;
}
