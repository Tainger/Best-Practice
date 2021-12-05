package com.dp.package01;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jiazhiyuan
 * @date 2021/12/4 10:14 下午
 */
@Slf4j
public class Package01Test {

    private int[] w = new int[]{3, 2, 1};


    private int[] v = new int[]{5, 2, 3};


    /**
     * 示例: 输入:W = 5, N = 3      w = [3, 2, 1], v = [5, 2, 3]
     * 输出:8
     * 解释:选择 i=0 和 i=2 这两件物品装进背包。它们的总重量 4 小于 W,同时可以获得最大价值 8。
     */
    public static int dp(int[] w, int[] v, int N, int W) {
        //创建备忘录
        int[][] dp = new int[N + 1][W + 1];

        //初始化状态
        for (int i = 0; i < N + 1; i++) dp[i][0] = 0;
        for (int j = 0; j < W + 1; j++) dp[0][j] = 0;

        //遍历
        for (int tn = 1; tn < N + 1; tn++) {  //遍历一次商品
            for (int rw = 1; rw < W + 1; rw++) {  //背包容量有多大就遍历多少次
                //当背包剩余容量小于第tn件商品时，只放入前tn-1，
                if (rw < w[tn]) {
                    dp[tn][rw] = dp[tn - 1][rw];
                } else {
                    //当背包剩余容量大于
                    dp[tn][rw] = Math.max(dp[tn - 1][rw], dp[tn - 1][rw - w[tn]] + v[tn]);
                }
            }
        }
        return dp[N][W];
    }


    /*
     * tn: traversed n,即已经遍历过的物品;  * rw: reserved w,即背包还能容量的重量。
     * w[tn] 对应商品的重量， v[tn]对应商品的价值
     */
    public int DP(int tn, int rw) {
        // 当遍历完所有物品时,就该返回 0 了,因为没有物品也就没有价值了
        if (tn < 0) {
            return 0;
        }
        // 当背包还能容纳的重量已经小于当前物品的重量时,显然这个物品不能放入背包
        if (rw < w[tn]) {
            return DP(tn - 1, rw);
        }

        // 作出决策,该不该放入物品:
        //   1. 放入:那么价值是 DP(tn - 1, rw - w[tn]);
        //   2. 不放入:那么价值是 DP(tn - 1, rw)。

        return Math.max(DP(tn - 1, rw), DP(tn - 1, rw - w[tn]) + v[tn]);
    }


}




    
