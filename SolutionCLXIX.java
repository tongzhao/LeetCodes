/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class SolutionCLXIX {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 0;
        for (int num: nums) {
            if (num==major) count++;
            else {
                count--;
                if (count==0) {
                    count=1;
                    major = num;
                }
            }
        }
        return major;
    }
}
