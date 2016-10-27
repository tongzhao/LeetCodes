/**
 * 358. Rearrange String k Distance Apart
 *
 * Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.

 All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

 Example 1:
 str = "aabbcc", k = 3

 Result: "abcabc"

 The same letters are at least distance 3 from each other.
 Example 2:
 str = "aaabc", k = 3

 Answer: ""

 It is not possible to rearrange the string.
 Example 3:
 str = "aaadbbcc", k = 2

 Answer: "abacabcd"

 Another possible answer is: "abcabcda"

 The same letters are at least distance 2 from each other.
 */
public class SolutionCCCLVIII {
    public String rearrangeString(String str, int k) {
        int length = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for (int i = 0; i < length; i++) count[str.charAt(i)-'a']++;
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < length; index++) {
            int pos = findValidMax(count, valid, index);
            if (pos==-1) return "";
            count[pos]--;
            valid[pos] = index+k;
            sb.append((char)('a'+pos));
        }
        return sb.toString();
    }
    public int findValidMax(int[] count, int[] valid, int index) {
        int pos = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] > max && index >= valid[i]) {
                max = count[i];
                pos = i;
            }
        }
        return pos;
    }
}
