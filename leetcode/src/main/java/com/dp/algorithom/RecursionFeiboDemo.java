package com.dp.algorithom;

/**
 * @author jiazhiyuan
 * @date 2021/12/4 10:39 上午
 */
public class RecursionFeiboDemo {



    public int feibonaqie(int n){

        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        return  feibonaqie(n -1) + feibonaqie(n -2);
    }
}



    
