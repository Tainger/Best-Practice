package com.proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jiazhiyuan
 * @date 2022/11/4 4:09 下午
 */
public class ProxyInvocationHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //生成得到 (动态的)  代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        //动态代理的本质，就是使用反射机制实现；
        return method.invoke(target, args);
    }

    //日志方法：
    public void log(String msg){
        System.out.println("【debug】使用了"+msg+"方法");
    }

    public static void main(String[] args) {

        //真实角色
        UserServiceImpl userService = new UserServiceImpl();

        //代理角色，不存在的
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService);//设置要代理的对象；

        //动态生成代理类
        UserService proxy = (UserService) pih.getProxy();
        proxy.select();
        proxy.add();

    }
}



    
