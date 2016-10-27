import java.util.HashMap;
import java.util.Map;

public class SolutionI {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            int num1 = nums[i];
            int num2 = target-num1;
            if (map.containsKey(num2)) {
                res[0] = map.get(num2)+1;
                res[1] = i+1;
                return res;
            } else if (!map.containsKey(num1)){
                map.put(num1, i);
            }
        }
        return res;
    }
}
