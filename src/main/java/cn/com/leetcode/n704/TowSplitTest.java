package cn.com.leetcode.n704;

/**
 * @Author: wenguoxing
 * @Date: 2022/8/31 8:25
 * @Version 1.0
 */
public class TowSplitTest {

    /**
     * 构造函数
     */
    public TowSplitTest() {
    }

    /**
     * search
     * <p>
     * 过程：
     * 设定左右指针
     * 找出中间位置，并判断该位置值是否等于 target
     * nums[mid] == target 则返回该位置下标
     * nums[mid] > target 则右侧指针移到中间
     * nums[mid] < target 则左侧指针移到中间
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        //设定左右指针
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}