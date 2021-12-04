package com.dp.algorithom;

/**
 * @author jiazhiyuan
 * @date 2021/12/3 11:44 下午
 */
public class Tanxin {


    /**
     *
     * @param total  要凑够的面值
     * @param values  硬币数组
     * @param valueCount  硬币的种类
     * @return
     */
    public int getMinCoinCountHelper(int total, int[] values, int valueCount) {
        int rest = total;
        int count = 0;
        for(int i = 0; i < values.length; i ++) {
            int useCount  = rest / values[i];
            rest = rest - useCount * values[i];
            count += useCount;
            if(rest == 0) {
                return count;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        int[] values = {5, 3};    //硬币面值
        int total = 11;

        Tanxin tanxin = new Tanxin();
        int minCoinCountHelper = tanxin.getMinCoinCountHelper(11, values, 2);
        System.out.println(minCoinCountHelper);
    }
}



    
