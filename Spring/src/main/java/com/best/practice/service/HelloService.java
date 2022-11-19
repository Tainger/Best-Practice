package com.best.practice.service;

import javax.validation.constraints.NotNull;

public interface HelloService {
    public void sayHello();


    @NotNull
    public String testNotNull();
}
