/**
 * 361. Bomb Enemy
 *
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 Note that you can only put the bomb at an empty cell.

 Example:
 For the given grid

 0 E 0 0
 E 0 W E
 0 E 0 0

 return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */
public class SolutionCCCLXI {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length==0 || grid[0].length==0) return 0;
        int res = 0;
        int l = grid.length;
        int w = grid[0].length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '0') res = res >= findMax(grid, i, j) ? res : findMax(grid, i, j);
            }
        }
        return res;
    }
    public int findMax(char[][] grid, int i, int j) {
        int res = 0;
        for (int top = i; top >=0 && grid[top][j] != 'W'; top--) {
            if (grid[top][j] == 'E') res++;
        }
        for (int bottom = i; bottom < grid.length && grid[bottom][j] != 'W'; bottom++) {
            if (grid[bottom][j] == 'E') res++;
        }
        for (int left = j; left >= 0 && grid[i][left] != 'W'; left--) {
            if (grid[i][left] == 'E') res++;
        }
        for (int right = j; right < grid[0].length && grid[i][right] != 'W'; right++) {
            if (grid[i][right] == 'E') res++;
        }
        return res;
    }
}
