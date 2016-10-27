/**
 * 395. Longest substring contains at least k-time chars
 *
 * Example 1:

 Input:
 s = "aaabb", k = 3
 Output:
 3

 The longest substring is "aaa", as 'a' is repeated 3 times.
 Example 2:
 Input:
 s = "ababbc", k = 2

 Output:
 5
 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class SolutionCCCXCV {
    public int longestSubstring(String s, int k) {
        char[] cs = s.toCharArray();
        return helper(cs, 0, s.length(), k);
    }
    public int helper(char[] cs, int start, int end, int k) {
        if (end - start < k) return 0;
        int[] count = new int[26];
        for (int i = start; i < end; i++) count[cs[i]-'a']++;
        for (int i = 0; i < 26; i++) {
            if (count[i]==0) continue;
            if (count[i] < k) {
                for (int j = start; j < end; j++) {
                    if (cs[j] == i+'a') {
                        int left = helper(cs, start, j, k);
                        int right = helper(cs, j+1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }
}
