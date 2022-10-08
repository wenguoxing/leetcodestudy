package com.cn.leetcode.n14;

/**
 * 斐波拉契数列
 *
 * @Author: wenguoxing
 * @Date: 2019/05/28 14:23
 * @Version 1.0
 */
public class FibonaciiTest2 {

    /**
     * 递归很好理解，如果不懂可以看上面的讲解，
     * 递归的思路其实和回溯法是一样的，遍历所有解空间但这里和上面斐波拉契数列的不同之处在于，
     * 在每一层上都进行了一次最优解的选择，q=Math.max(q, p[i-1]+cut(p, n-i));
     * 这个段语句就是最优解选择，这里上一层的最优解与下一层的最优解相关。
     *
     * @param p
     * @param n
     * @return
     */
    public int cut(int[] p, int n) {

        System.out.print("cut:" + n);

        if (n == 0) {

            System.out.println(String.format(",fq:%d",n));

            return 0;
        }

        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {

            System.out.print(String.format(",i:%d,p-1:%d",i,p[i-1]));
            q = Math.max(q, p[i - 1] + cut(p, n - i));
            System.out.print(String.format(",q:%d",q));

        }

        System.out.println(String.format(",fq:%d",q));

        return q;
    }

    /************************************备忘录版本*********************************/

    public static int cutMemo(int[] p) {
        int[] r = new int[p.length + 1];
        for (int i = 0; i <= p.length; i++) {
            r[i] = -1;
        }

        return cut01(p, p.length, r);
    }

    public static int cut01(int[] p, int n, int[] r) {
        int q = -1;
        if (r[n] >= 0) {
            return r[n];
        }

        if (n == 0) {
            q = 0;
        } else {
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, cut01(p, n - i, r) + p[i - 1]);
            }
        }

        r[n] = q;

        return q;
    }

    /**
     * 自底向上的动态规划问题中最重要的是理解注释①处的循环，
     * 这里外面的循环是求r[1],r[2]……，
     * 里面的循环是求出r[1],r[2]……的最优解，也就是说r[i]中保存的是钢条长度为i时划分的最优解，
     * 这里面涉及到了最优子结构问题，也就是一个问题取最优解的时候，它的子问题也一定要取得最优解
     *
     * n:英寸，p:价格，r：收益
     *
     * @param p
     * @return
     */
    public int buttom_up_cut(int[] p) {

        int[] r = new int[p.length + 1];

        for (int i = 1; i <= p.length; i++) {
            int q = -1;
            //①
            for (int j = 1; j <= i; j++) {
                q = Math.max(q, p[j - 1] + r[i - j]);
            }

            r[i] = q;

            System.out.println("r:" + r[i]);
        }

        return r[p.length];
    }

    //各英寸的价格
    public int buttom_up_cut1(int[] p){
        for(int j = 1;j<=p.length;j++){
            System.out.println("p:" + p[j-1]);
        }

        return 1;
    }

    public int buttom_up_cut2(int[] p){

        int[] r = new int[p.length + 1];

        for(int i = 1;i< p.length;i++){

            int q = -1;

            for (int j = 1; j <= i; j++) {
                System.out.println(String.format("i:%d,j-1:%d,p:%d,i-j:%d,r:%d",i,(j - 1),p[j - 1] ,(i - j),r[i - j]));
                q = Math.max(q, p[j - 1] + r[i - j]);
            }

            r[i] = q;
        }

        return 1;
    }
    public static void main(String[] args) {

        int i = 0;
        int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        FibonaciiTest2 fibonaciiTest2 = new FibonaciiTest2();
        int iResut = fibonaciiTest2.cut(price, i);
        System.out.println("result:" + iResut);

        i = 1;
        iResut = fibonaciiTest2.cut(price, i);
        System.out.println("result:" + iResut);

        i = 2;
        iResut = fibonaciiTest2.cut(price, i);
        System.out.println("result:" + iResut);

        i = 3;
        iResut = fibonaciiTest2.cut(price, i);
        System.out.println("result:" + iResut);

        i = 4;
        iResut = fibonaciiTest2.cut(price, i);
        System.out.println("result:" + iResut);

        int[] price2 = new int[]{1, 5, 8, 9};
        //iResut = fibonaciiTest2.buttom_up_cut(price2);
        iResut = fibonaciiTest2.buttom_up_cut2(price2);
        //System.out.println("result:" + iResut);
    }
}
