package com.proxy.demo2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author jiazhiyuan
 * @date 2022/11/4 4:23 下午
 */
public class UserServiceCGlib implements MethodInterceptor {

    /**
     *
     */
    private Object target;

    public UserServiceCGlib() {

    }

    public UserServiceCGlib(Object target) {
        this.target = target;
    }

    //返回一个代理对象:    是 target对象的代理对象
    public Object getProxyInstance() {
        //1. 创建一个工具类
        Enhancer enhancer = new Enhancer();
        //2. 设置父类
        enhancer.setSuperclass(target.getClass());
        //3. 设置回调函数
        enhancer.setCallback(this);
        //4. 创建子类对象，即代理对象
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强开始~~~");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("增强结束~~~");
        return result;
    }

    public static void main(String[] args) {

        UserServiceCGlib userServiceCGlib = new UserServiceCGlib(new UserServiceImpl());
        UserServiceImpl proxyInstance = (UserServiceImpl) userServiceCGlib.getProxyInstance();

        proxyInstance.addUser();
        System.out.println();
        proxyInstance.deleteUser();

    }
}



    
