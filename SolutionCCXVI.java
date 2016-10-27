import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Ensure that numbers within the set are sorted in ascending order.
 Example 1:
 Input: k = 3, n = 7
 Output:
 [[1,2,4]]

 Example 2:
 Input: k = 3, n = 9
 Output:
 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class SolutionCCXVI {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        combinationSum3(res, tmp, 1, n, k);
        return res;
    }
    public void combinationSum3(List<List<Integer>> res, List<Integer> tmp, int start, int sum, int k) {
        if (sum==0 && tmp.size()==k) {
            List<Integer> temp = new ArrayList<Integer>(tmp);
            res.add(temp);
        }
        for (int i = start; i <=9; i++) {
            if (sum < i) break;
            if (tmp.size()>k) break;
            tmp.add(i);
            combinationSum3(res, tmp, i+1, sum-i, k);
            tmp.remove(tmp.size()-1);
        }
    }
}
