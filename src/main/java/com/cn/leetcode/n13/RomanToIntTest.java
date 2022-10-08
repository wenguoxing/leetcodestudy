package com.cn.leetcode.n13;

/**
 * @Author: wenguoxing
 * @Date: 2022/7/15 11:49
 * @Version 1.0
 */
public class RomanToIntTest {

    private int getIntValueByRoman(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getIntValueByRoman(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getIntValueByRoman(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public static void main(String[] args) {

        String strTemp = "VIII";
        RomanToIntTest romanToIntTest = new RomanToIntTest();
        int sum = romanToIntTest.romanToInt(strTemp);
        System.out.println(sum);
    }
}
