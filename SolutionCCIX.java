/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 */
public class SolutionCCIX {
    public static int minSubArrayLen(int s, int[] nums) {
        // sliding window problem
        if (nums==null || nums.length==0) return 0;
        int local = 0;
        int res = nums.length+1;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            local += nums[right];
            if (local >= s) {
                while (left <= right && local >= s) {
                    local -= nums[left];
                    left++;
                }
                left--;
                local += nums[left];
                res = res > (right - left + 1) ? (right - left + 1) : res;
            }
            right++;
        }
        if (res > nums.length) return 0;
        return res;
    }
    public static void main(String[] args) {
        int[] test0 = {2,3,1,2,4,3};
        int[] test1 = {1,2,3};
        int s0 = 7;
        int s1 = 3;
        System.out.println(minSubArrayLen(s0, test0));
        System.out.println(minSubArrayLen(s1, test1));
    }
}
