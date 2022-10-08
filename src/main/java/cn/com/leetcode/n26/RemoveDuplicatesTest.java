package cn.com.leetcode.n26;

/**
 * @Author: wenguoxing
 * @Date: 2022/8/19 9:36
 * @Version 1.0
 */
public class RemoveDuplicatesTest {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int fast = 1,slow = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static void main(String[] args) {
        RemoveDuplicatesTest removeDuplicatesTest = new RemoveDuplicatesTest();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4,5};
        int iRet = removeDuplicatesTest.removeDuplicates2(nums);
        System.out.println(iRet);
        for (int i = 0; i < iRet; i++) {
            System.out.println(nums[i]);
        }
    }
}
