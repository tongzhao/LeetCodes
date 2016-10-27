import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SolutionCCXXVIII {
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums==null || nums.length==0) return res;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (right+1 < nums.length && nums[right]+1==nums[right+1]) {
                right++;
                if (right==nums.length-1) {
                    res.add(range(nums[left], nums[right]));
                    return res;
                }
            }
            res.add(range(nums[left], nums[right]));
            right++;
            left = right;
        }
        return res;
    }

    public static String range(int left, int right) {
        if (left==right) return String.valueOf(left);
        else return String.valueOf(left) + "->" + String.valueOf(right);
    }
}
