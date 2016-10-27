/**
 * 153. Find Minimum in Rotated Sorted Array
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.
 You may assume no duplicate exists in the array.
 */
public class SolutionCLIII {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length-1);
    }
    public int find(int[] nums, int left, int right) {
        if (left == right ) return nums[left];
        if (right-left==1) return Math.min(nums[left], nums[right]);
        int mid = left + (right-left)/2;
        if (nums[left] < nums[right]) return nums[left];
        else if (nums[mid] > nums[left]) return find(nums, mid, right);
        else return find(nums, left, mid);
    }
}
