/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class SolutionCLXXII {
    public int trailingZeroes(int n) {
        // key is number of 5 is much fewer than number of 2, so count for 5s
        int count = 0;
        while (n > 0) {
            count += n/5;
            n /= 5;
        }
        return count;
    }
}
