import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * subsets with dups
 */
public class SolutionXC {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // dup only adds the subsets with last same dup
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(nums);
        res.add(tmp);
        int mark = 0;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            size = res.size();
            for (int j = mark; j < size; j++) {
                List<Integer> temp = new ArrayList<Integer>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
            if (i+1<nums.length && nums[i]==nums[i+1]) mark = size;
            else mark = 0;
        }
        return res;
    }
}
