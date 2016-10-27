import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionXVIII {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums==null || nums.length<4) return res;
        Arrays.sort(nums);
        for (int i = 0; i<nums.length-3; i++) {
            for (int j = i+1; j<nums.length-2; j++) {
                int rest = target - nums[i] - nums[j];
                int m = j+1;
                int n = nums.length-1;
                while (m<n) {
                    int sum = nums[m] + nums[n];
                    if (sum==rest) {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[m]);
                        tmp.add(nums[n]);
                        res.add(tmp);
                        while (m+1<n && nums[m]==nums[m+1]) m++;
                        m++;
                    } else if (sum < rest) {
                        while (m+1<n && nums[m]==nums[m+1]) m++;
                        m++;
                    } else {
                        while (m+1<n && nums[n]==nums[m-1]) n--;
                        n--;
                    }
                }
                while (j+1<nums.length-2 && nums[j]==nums[j+1]) j++;
            }
            while (i+1<nums.length-3 && nums[i]==nums[i+1]) i++;
        }
        return res;
    }
}
