package com.dp.algorithom;

/**
 * @author jiazhiyuan
 * @date 2021/12/5 4:53 下午
 */
public class Demo08huiwenMaxString {


    public String longestPalindrome(String s) {
        int n = s.length();
        if (0 == n) {
            return "";
        }
        int length = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]);
            }
        }
        int resA = 0;
        int resB = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j]) {
                    if ((resB - resA) < (j - i)) {
                        resB = j;
                        resA = i;
                    }
                }
            }
        }
        return s.substring(resA, resB);
    }

}



    
