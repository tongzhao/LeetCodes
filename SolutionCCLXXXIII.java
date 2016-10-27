/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 nums should be [1, 3, 12, 0, 0].
 */
public class SolutionCCLXXXIII {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[i++] = num;
            }
        }
        while (i < nums.length) nums[i++] = 0;
    }
}
