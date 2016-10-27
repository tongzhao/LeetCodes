import java.util.ArrayList;
import java.util.List;

/**
 * 386. Lexicographical Numbers
 *
 * Given an integer n, return 1 - n in lexicographical order.

 For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

 Please optimize your algorithm to use less time and space.
 The input size may be as large as 5,000,000.
 */
public class SolutionCCCLXXXVI {
    public List<Integer> lexicalOrder(int n) {
        // DFS
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) dfs(i, n, res);
        return res;
    }
    public void dfs(int cur, int n, List<Integer> res) {
        if (cur > n) return;
        res.add(cur);
        for (int i = 0; i < 10; i++) {
            if (10*cur+i > n) return;
            dfs(10*cur+i, n, res);
        }
    }
}
