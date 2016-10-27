import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].
 A solution is ["cats and dog", "cat sand dog"]
 */
public class SolutionCXL {
    public List<String> wordBreak(String s, Set<String> dict){
        int length = s.length();
        boolean[] checker = new boolean[length+1];
        checker[0] = true;
        List<List<Integer>> lastEnd = new ArrayList<List<Integer>>();
        for(int i=0; i<=length; i++){
            lastEnd.add(new ArrayList<Integer>()); // initialization
        }
        // check DP way try to add each ith-char with lastEnd index
        for(int i=1; i<=length; i++){
            for(int k=0; k<i; k++){
                if(checker[k] && dict.contains(s.substring(k,i))){
                    checker[i] = true;
                    lastEnd.get(i).add(k);
                }
            }
        }
        List<String> res = new ArrayList<String>();
        solve(s, lastEnd, length, res, "");
        return res;
    }
    // backtracking in recersion
    public void solve(String s, List<List<Integer>> lastEnd, int end, List<String> res, String curr){
        List<Integer> last = lastEnd.get(end);
        for(int i=0; i<last.size(); i++){ // the indices that can reach to string's end
            int n = last.get(i);
            String add = s.substring(n, end); // end is the length and easy to be apply for index of substring without -1
            if(!curr.equals("")){
                add = add+" "+curr;
            }
            if(n==0){
                res.add(add);
            }
            solve(s, lastEnd, n, res, add);
        }
    }
}
