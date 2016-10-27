public class SolutionLV {
    public static boolean canJump(int[] nums) {
        if (nums==null || nums.length==0) return false;
        int last_farthest = nums[0];
        int i = 0;
        while (i <= last_farthest && i<nums.length-1) {
            int steps = nums[i] + i;
            last_farthest = Math.max(last_farthest, steps);
            i++;
        }
        return last_farthest >= nums.length-1;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,1,4};
        if (canJump(nums)) System.out.print("True");
        else System.out.print("False");
    }
}
