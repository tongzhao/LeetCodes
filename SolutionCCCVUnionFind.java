import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Number of Islands II:
 *
 * A 2d grid map of m rows and n columns is initially filled with water.
 * We may perform an addLand operation which turns the water at position (row, col) into a land.
 * Given a list of positions to operate, count the number of islands after each addLand operation.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.

 Example:

 Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

 0 0 0
 0 0 0
 0 0 0
 Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

 1 0 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

 1 1 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

 1 1 0
 0 0 1   Number of islands = 2
 0 0 0
 Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

 1 1 0
 0 0 1   Number of islands = 3
 0 1 0
 We return the result as an array: [1, 1, 2, 3]
 */
public class SolutionCCCVUnionFind {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] x_dir = {-1, 0, 1, 0};
        int[] y_dir = {0, -1, 0, 1};
        List<Integer> res = new ArrayList<Integer>();
        if (m * n == 0) return res;
        int[] roots = new int[m*n];
        Arrays.fill(roots, -1);
        for (int[] pos: positions) {
            roots[pos[0]*n+pos[1]] = pos[0]*n+pos[1];
            int count = res.isEmpty() ? 1 :res.get(res.size()-1)+1;
            // check neighbors
            for (int i = 0; i < 4; i++) {
                int x1 = x_dir[i] + pos[0];
                int y1 = y_dir[i] + pos[1];
                // if neighbour is island in some part
                if (x1>=0 && x1<m && y1>=0 && y1<n && roots[x1*n+y1] != -1) {
                    int root1 = find(x1*n+y1, roots);
                    int root2 = roots[pos[0]*n+pos[1]];
                    if (root1 != root2) count--;
                    roots[root1] = root2;
                }
            }
            res.add(count);
        }
        return res;
    }
    public int find(int target, int[] roots) {
        while(target!=roots[target]) target = roots[target];
        return target;
    }
}
