package com.dp.algorithom;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author jiazhiyuan
 * @date 2021/12/4 10:56 上午
 */
public class Demo05RecursionOptimizeCoin {


    public void getMinCountsHelper(int total, int[] values, ArrayList<Integer> currentCounts, ArrayList<ArrayList<Integer>> combinations) {
        if (0 == total) { // 如果余额为0,说明当前组合成立,将组合加入到待选数组中
            combinations.add(new ArrayList<Integer>(currentCounts));
            return;
        }
        int valueLength = values.length;
        for (int i = 0; i < valueLength; i++) { // 遍历所有面值
            int currentValue = values[i];
            if (currentValue > total) {
                // 如果面值大于当前总额,直接跳过
                continue;
            }         // 否则在当前面值数量组合上的对应位置加1
            ArrayList<Integer> newCounts = new ArrayList<Integer>(currentCounts);
            newCounts.set(i, newCounts.get(i) + 1);
            int rest = total - currentValue;
            getMinCountsHelper(rest, values, newCounts, combinations); // 求解剩余额
        }
    }

    int getMinimumHelper(ArrayList<ArrayList<Integer>> combinations) {     // 如果没有可用组合,返回-1
        if (0 == combinations.size()) {
            return -1;
        }
        int minCount = Integer.MAX_VALUE;
        for (ArrayList<Integer> counts : combinations) {
            int total = 0; // 求当前组合的硬币总数
            for (int count : counts) {
                total += count;
            }         // 保留最小的
            if (total < minCount) {
                minCount = total;
            }
        }
        return minCount;
    }


    public int getMinCountOfCoins() {
//        int[] values = {5, 3};
//        // 硬币面值的数组
//        int total = 11; // 总值
//        ArrayList<Integer> initialCounts = new ArrayList<>(Collections.nCopies(val);
//        ArrayList<ArrayList<Integer>> coinCombinations = new ArrayList<>(); // 存储
//        getMinCountsHelper(total, values, initialCounts, coinCombinations);
//        // 求解
//        return getMinimumHelper(coinCombinations); // 输出答案
        return 0;
    }
}



    
