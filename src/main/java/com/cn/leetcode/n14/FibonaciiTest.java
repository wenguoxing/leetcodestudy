package com.cn.leetcode.n14;

/**
 * 斐波拉契数列
 *
 * @Author: wenguoxing
 * @Date: 2019/05/28 13:33
 * @Version 1.0
 */
public class FibonaciiTest {

    /**
     * 递归解法
     *
     * 看似从上向下的，其实也是自底向上计算的。
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    /*********************************动态规划*******************************/
    /**
     * 自顶向下的备忘录法
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if (n <= 0) {
            return n;
        }
        int[] Memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            Memo[i] = -1;
        }

        return fib2(n, Memo);
    }

    /**
     * 备忘录法也是比较好理解的，创建了一个n+1大小的数组来保存求出的斐波拉契数列中的每一个值，
     * 在递归的时候如果发现前面fib（n）的值计算出来了就不再计算，
     * 如果未计算出来，则计算出来后保存在Memo数组中，下次在调用fib（n）的时候就不会重新递归了。
     * 比如上面的递归树中在计算
     * fib（6）的时候先计算fib（5），调用fib（5）算出了fib（4）后，
     * fib（6）再调用fib（4）就不会在递归fib（4）的子树了，因为fib（4）的值已经保存在Memo[4]中。
     *
     * 递归时把Memo作为参数传入，但Memo的内容一直在变化。
     *
     * @param n
     * @param Memo
     * @return
     */
    public int fib2(int n, int[] Memo) {

        if (Memo[n] != -1) {
            return Memo[n];
        }
        //如果已经求出了fib（n）的值直接返回，否则将求出的值保存在Memo备忘录中。
        if (n <= 2) {
            Memo[n] = 1;
        } else {
            Memo[n] = fib2(n - 1, Memo) + fib2(n - 2, Memo);
        }

        return Memo[n];
    }

    /****************************************自底向上的动态规划*********************************************/
    /**
     * 备忘录法还是利用了递归，上面算法不管怎样，
     * 计算fib（6）的时候最后还是要计算出fib（1），fib（2），fib（3）……,
     * 那么何不先计算出fib（1），fib（2），fib（3）……,呢？
     *
     * 这也就是动态规划的核心，先计算子问题，再由子问题计算父问题。
     *
     * @param n
     * @return
     */
    public int fib02(int n) {

        if (n <= 0) {
            return n;
        }

        int[] Memo = new int[n + 1];

        Memo[0] = 0;
        Memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            Memo[i] = Memo[i - 1] + Memo[i - 2];
        }

        return Memo[n];
    }

    /**
     * 自底向上方法也是利用数组保存了先计算的值，为后面的调用服务。
     * 观察参与循环的只有 i，i-1 , i-2三项，因此该方法的空间可以进一步的压缩如下。
     *
     * @param n
     * @return
     */
    public int fib03(int n) {

        if (n <= 1) {
            return n;
        }

        //i-2
        int Memo_i_2 = 0;
        //i-1
        int Memo_i_1 = 1;
        //i
        int Memo_i = 1;

        for (int i = 2; i <= n; i++) {

            Memo_i = Memo_i_2 + Memo_i_1;

            Memo_i_2 = Memo_i_1;
            Memo_i_1 = Memo_i;
        }

        return Memo_i;
    }

    public static void main(String[] args) {
        FibonaciiTest fibonaciiTest = new FibonaciiTest();
        //int i = fibonaciiTest.fib2(6);
        //int i = fibonaciiTest.fibonacci(6);
        int i = fibonaciiTest.fib02(6);

        System.out.println(i);
    }
}
