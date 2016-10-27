/**
 * A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class SolutionCLXII {
    public int findPeakElement(int[] nums) {
        int min = Integer.MIN_VALUE;
        int res = 0;
        int length = nums.length;
        if (length==1) return 0;
        int i = 0;
        while (i+1 < length) {
            if (nums[i] > nums[i+1] && nums[i] > min) return i;
            min = nums[i];
            i++;
        }
        return length-1;
    }
}
