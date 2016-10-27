/**
 * 357. Unique Digit Numbers
 *
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.

 Example:
 Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
public class SolutionCCCLVII {
    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10) return 0; // dups
        if (n==0) return 1; // 0
        if (n==1) return 10; // 0-9
        int[] res = new int[11]; // n from 0-10, 11 will have duplicates (return 0), so 11 in total
        res[0] = 1;
        res[1] = 10;
        for (int i = 2; i <= 10; i++) {
            // Pick unique i numbers from 10 digits, mind 0
            res[i] = res[i-1] + alignment(10, i) - alignment(9, i-1);
        }
        return res[n];
    }
    public int alignment(int n, int m) {
        int res = 1;
        for (int i = n; i >= n-m+1; i--) res *= i;
        return res;
    }
}
