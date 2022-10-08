package com.cn.leetcode.n1051;

import java.util.Arrays;

/**
 * @Author: wenguoxing
 * @Date: 2022/6/13 15:00
 * @Version 1.0
 */
public class HeightTest {

    public int heightChecker(int[] heights) {
        int m = Arrays.stream(heights).max().getAsInt();
        int[] cnt = new int[m + 1];
        for (int h : heights) {
            ++cnt[h];
        }

        //int[] heigts = new int[]{1,1,1,2,3,5,4,7,9,8};
        //      cnt    =          {0,3,1,1,1,1,0,1,1,1};
        int idx = 0, ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= cnt[i]; ++j) {
                if (heights[idx] != i) {
                    ++ans;
                }
                ++idx;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        HeightTest heightTest = new HeightTest();
        int[] heigts = new int[]{1,1,1,2,3,5,4,7,9,8};
        int iRet = heightTest.heightChecker(heigts);
        System.out.println(iRet);
    }
}
