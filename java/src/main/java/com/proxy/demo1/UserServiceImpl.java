package com.proxy.demo1;

/**
 * @author jiazhiyuan
 * @date 2022/11/4 4:07 下午
 */
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("增添一个方法");
    }

    @Override
    public void delete() {
        System.out.println("删除一个方法");
    }

    @Override
    public void update() {
        System.out.println("修改一个方法");
    }

    @Override
    public void select() {
        System.out.println("查询一个方法");
    }
}



    
