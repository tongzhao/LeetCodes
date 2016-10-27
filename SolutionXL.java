import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionXL {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0) return null;
        Arrays.sort(candidates);
        return com(candidates, target, 0);
    }
    public List<List<Integer>> com(int[] nums, int target, int start){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=start; i<nums.length; i++){
            if(target == nums[i]){
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(nums[i]);
                res.add(tmp);
            }
            else if (nums[i]<target){
                List<List<Integer>> temp = com(nums, target-nums[i], i);
                if(!temp.isEmpty()){
                    for(List<Integer> list : temp){
                        list.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
            }
            else break;
        }
        return res;
    }
}
