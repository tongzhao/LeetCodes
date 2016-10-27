import java.util.ArrayList;
import java.util.List;

/**
 * 320. Generalized Abbreviation:
 *
 * Write a function to generate the generalized abbreviations of a word.

 Example:
 Given word = "word", return the following list (order does not matter):
 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d",
 "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
public class SolutionCCCXX {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        backtracking(res, word, 0, "", 0);
        return res;
    }
    public void backtracking(List<String> res, String word, int pos, String curr, int count) {
        if (pos==word.length()) {
            if (count > 0) curr += count;
            res.add(curr);
        } else { // for each char in word, we can keep it or abbreviate it
            backtracking(res, word, pos+1, curr, count+1);
            backtracking(res, word, pos+1, curr+(count>0 ? count : "")+word.charAt(pos), 0);
        }
    }
}
