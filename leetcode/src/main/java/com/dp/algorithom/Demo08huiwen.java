package com.dp.algorithom;

/**
 * @author jiazhiyuan
 * @date 2021/12/5 4:53 下午
 */
public class Demo08huiwen {


    public int countSubstrings(String s) {
        int n = s.length();
        if(0 == n) {
            return 0;
        }
        int ans = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans ++;
        }
        for (int j = 1; j < n; j ++) {
            for(int i = 0; i < j; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i+1][j-1]);
                if(dp[i][j]) {
                    ans ++;
                }
            }
        }
        return ans;
    }
}



    
