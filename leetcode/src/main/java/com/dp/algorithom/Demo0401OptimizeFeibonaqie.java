package com.dp.algorithom;

/**
 * @author jiazhiyuan
 * @date 2021/12/4 5:52 下午
 */
public class Demo0401OptimizeFeibonaqie {


    private int fibonacci(int n, int[] memo) {
        if (0 == n || 1 == n) {
            return n;
        }
        memo[0] = 0;
        memo[1] = 1;
        if(n >= 1) {
            int i = 2;
            for(; i <= n; i ++) {
                memo[i] = memo[i-1] + memo[i-2];
            }
            return memo[i-1];
        }
        return 0; // 如果数值无效(比如 < 0),则返回0
    }


    public int fibonacciAdvance(int n) {
        int[] memo = new int[n + 1];
        return fibonacci(n, memo);
    }
}



    
