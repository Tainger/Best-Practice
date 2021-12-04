package com.dp.algorithom;

/**
 * @author jiazhiyuan
 * @date 2021/12/4 10:56 上午
 */
public class Demo07BeiWangLuFeibonaqie {

    private int fibonacci(int n, int[] memo) {
        if (0 == n || 1 == n) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        // 看来备忘录中找到了之前计算的结果,既然找
        if (n > 1) {
            memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
            return memo[n];
        }
        return 0; // 如果数值无效(比如 < 0),则返回0
    }


    public int fibonacciAdvance(int n) {
        int[] memo = new int[n + 1];
        return fibonacci(n, memo);
    }

}



    
