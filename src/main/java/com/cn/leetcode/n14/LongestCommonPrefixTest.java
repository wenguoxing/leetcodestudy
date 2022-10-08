package com.cn.leetcode.n14;

/**
 * @Author: wenguoxing
 * @Date: 2022/7/19 17:06
 * @Version 1.0
 */
public class LongestCommonPrefixTest {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //如果第一个长度大于后面的长度，会有问题。
            //for (int j = 0; j < ans.length() && j < strs[i].length(); j++) {
            //    if (ans.charAt(j) != strs[i].charAt(j)) {
            //        ans = ans.substring(0,j);
            //        break;
            //    }
            //}
            //if ("".equals(ans)) {
            //    return "";
            //}

            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0,j);
            if ("".equals(ans)) {
                return "";
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        //String[] strs = new String[]{"flower","flow","flight","fli","fli01","fl123","fl234","fl345","fl456","fl567","fl789"};
        String[] strs = new String[]{"ab","a"};
        LongestCommonPrefixTest longestCommonPrefixTest = new LongestCommonPrefixTest();
        System.out.println(longestCommonPrefixTest.longestCommonPrefix(strs));
    }
}
