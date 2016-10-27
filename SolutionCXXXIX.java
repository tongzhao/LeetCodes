import java.util.Set;

/**
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 For example, given
 s = "leetcode",
 dict = ["leet", "code"].
 Return true because "leetcode" can be segmented as "leet code".
 */
public class SolutionCXXXIX {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s==null || s.length()==0 || wordDict==null || wordDict.size()==0) return false;
        boolean[] check = new boolean[s.length()+1];
        check[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int k = 0; k < i; k++) {
                String ss = s.substring(k, i);
                if (check[k] && wordDict.contains(ss)) check[i] = true;
            }
        }
        return check[s.length()];
    }
}
