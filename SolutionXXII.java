import java.util.ArrayList;
import java.util.List;

public class SolutionXXII {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n<=0) return res;
        /**
         * n=1, ()
         * n=2, ()(), (())
         * n=3, (())(), (()()), ((())), ()(()), ()()()
         * count for the left and right parts
         */
        char[] parens = new char[2*n];
        gp(n, 0, 0, res, parens);
        return res;
    }
    public void gp(int n, int left, int right, List<String> res, char[] parens) {
        if (left==n && right==n) {
            String tmp = new String(parens);
            res.add(tmp);
            return;
        }
        if (left<n) {
            parens[left+right] = '(';
            gp(n, left+1, right, res, parens);
        }
        if (right<left) {
            parens[left+right] = ')';
            gp(n, left, right+1, res, parens);
        }
    }
}
