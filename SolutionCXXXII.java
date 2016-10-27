/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 Return the minimum cuts needed for a palindrome partitioning of s.
 For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class SolutionCXXXII {
    public int minCut(String s){
        int length = s.length();
        int[] dp = new int[length+1];
        boolean[][] pa = new boolean[length][length];
        for(int i=0; i<=length; i++){
            dp[length-i] = i;
        }
        for(int i=length-1; i>=0; i--){
            for(int j=i; j<=length-1; j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<2 || pa[i+1][j-1])){
                    pa[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j+1]+1);
                }
            }
        }
        return dp[0]-1;
    }
}
