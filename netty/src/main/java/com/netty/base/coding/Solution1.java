package com.netty.base.coding;

/**
 * @author jiazhiyuan
 * @date 2021/11/19 8:17 下午
 */
public class Solution1 {


    public static int getTarget(int[] arrs, int target) {

        int flag = Integer.MAX_VALUE;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < arrs.length - 2; i++) {
            for (int j = i + 1; j < arrs.length - 1; j++) {
                for (int k = j + 1; k < arrs.length; k++) {
                    sum = arrs[i] + arrs[j] + arrs[k];
                    int temp = Math.abs(sum - target);
                    if (Math.min(temp, flag) == temp) {
                        flag = temp;
                        res = sum;
                        String format = String.format("i: %d, j: %d, k: %d, flag: %d, temp: %d, res: %d", i, j, k, flag, temp, res);
                        System.out.println(format);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

//        int []arr = new int[]{-1, 2, 1, -4};
//
//        int target = 1;
//
//        int res = getTarget(arr, 1);
//        System.out.println(res);


        int []arr = new int[]{0,0,0};

        int target = 1;

        int res = getTarget(arr, 1);
        System.out.println(res);


    }
}



    
