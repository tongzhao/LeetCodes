import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionXLVII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<Integer>();
        permute(nums, res, tmp, visited);
        return res;
    }
    public void permute(int[] nums, List<List<Integer>> res, List<Integer> tmp, boolean[] visited) {
        if (tmp.size()==visited.length) {
            List<Integer> temp = new ArrayList<Integer>(tmp);
            res.add(temp);
            return;
        }
        for (int i = 0; i< nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(nums[i]);
                permute(nums, res, tmp, visited);
                visited[i] = false;
                tmp.remove(tmp.size()-1);
                while (i+1<nums.length && nums[i]==nums[i+1]) i++;
            }
        }
    }
}
