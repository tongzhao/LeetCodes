import java.util.Arrays;

public class SolutionXVI {
    public int threeSumClosest(int[] nums, int target) {
        if (nums==null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum==target) return sum;
                else if (sum>target) {
                    diff = (sum-target) > Math.abs(diff) ?  sum-target : diff;
                    k--;
                }
                else {
                    diff = (target-sum) > Math.abs(diff) ? target-sum : diff;
                    j++;
                }
            }
        }
        return target + diff;
    }
}
