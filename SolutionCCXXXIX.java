/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position               Max
 ---------------              -----
 [1  3  -1] -3  5  3  6  7      3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].
 */
public class SolutionCCXXXIX {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // group numbers in k, mark largest value to the left and to the right, largest should inside these two
        if (nums==null || nums.length==0) return new int[0];
        int[] left_max = new int[nums.length];
        int[] right_max = new int[nums.length];
        left_max[0] = nums[0];
        right_max[nums.length-1] = nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            int j = nums.length-1-i;
            left_max[i] = (i%k==0) ? nums[i] : Math.max(nums[i], left_max[i-1]);
            right_max[j] = (j%k==0) ? nums[j] : Math.max(nums[j], right_max[j+1]);
        }
        int[] res = new int[nums.length-k+1];
        for (int i = 0, j = 0; i+k-1<nums.length; i++) {
            res[j++] = Math.max(left_max[i+k-1], right_max[i]);
        }
        return res;
    }
}
