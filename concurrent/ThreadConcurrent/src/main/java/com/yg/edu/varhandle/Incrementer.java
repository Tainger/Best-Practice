package com.yg.edu.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * @author jiazhiyuan
 * @date 2021/10/24 7:58 下午
 */
public class Incrementer implements Runnable{
    private Account account;

    public Incrementer(Account account) {
        super();
        this.account = account;
    }

    @Override
    public void run() {
        VarHandle handler;
        try {
            for (int i = 0; i < 10000; i++) {
                handler = MethodHandles.lookup().in(Account.class).findVarHandle(Account.class, "amount", double.class);
                handler.getAndAdd(account, 100);
                account.unsafeAmount += 100;
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}



    
