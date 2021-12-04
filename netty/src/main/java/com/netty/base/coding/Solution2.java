package com.netty.base.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiazhiyuan
 * @date 2021/11/19 8:17 下午
 */
public class Solution2 {


    private static final List<String> table = Arrays.asList("a","b","c", "d", "e", "f");


    public static boolean getTarget(String pattern, String str) {

        int tableIndex = 0;
        Map<String, String> record = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        String[] strArrays = str.split(" ");
        for (int i = 0; i < strArrays.length; i++) {

            String arr = strArrays[i];
            if(!record.containsKey(arr)){
                record.put(arr, table.get(tableIndex));
                //todo check if out of index
                tableIndex++;
            }

            String subStr = record.get(arr);
            stringBuilder.append(subStr);
        }

        return  stringBuilder.toString().equals(pattern);
    }

    public static void main(String[] args) {
        System.out.println("case1: ===========================");
        String pattern = "abba";
        String str = "dog cat cat dog";
        boolean target = getTarget(pattern, str);
        System.out.println(target);

        System.out.println("case2: ===========================");
        String pattern1 = "abba";
        String str1 = "dog cat cat fish";
        boolean target1 = getTarget(pattern1, str1);
        System.out.println(target1);

        System.out.println("case3: ===========================");
        String pattern2 = "aaaa";
        String str2 = "dog cat cat fish";
        boolean target2 = getTarget(pattern2, str2);
        System.out.println(target2);

        System.out.println("case4: ===========================");
        String pattern3 = "aaaa";
        String str3 = "dog cat cat fish";
        boolean target3 = getTarget(pattern3, str3);
        System.out.println(target3);
    }
}



    
