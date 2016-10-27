/**
 * Given a positive integer n,
 * find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3, because 12 = 4 + 4 + 4;
 given n = 13, return 2, because 13 = 4 + 9.
 */
public class SolutionCCLXXIX {
    public int numSquares(int n) {
        // 1,2,3,4,5,6,7,8,9,10
        // 1,2,3,1,2,3,4,2,1,2
        if (n==1) return 1;
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) res[i] = i;
        for (int i=2; i<=n; i++) {
            int sqrt = largestSQRT(i);
            for (int j = sqrt; j >= 1; j--) {
                int adder = i - j*j;
                res[i] = Math.min(res[i], res[adder]+1);
            }
        }
        return res[n];
    }
    public int largestSQRT(int i) {
        return (int)Math.sqrt(i)/1;
    }
}
