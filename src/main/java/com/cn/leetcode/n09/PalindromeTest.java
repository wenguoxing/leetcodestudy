package com.cn.leetcode.n09;

/**
 * @Author: wenguoxing
 * @Date: 2022/7/11 17:01
 * @Version 1.0
 */
public class PalindromeTest {

    public boolean isPalindrome(int x) {

        String strDesc = "";
        String strTemp = String.valueOf(x);
        int iLen = strTemp.length();
        for (int i = iLen - 1; i >= 0; i--) {
            strDesc += strTemp.substring(i, i + 1);
        }

        return strDesc.equals(strTemp);
    }

    public boolean isPalindrome2(int x) {
        if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        int nTemp = 0;
        int cTemp = 0;
        while(num != 0) {
            nTemp = num % 10;
            cTemp = cur * 10;
            cur = cTemp + nTemp;
            num = num / 10;
        }
        return cur == x;
    }

    public boolean isPalindrome3(int x) {
        if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }

    public boolean isPalindrome4(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

    public boolean isPalindrome5(int x) {
        //边界判断
        if (x < 0) {
            return false;
        }

        int div = 1;
        //算出div
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            // 12321 / 10000 = 1
            int left = x / div;
            // 12321 % 10 = 1
            int right = x % 10;
            if (left != right) {
                return false;
            }

            //x % div 去掉左1位
            x = (x % div);
            //x / 10 去掉右1位
            x = x / 10;
            //div 去掉左右各一位
            div /= 100;
        }
        return true;
    }

    public boolean isPalindrome6(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        //1220,0220(不存在)
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        //翻转一半数字
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        PalindromeTest palindromeTest = new PalindromeTest();
        boolean bol = palindromeTest.isPalindrome5(12321);
        System.out.println(bol);
    }
}
