/**
 * 402. Remove K Digits
 *
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

 Note:
 The length of num is less than 10002 and will be ≥ k.
 The given num does not contain any leading zero.
 Example 1:

 Input: num = "1432219", k = 3
 Output: "1219"
 Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 Example 2:

 Input: num = "10200", k = 1
 Output: "200"
 Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 Example 3:

 Input: num = "10", k = 2
 Output: "0"
 Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class SolutionCDII {
    // If you try to remove one digit and get the smallest, you will use next int to replace the deleted one,
    // therefore, you need to remove the first descending one
    public String removeKdigits(String num, int k) {
        int i, j;
        StringBuilder sb = new StringBuilder(num);
        for (i = 0; i < k; i++) {
            for (j = 0; j < sb.length()-1 && sb.charAt(j) <= sb.charAt(j+1); j++) {}
            sb.delete(j, j+1);
        }
        while (sb.length() > 1 && sb.charAt(0)=='0') sb.delete(0,1);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
