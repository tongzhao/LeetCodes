import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionXXXIX {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length==0) return null;
        Arrays.sort(candidates);
        return com(candidates, target, 0);
    }
    public List<List<Integer>> com(int[] nums, int sum, int start){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int i=start;
        while(i<nums.length){
            if(nums[i]==sum){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(nums[i]);
                res.add(list);
            }
            else if(nums[i]<sum){
                List<List<Integer>> temp = com(nums, sum-nums[i], i+1);
                if(!temp.isEmpty()){
                    for(List<Integer> al:temp){
                        al.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
            }
            else if(nums[i]>sum){
                break;
            }
            while(i+1<nums.length && nums[i+1]==nums[i]){
                i++;
            }
            i++;
        }
        return res;
    }
}
