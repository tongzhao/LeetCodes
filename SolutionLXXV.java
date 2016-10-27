import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class SolutionLXXV {
    public static void sortColors(int[] nums) {
        if (nums==null || nums.length==0) return;
        int left = 0;
        int right = nums.length-1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) swap(nums, left++, i);
            else if (nums[i]==2) swap(nums, right--, i--);
            i++;
        }
        return;
    }
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,0,2,0};
        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
