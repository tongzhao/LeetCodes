/**
 * Dungeon Game, HP to rescue the princess
 */
public class SolutionCLXXIV {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] leastHP = new int[m][n];

        leastHP[m-1][n-1] = Math.max(1-dungeon[m-1][n-1], 1);

        for (int i = m-2; i >=0; i--) {
            leastHP[i][n-1] = Math.max(leastHP[i+1][n-1]-dungeon[i][n-1], 1);
        }
        for (int j = n-2; j >=0; j--) {
            leastHP[m-1][j] = Math.max(leastHP[m-1][j+1]-dungeon[m-1][j], 1);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(leastHP[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(leastHP[i][j + 1] - dungeon[i][j], 1);
                leastHP[i][j] = Math.min(right, down);
            }
        }
        return leastHP[0][0];
    }
}
