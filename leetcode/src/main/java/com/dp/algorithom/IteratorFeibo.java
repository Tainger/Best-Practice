package com.dp.algorithom;

/**
 * @author jiazhiyuan
 * @date 2021/12/4 10:26 上午
 */
public class IteratorFeibo {

    public int getFeiboNaqie(int n) {

        int a = 0;
        int b = 1;
        if(n == 1) {
            return b;
        }
        int i = 1;
        int res = 0;
        while (i <= n) {
            res = a + b;
            a = b;
            b = res;
            i ++;
        }
        return res ;

    }


}



    
