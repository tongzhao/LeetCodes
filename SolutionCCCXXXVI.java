import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 336. Palindrome Pair
 *
 * Given a list of unique words.
 * Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words,
 * i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]
 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
public class SolutionCCCXXXVI {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (words==null || words.length<2) return res;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i); // indexing
        for (int i = 0; i < words.length; i++) {
            // for each single word
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                // for s1
                if (isPalindrome(s1)) {
                    String s2rvs = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2rvs) && map.get(s2rvs) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(s2rvs));
                        list.add(i);
                        res.add(list);
                    }
                }
                // for s2
                if (isPalindrome(s2)) {
                    String s1rvs = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1rvs) && map.get(s1rvs) != i && s2.length()!=0) { // to avoid dups
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(s1rvs));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left <= right) if (s.charAt(left++) != s.charAt(right--)) return false;
        return true;
    }
}
