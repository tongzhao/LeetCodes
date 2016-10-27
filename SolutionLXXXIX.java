import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Gray Code
 */
public class SolutionLXXXIX {
    public List<Integer> grayCode(int n) {
        /**
         * n=1: 0 1
         * n=2: 0 1 3 2
         * n=3: 0 1 3 2 6 7 5 4 (reverse and and 2^(n-1))
         */
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        if (n<=0) return res;
        List<Integer> result = new ArrayList<Integer>(res);
        for (int i = 1; i <= n; i++) {
            res = new ArrayList<Integer>(result);
            Collections.reverse(res);
            for (int j = 0; j < res.size(); j++) {
                res.set(j, res.get(j)+(int) Math.pow(2, i-1));
            }
            result.addAll(res);
        }
        return result;
    }
}
