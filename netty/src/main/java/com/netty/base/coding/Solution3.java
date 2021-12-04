package com.netty.base.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiazhiyuan
 * @date 2021/11/19 8:17 下午
 */
public class Solution3 {

    public int getTarget(String []arr, String str) {
        for(int i = 0; i< arr.length; i ++) {
            str = str.replace(arr[i], "");
        }
        return str.length();
    }
}



    
