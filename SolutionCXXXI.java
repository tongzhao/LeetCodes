import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 Return all possible palindrome partitioning of s.
 For example, given s = "aab",
 Return
 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class SolutionCXXXI {
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> tmp = new ArrayList<String>();
        solve(res, tmp, s);
        return res;
    }
    public void solve(List<List<String>> res, List<String> tmp, String s) {
        if (s.equals("")) {
            List<String> temp = new ArrayList<String>(tmp);
            res.add(temp);
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String ss = s.substring(0, i);
            if (isPa(ss)) {
                List<String> temp = new ArrayList<String>(tmp);
                temp.add(ss);
                solve(res, temp, s.substring(i));
            }
        }
    }
    public boolean isPa(String s) {
        if (map.containsKey(s)) {
            if (map.get(s)) return true;
            return false;
        }
        int i = 0;
        int j = s.length()-1;
        while (i<=j) {
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        map.put(s, true);
        return true;
    }
}
