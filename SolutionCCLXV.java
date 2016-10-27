/**
 * Paint House II
 There are a row of n houses, each house can be painted with one of the k colors.
 The cost of painting each house with a certain color is different.
 You have to paint all the houses such that no two adjacent houses have the same color.
 The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 Could you solve it in O(nk) runtime?
 */
public class SolutionCCLXV {
    // O(nk)-time complexity
    // Use two previous smallest index to record: prevMin, prevSec, and the index of prevMin
    public int minCostII(int[][] costs) {
        if (costs==null || costs.length==0) return 0;
        int prevMin = 0;
        int prevSec = 0;
        int prevIndex = -1; // index to record
        for (int i = 0; i < costs.length; i++) {
            // for each # of houses, we have update prev with curr
            int currMin = Integer.MAX_VALUE;
            int currSec = Integer.MAX_VALUE;
            int currIndex = -1;
            for (int j = 0; j < costs[0].length; j++) {
                costs[i][j] += (prevIndex==j ? prevSec : prevMin);
                if (costs[i][j] < currMin) {
                    currSec = currMin;
                    currMin = costs[i][j];
                    currIndex = j;
                } else if (costs[i][j] < currSec) currSec = costs[i][j];
            }
            prevMin = currMin;
            prevSec = currSec;
            prevIndex = currIndex;
        }
        return prevMin;
    }
}
