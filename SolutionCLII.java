/**
 * 152. Maximum Product Subarray
 *
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 */
public class SolutionCLII {
    public int maxProduct(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(max*nums[i], nums[i]), min * nums[i]);
            min = Math.min(Math.min(min*nums[i], nums[i]), tmp * nums[i]);
            res = res > max ? res : max;
        }
        return res;
    }
}
