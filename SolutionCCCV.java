import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class SolutionCCCV {
    @Deprecated
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if (m * n == 0 || positions==null || positions.length==0) return res;
        // update connected island
        int[][] record = new int[m][n];
        int islandCount = 0;
        // loop each position, cannot sort input position order
        for (int[] position: positions) {
            int x = position[0];
            int y = position[1];
            // isolated
            if (differentAndMinIsland(record, m, n, x, y)[1]==0) {
                islandCount++;
                res.add(islandCount);
            }
            // not isolated
            else {
                int min = differentAndMinIsland(record, m, n, x, y)[1];
                if (!(min<Integer.MAX_VALUE)) {
                    islandCount++;
                    record[x][y] = islandCount;
                    res.add(islandCount);
                } else {
                    islandCount -= (differentAndMinIsland(record, m, n, x, y)[0]-1);
                    res.add(islandCount);
                    broadcastNeighbour(record, m, n, x, y, min);
                }
            }
        }
        return res;
    }
    public static int[] differentAndMinIsland(int[][] record, int m, int n, int x, int y) {
        int res[] = new int[2];
        res[0] = 0;
        res[1] = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<Integer>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir: directions) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];
            if (x1<0 || x1>=m || y1<0 || y1>=n) continue;
            if (record[x1][y1]>0 && !set.contains(record[x1][y1])) {
                set.add(record[x1][y1]);
                res[0]++;
                res[1] = record[x1][y1] < res[1] ? record[x1][y1] : res[1];
            }
        }
        return res;
    }
    public static void broadcastNeighbour(int[][] record, int m, int n, int x, int y, int min) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] position = q.poll();
            int x1 = position[0];
            int y1 = position[1];
            record[x1][y1] = min;
            visited[x1][y1] = true;
            if (x1-1>=0 && !visited[x1-1][y1] && record[x1-1][y1]>0) q.add(new int[]{x1-1, y1});
            if (x1+1<m && !visited[x1+1][y1] && record[x1+1][y1]>0) q.add(new int[]{x1+1, y1});
            if (y1-1>=0 && !visited[x1][y1-1] && record[x1][y1-1]>0) q.add(new int[]{x1, y1-1});
            if (y1+1<n && !visited[x1][y1+1] && record[x1][y1+1]>0) q.add(new int[]{x1, y1+1});
        }
    }
    public static void main(String[] args) {
        int[][] input = new int[][]{{0,0},{0,1},{1,2},{2,1}};
        List<Integer> res = numIslands2(3, 3, input);
        for (int i: res) System.out.println(i);
        //System.out.println("Different Islands of (0,2): " + differentAndMinIsland(input, 3, 3, 0, 2));
    }
}
