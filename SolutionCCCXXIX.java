/**
 * 329. Increasing path in matrix
 *
 * Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 nums = [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:

 nums = [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class SolutionCCCXXIX {
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        if (matrix==null || matrix.length==0) return res;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = findSmallerNeighbor(i, j, matrix, memo, Integer.MAX_VALUE);
                res = temp > res ? temp : res;
            }
        }
        return res;
    }
    public int findSmallerNeighbor(int i, int j, int[][] matrix, int[][] memo, int pre) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] >= pre) return 0;
        if (memo[i][j] > 0) return memo[i][j];
        else {
            int curr = matrix[i][j];
            int tempMax = 0;
            tempMax = Math.max(findSmallerNeighbor(i-1, j, matrix, memo, curr), tempMax);
            tempMax = Math.max(findSmallerNeighbor(i+1, j, matrix, memo, curr), tempMax);
            tempMax = Math.max(findSmallerNeighbor(i, j-1, matrix, memo, curr), tempMax);
            tempMax = Math.max(findSmallerNeighbor(i, j+1, matrix, memo, curr), tempMax);
            memo[i][j] = ++tempMax;
            return tempMax;
        }
    }
}
