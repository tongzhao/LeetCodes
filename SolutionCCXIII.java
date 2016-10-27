/**
 * Horse Robber II: houses in a circle
 */
public class SolutionCCXIII {
    // 0 -> nums.length-2 || 1 -> nums.length-1
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0], nums[1]);
        int[] res1 = new int[nums.length];
        int[] res2 = new int[nums.length];
        // 0 -> nums.length-2
        res1[0] = nums[0];
        res1[1] = nums[0];
        for (int i = 2; i < nums.length-1; i++) {
            res1[i] = Math.max(res1[i-1], res1[i-2]+nums[i]);
        }
        // 1 -> nums.length-1
        res2[0] = 0;
        res2[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            res2[i] = Math.max(res2[i-1], res2[i-2]+nums[i]);
        }
        return Math.max(res1[nums.length-2], res2[nums.length-1]);
    }
}
