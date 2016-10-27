import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionXV {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums==null || nums.length<3) return res;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            int num1 = nums[i];
            int j = i+1;
            int k = nums.length-1;
            int target = 0 - num1;
            while(j<k) {
                int sum = nums[j] + nums[k];
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                if (sum == target) {
                    tmp.add(num1);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    res.add(tmp);
                    while (j+1<k && nums[j]==nums[j+1]) j++;
                    j++;
                    while (j<k-1 && nums[k]==nums[k-1]) k--;
                    k--;
                }
                else if (sum < target) j++;
                else k--;
            }
            while(i+1<nums.length-2 && nums[i]==nums[i+1]) i++;
        }
        return res;
    }
}
