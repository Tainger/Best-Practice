package designpattern.chainOfResponsibility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author jiazhiyuan
 * @date 2021/11/15 9:55 下午
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.nextLine();
            String[] arr =  a.split(",");

            List<Integer> list = new ArrayList();
            for(int i = 0; i < arr.length; i++) {
                list.add(parseString(arr[i]));
            }



//            StringBuilder stringBuilder = new StringBuilder();
//
//            Collections.sort(list);
//
//            for (int i = list.size() - 1; i >= 0; i--) {
//                stringBuilder.append(list.get(i));
//            }
//            System.out.println(stringBuilder);
        }


    }
    private static int parseString(String a){
        return Integer.parseInt(a);
    }
}


    
