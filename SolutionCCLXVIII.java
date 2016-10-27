/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.
 */
public class SolutionCCLXVIII {
    public int missingNumber(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int total = nums.length * (nums.length+1) / 2;
        for (int num: nums) total -= num;
        return total;
    }
}
