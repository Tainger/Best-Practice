package com.dp.algorithom;

/**
 * @author jiazhiyuan
 * @date 2021/12/5 5:43 下午
 */
public class Demo08MaxSubArray {



    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int m = nums.length;
        int[][] dp = new int[m][m];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < m; j ++) {
                if(i == j) {
                    dp[i][i] = nums[i];
                }
            }
        }

        for(int i = 0; i < nums.length; i ++) {
            for(int j = 0; j <= i; j ++) {
                if(i == j) {
                    max = Math.max(dp[i][j], max);
                    continue;
                }

                if(i-1 < j +1) {
                    dp[i][j] =  dp[j][j] + nums[i];
                }else {
                    dp[i][j] =  dp[i-1][j+1] + nums[j] +  nums[i];
                }

                max = Math.max(dp[i][j], max);
            }
        }

        return max;

    }
}



    
