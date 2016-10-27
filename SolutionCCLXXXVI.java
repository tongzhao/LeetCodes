import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to
 represent INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate.
 If it is impossible to reach a gate, it should be filled with INF.

 For example, given the 2D grid:
 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
 */
public class SolutionCCLXXXVI {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        Queue<Grid> queue = new LinkedList<Grid>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Grid(i, j));
                }
            }
        }
        int[][] diffs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            Grid cur = queue.poll();
            for (int[] diff : diffs) {
                int i = cur.x + diff[0];
                int j = cur.y + diff[1];
                if (i >= 0 && i <= rooms.length - 1 && j >= 0 && j <= rooms[0].length - 1 && rooms[i][j] == Integer.MAX_VALUE) {
                    rooms[i][j] = rooms[cur.x][cur.y] + 1;
                    queue.offer(new Grid(i, j));
                }
            }
        }
    }
}

class Grid {
    int x;
    int y;
    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
