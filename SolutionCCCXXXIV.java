/**
 * 334. Increasing Triplet Subsequence
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

 Formally the function should:
 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 Your algorithm should run in O(n) time complexity and O(1) space complexity.

 eg. [3, 1, 5, 2, 4] true [1, 2, 4]
 eg. [5, 3, 4, 1, 2] false
 */
public class SolutionCCCXXXIV {
    public boolean increasingTriplet(int[] nums) {
        if (nums==null || nums.length < 3) return false;
        int length = nums.length;
        // suppose two min values
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min1) min1 = nums[i];
            else if (nums[i] <= min2) min2 = nums[i];
            else return true;
        }
        return false;
    }
}
