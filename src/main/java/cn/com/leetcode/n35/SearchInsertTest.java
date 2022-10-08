package cn.com.leetcode.n35;

/**
 * @Author: wenguoxing
 * @Date: 2022/9/2 8:36
 * @Version 1.0
 */
public class SearchInsertTest {

    /**
     * 构造函数
     */
    public SearchInsertTest() {
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}