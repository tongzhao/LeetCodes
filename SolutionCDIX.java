/**
 * 409. Longest Palindrome
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class SolutionCDIX {
    public int longestPalindrome(String s) {
        // Using an array to count each value, length of 52
        int[] counts = new int[52]; // for A-Z a-z
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            // https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
            if (val >= 97) counts[val-'a'+26]++;
            else counts[val-'A']++;
        }
        int res = 0;
        int oddsMax = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2!=0) oddsMax = oddsMax > counts[i] ? oddsMax : counts[i];
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 == 0) res += counts[i];
            else res += counts[i]-1;
        }
        res += oddsMax > 0 ? 1 : 0; // if there is odds max value that greater than 0, which means not all even counts
        return res;
    }
}
