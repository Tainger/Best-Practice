package com.dp.algorithom;


import com.dp.package01.Package01Test;
import org.junit.Test;

/**
 * @author jiazhiyuan
 * @date 2021/12/3 11:42 下午
 */
public class Main {


    /***
     * 没有回溯的贪心
     */
    @Test
    public void basicTanXin() {
        // 贪心算法
        int[] values = {5, 3};    //硬币面值
        int total = 11;
        Tanxin tanxin = new Tanxin();
        int minCoinCountHelper = tanxin.getMinCoinCountHelper(11, values, 2);
        System.out.println(minCoinCountHelper);

    }


    /***
     * 使用回溯优化贪心
     */
    @Test
    public void basicTanXinHuiSu() {
        // 贪心算法
        int[] values = {5, 3};    //硬币面值
        int total = 11;
        Tanxin tanxin = new Tanxin();
        int minCoinCountHelper = tanxin.getMinCoinCountHelper(11, values, 2);
        System.out.println(minCoinCountHelper);

    }

    @Test
    public void iteratorFeibonaqie() {
        // 贪心算法
        int[] values = {5, 3};    //硬币面值
        int total = 11;
        Tanxin tanxin = new Tanxin();
        int minCoinCountHelper = tanxin.getMinCoinCountHelper(11, values, 2);
        System.out.println(minCoinCountHelper);

    }


    /***
     * 第二章，暴力递归的优化
     */


    /**
     * 使用迭代求斐波那契数列
     */
    @Test
    public void iterator() {

        IteratorFeibo iteratorFeibo = new IteratorFeibo();
        int feiboNaqie = iteratorFeibo.getFeiboNaqie(2);
        System.out.println(feiboNaqie);

        int feiboNaqie3 = iteratorFeibo.getFeiboNaqie(3);
        System.out.println(feiboNaqie3);

        int feiboNaqie4 = iteratorFeibo.getFeiboNaqie(4);
        System.out.println(feiboNaqie4);


        int feiboNaqie5 = iteratorFeibo.getFeiboNaqie(5);
        System.out.println(feiboNaqie5);
    }

    /**
     * 使用递归求斐波那契数列
     */
    @Test
    public void iterator2() {

        RecursionFeiboDemo recursionFeiboDemo = new RecursionFeiboDemo();
        int feiboNaqie = recursionFeiboDemo.feibonaqie(2);
        System.out.println(feiboNaqie);

        int feiboNaqie3 = recursionFeiboDemo.feibonaqie(3);
        System.out.println(feiboNaqie3);

        int feiboNaqie4 = recursionFeiboDemo.feibonaqie(4);
        System.out.println(feiboNaqie4);


        int feiboNaqie5 = recursionFeiboDemo.feibonaqie(5);
        System.out.println(feiboNaqie5);

        int feiboNaqie6 = recursionFeiboDemo.feibonaqie(6);
        System.out.println(feiboNaqie6);
    }

    /**
     * 基于递归改良找硬币算法
     */

    @Test
    public void findCoinAalgrithm() {

        Demo05RecursionOptimizeCoin demo05RecursionOptimizeCoin = new Demo05RecursionOptimizeCoin();
    }


    /**
     * 优化基于递归改良找硬币算法
     */
    @Test
    public void optimizeFindCoinAalgrithm() {

        Demo06RecursionOptimizeCoin demo06RecursionOptimizeCoin = new Demo06RecursionOptimizeCoin();
    }


    /***
     * 备忘录模式
     */


    /***
     * 备忘录优化贪心算法
     */
    @Test
    public void beiwangluOptimizeFeibonaqi() {

        Demo07BeiWangLuFeibonaqie demo07RecursionOptimizeCoin = new Demo07BeiWangLuFeibonaqie();
        int i = demo07RecursionOptimizeCoin.fibonacciAdvance(3);
        System.out.println(i);
    }


    /***
     * 04动态规划模式
     */


    /**
     * 04-1 自底向上的解决斐波那伽
     */
    @Test
    public void Demo0401OptimizeFeibonaqie() {
        Demo0401OptimizeFeibonaqie demo0401OptimizeFeibonaqie = new Demo0401OptimizeFeibonaqie();
        int a = demo0401OptimizeFeibonaqie.fibonacciAdvance(2);
        System.out.println(a);


        int b = demo0401OptimizeFeibonaqie.fibonacciAdvance(3);
        System.out.println(b);

        int c = demo0401OptimizeFeibonaqie.fibonacciAdvance(4);
        System.out.println(c);

        int d = demo0401OptimizeFeibonaqie.fibonacciAdvance(5);
        System.out.println(d);
    }


    /**
     * 04-2 使用自底向上优化硬币找零
     */
    @Test
    public void Demo0402OptimizeFindCoin() {
        Demo0401OptimizeFeibonaqie demo0401OptimizeFeibonaqie = new Demo0401OptimizeFeibonaqie();
        int a = demo0401OptimizeFeibonaqie.fibonacciAdvance(2);
        System.out.println(a);


        int b = demo0401OptimizeFeibonaqie.fibonacciAdvance(3);
        System.out.println(b);

        int c = demo0401OptimizeFeibonaqie.fibonacciAdvance(4);
        System.out.println(c);

        int d = demo0401OptimizeFeibonaqie.fibonacciAdvance(5);
        System.out.println(d);
    }


    /***
     * 06动态规划
     */
    @Test
    public void Demo0601package() {
        int N = 3;   //0,1,2,3
        int W = 5;
        int[] w = {0, 3, 2, 1};
        int[] v = {0, 5, 2, 3};
        Package01Test package01Test = new Package01Test();
        int dp = package01Test.dp(w, v, N, W);
        System.out.println(dp);
    }


    /**
     * 08 第八章
     */

    /**
     * 08 回文串的个数
     */
    @Test
    public void Demo08huiwen() {
        Demo08huiwen demo08huiwen = new Demo08huiwen();
        int abccccdd = demo08huiwen.countSubstrings("abccccdd");
        System.out.println(abccccdd);
    }


    /**
     * 08 回文串的长度
     */
    @Test
    public void Demo08huiwenLength() {
        Demo08huiwenMaxLength demo08huiwenMaxLength = new Demo08huiwenMaxLength();
        int length = demo08huiwenMaxLength.countSubstrings("abccccdd");
        System.out.println(length);
    }

    /**
     * 08 最长子回文串
     */
    @Test
    public void Demo08huiwenString() {
        Demo08huiwenMaxString demo08huiwenMaxString = new Demo08huiwenMaxString();
        String babad = demo08huiwenMaxString.longestPalindrome("babad");
        System.out.println(babad);
    }


    /**
     * 08 最大子数组之和
     */
    @Test
    public void Demo08MaxSubArray() {
        Demo08MaxSubArray demo08MaxSubArray = new Demo08MaxSubArray();
        int res = demo08MaxSubArray.maxSubArray(new int[] {-2,1});
        System.out.println(res);
    }

}



    
