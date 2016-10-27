public class SolutionXLI {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int length = nums.length;
        while(i < length) {
            if (nums[i] <= 0 || nums[i] >= length || nums[i] == i+1) i++;
            else if (nums[nums[i]-1] != nums[i]) swap(nums, nums[i]-1, i);
            else i++;
        }
        i = 0;
        while (i < length && nums[i] == i+1) i++;
        return i+1;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
