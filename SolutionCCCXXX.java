/**
 * 330. Patching Array
 *
 * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.

 Example 1:
 nums = [1, 3], n = 6
 Return 1.

 Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 So we only need 1 patch.

 Example 2:
 nums = [1, 5, 10], n = 20
 Return 2.
 The two patches can be [2, 4].

 Example 3:
 nums = [1, 2, 2], n = 5
 Return 0.
 */
public class SolutionCCCXXX {
    // Eg: given [1, 2, 4, 12, 13, 48], n=100
    // we can build 1,2,3,4,5,6,7, ie.range=[1, 8); but 8 is lack and 13 is too large, then add 8, expand to [1, 16)
    // but the larger value of 12, 13 is 13 which is < 16, exoand to [0, 29), so we add 29 to expand to be [1, 58)
    // but we have 48 inside [1, 58), so [1, 106), and 106>100 we got [8, 29]
    public int minPatches(int[] nums, int n) {
        int count = 0;
        int i = 0;
        for (long miss = 1; miss <= n; count++) {
            miss += (i < nums.length && nums[i] <= miss) ? nums[i++] : miss;
        }
        return count - i;
    }
}
