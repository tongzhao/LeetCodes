import java.util.ArrayList;
import java.util.List;

public class SolutionXLVI {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        DFS(res, tmp, nums, visited);
        return res;
    }
    public void DFS(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] visited) {
        if (tmp.size() == nums.length) {
            List<Integer> temp = new ArrayList<Integer>(tmp);
            res.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(number);
                DFS(res, tmp, nums, visited);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
