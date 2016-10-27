import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class SolutionLXXVII {
    public List<List<Integer>> combine(int n, int k) {
        return com(n, k);
    }
    public List<List<Integer>> com(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k==1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i);
                res.add(tmp);
            }
        } else {
            for (int m=n; m>1; m--) {
                for (List<Integer> list: com(m-1, k-1)) {
                    list.add(m);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
