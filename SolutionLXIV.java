/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class SolutionLXIV {
    public int minPathSum(int[][] grid) {
        if (grid==null || grid[0].length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 && j==0) continue;
                else if (i==0) grid[i][j] += grid[i][j-1];
                else if (j==0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += (grid[i-1][j] < grid[i][j-1]) ? grid[i-1][j] : grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }
}
