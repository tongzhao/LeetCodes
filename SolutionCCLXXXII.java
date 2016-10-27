import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value,
 * return all possibilities to add binary operators (not unary) +, -, or * between the digits
 * so they evaluate to the target value.

 Examples:
 "123", 6 -> ["1+2+3", "1*2*3"]
 "232", 8 -> ["2*3+2", "2+3*2"]
 "105", 5 -> ["1*0+5","10-5"]
 "00", 0 -> ["0+0", "0-0", "0*0"]
 "3456237490", 9191 -> []
 */
public class SolutionCCLXXXII {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if (num==null || num.length()==0) return res;
        String tmp = "";
        helper(res, num, tmp, target, 0, 0, 0);
        return res;
    }
    public void helper(List<String> res, String num, String tmp, int target, int pos, long eval, long multi) {
        if (pos == num.length()) {
            if (eval == target) {
                res.add(tmp);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            Long curr = Long.valueOf(num.substring(pos, i+1));
            if (pos==0) helper(res, num, tmp+curr, target, i+1, curr, curr);
            else {
                helper(res, num, tmp + "+" + curr, target, i+1, eval+curr, curr);
                helper(res, num, tmp + "-" + curr, target, i+1, eval-curr, -curr);
                helper(res, num, tmp + "*" + curr, target, i+1, eval-multi+multi*curr, multi*curr);
            }
        }
    }
}
