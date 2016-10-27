/**
 * Additive Number:
 *
 * Additive number is a positive integer whose digits can form additive sequence.

 A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

 For example:
 "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 1 + 99 = 100, 99 + 100 = 199
 */
public class SolutionCCCVI {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        int n = num.length();
        for (int i = 1; i < n; i++) {
            if (i > 1 && num.charAt(0)=='0') break;
            for (int j = i+1; j < n; j++) {
                int first = 0, second = i, third = j;
                if (num.charAt(second)=='0' && third > second+1) break;
                while (third < n) {
                    Long result = (Long.parseLong(num.substring(first, second)) +
                                   Long.parseLong(num.substring(second, third)));
                    if (num.substring(third).startsWith(result.toString())) {
                        first = second; second = third; third += result.toString().length();
                    }
                    else {
                        break;
                    }
                }
                if (third==n) return true;
            }
        }
        return false;
    }
}
