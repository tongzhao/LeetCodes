import java.util.Arrays;

public class SolutionXXXI {
    public static void nextPermutation(int[] nums) {
        if (nums==null || nums.length<=1) return;
        int right = nums.length-1;
        while(right-1>=0 && nums[right]<=nums[right-1]) right--;
        reverse(nums, right, nums.length-1);
        if(right==0) return;
        int j = right;
        while(j<nums.length) {
            if(nums[j]>nums[right-1]) {
                swap(nums, right-1, j);
                break;
            }
            j++;
        }
        return;
    }
    public static void reverse(int[] x, int i, int j) {
        while(i<j) swap(x, i++, j--);
    }
    public static void swap(int[] x, int i, int j) {
        int tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }
    public static void main(String[] args) {
        int[] test0 = new int[]{1,2,4,3,5};
        int[] test1 = new int[]{1,3,2};
        //reverse(test0);
        nextPermutation(test1);
        System.out.println("test1: " + Arrays.toString(test1));
        //System.out.println("test0: " + Arrays.toString(test0));
    }
}
