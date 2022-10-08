package com.cn.leetcode.n01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @Author: wenguoxing
 * @Date: 2022/7/11 15:06
 * @Version 1.0
 */
public class TwoSumTest {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                int iPre = map.get(target-nums[i]);
                return new int[] {iPre,i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum2(int[] nums, int target) {
        IntStream stream = Arrays.stream(nums);
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        final int[] iCnt = {0};
        stream.forEach((p)-> {
            p = 13 - p;
            hashMap.put(p, iCnt[0]);
            iCnt[0]++;
        });

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return new int[]{i, hashMap.get(nums[i])};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSumTest twoSumTest = new TwoSumTest();
        int[] nums = new int[]{2,7,11,13};
        int target = 13;

        int[] iRets = twoSumTest.twoSum2(nums, target);
        for (int iTemp : iRets) {
            System.out.println(iTemp);
        }
    }
}
