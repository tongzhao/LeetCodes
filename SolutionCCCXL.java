/**
 * 340. Longest Substring with At Most K Distinct Characters
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

 For example, Given s = “eceba” and k = 2,

 T is "ece" which its length is 3.
 */
public class SolutionCCCXL {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int left = 0, num = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            if (count[s.charAt(right)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(left++)] > 0); // remove all chars in charAt(left) until count hits 0
                num--;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
