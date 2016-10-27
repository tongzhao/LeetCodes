/**
 * Paint fence:
 * No more than two houses in the same color
 */
public class SolutionCCLXXVI {
    public int numWays(int n, int k) {
        if (n==0 || k==0) return 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i==0) dp[i] = k;
            else if (i==1) dp[i] = k*k;
            // all of these two cases based on you have case(i-1) then case(i)
            // so case(i-2) means i-1 and i in same color, and case(i-1) means they are not
            else dp[i] = dp[i-2]*(k-1)  + dp[i-1]*(k-1);
        }
        return dp[n-1];
    }
}
