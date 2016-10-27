/**
 * Wiggle Sort:
 *
 * Given an unsorted array nums, reorder it in-place such that
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....

 For example, given nums = [3, 5, 2, 1, 6, 4],
 one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class SolutionCCLXXX {
    public void wiggleSort(int[] nums) {
        // relative comparison, just care about the neighbours
        int n = nums.length;
        if (n<=1) return;
        for (int i = 1; i < n; i++) {
            if (i % 2 != 0) {
                if (nums[i] < nums[i-1]) {
                    swap(nums, i-1, i);
                }
            } else {
                if (nums[i-1] < nums[i]) {
                    swap(nums, i-1, i);
                }
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
