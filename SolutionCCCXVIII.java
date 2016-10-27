/**
 * 318. Maximum Product of Word Lengths
 *
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters.
 * If no such two words exist, return 0.

 Example 1:
 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:
 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:
 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.
 */
public class SolutionCCCXVIII {
    public int maxProduct(String[] words) {
        int res = 0;
        if (words==null || words.length==0) return res;
        for (int i = 0; i < words.length; i++) {
            int[] letters = new int[26];
            for (char c: words[i].toCharArray()) {
                letters[c-'a']++;
            }
            for (int j = 0; j < words.length; j++) {
                if (j==i) continue;
                int k = 0;
                for (; k < words[j].length(); k++) {
                    if (letters[words[j].charAt(k) - 'a'] != 0) break;
                }
                if (k==words[j].length()) res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }
}
