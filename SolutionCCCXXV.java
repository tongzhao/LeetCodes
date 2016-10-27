import java.util.HashMap;

/**
 * 325. Maximum Size Subarray Sum Equals k My Submissions Question

 Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

 Example 1:
 Given nums = [1, -1, 5, -2, 3], k = 3,
 return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

 Example 2:
 Given nums = [-2, -1, 2, 1], k = 1,
 return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 */
public class SolutionCCCXXV {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        if (nums==null || nums.length==0) return res;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        for (int j = nums.length-1; j >= 0; j--) {
            if (sum==k) res = Math.max(res, j+1);
            else if (map.containsKey(sum-k)) res = Math.max(res, j-map.get(sum-k));
            sum -= nums[j];
        }
        return res;
    }
}
