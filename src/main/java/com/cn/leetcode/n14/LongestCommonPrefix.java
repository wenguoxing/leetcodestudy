package com.cn.leetcode.n14;

/**
 * @Author: wenguoxing
 * @Date: 2019/03/21 16:26
 * @Version 1.0
 */
public class LongestCommonPrefix {

    public LongestCommonPrefix(String[] args) {
        this.longestCommonPrefix(args);
    }

    public String longestCommonPrefix(String[] str) {

        if (str.length == 0) {
            return "";
        }

        return partOf(str, 0, str.length - 1);
    }

    public String partOf(String[] str, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return str[leftIndex];
        } else {
            int minIndex = (leftIndex + rightIndex) / 2;
            String leftStr = partOf(str, leftIndex, minIndex);
            String rightStr = partOf(str, minIndex + 1, rightIndex);
            String resultStr = getResult(leftStr, rightStr);

            System.out.println("left:" + leftStr + " right:" + rightStr + " result:" + resultStr);

            return resultStr;
        }
    }

    public String getResult(String leftStr, String rightStr) {
        int min = Math.min(leftStr.length(), rightStr.length());
        for (int i = 0; i < min; i++) {
            if (leftStr.charAt(i) != rightStr.charAt(i)) {
                return leftStr.substring(0, i);
            }
        }
        return leftStr.substring(0, min);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight","fli","fli01","fl123","fl234","fl345","fl456","fl567","fl789"};
        LongestCommonPrefix lcp = new LongestCommonPrefix(strs);
    }
}
