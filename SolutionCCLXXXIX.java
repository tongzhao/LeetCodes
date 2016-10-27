/**
 * Game of Life:
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 * using the following four rules (taken from the above Wikipedia article):

 Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 Any live cell with two or three live neighbors lives on to the next generation.
 Any live cell with more than three live neighbors dies, as if by over-population..
 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 Write a function to compute the next state (after one update) of the board given its current state.
 */
public class SolutionCCLXXXIX {
    public static int[][] gameOfLife(int[][] board) {
        /**
         * Rule translation:
         * 1. count(1) < 2, 1->0
         * 2. count(1) = 2 || 3, 1->1
         * 3. count(1) > 3, 1->0
         * 4. count(0) = 3, 0->1
         * think of a state marking method to both record now and future state:
         * we have 3 states: 1->0 0->1 1->1, we can mark as below:
         * 1->0 as 2
         * 0->1 as 1
         * 1->1 as 3
         */
        if (board==null || board.length==0) return null;
        int[][] realcounts = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveCount = calculate(board, i, j);
                if (board[i][j]==1) {
                    if (liveCount == 2 || liveCount == 3) board[i][j] = 3;
                    else board[i][j] = 2;
                } else {
                    if (liveCount==3) board[i][j] = 1;
                }
                realcounts[i][j] = liveCount;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
        return realcounts;
    }
    public static int calculate(int[][] board, int i, int j) {
        int realCount = 0;
        if (i-1 >= 0 && j-1>=0) realCount += board[i-1][j-1]/2;
        if (i-1 >= 0) realCount += board[i-1][j]/2;
        if (i-1 >= 0 && j+1<board[0].length) realCount += board[i-1][j+1]/2;
        if (j+1<board[0].length) realCount += board[i][j+1];
        if (j-1>=0) realCount += board[i][j-1]/2;
        if (i+1<board.length && j-1>=0) realCount += board[i+1][j-1];
        if (i+1<board.length) realCount += board[i+1][j];
        if (i+1<board.length && j+1<board[0].length) realCount += board[i+1][j+1];
        return realCount;
    }
    public static void main(String[] args) {
        int[][] test = {{1,1}, {1,0}};
        int[][] realcounts;
        for (int row = 0; row < test.length; row++) {
            for (int col = 0; col < test[row].length; col++) {
                System.out.printf("%2d", test[row][col]);
            }
            System.out.println();
        }
        realcounts = gameOfLife(test);
        for (int row = 0; row < test.length; row++) {
            for (int col = 0; col < test[row].length; col++) {
                System.out.printf("%2d", test[row][col]);
            }
            System.out.println();
        }
        for (int row = 0; row < realcounts.length; row++) {
            for (int col = 0; col < realcounts[row].length; col++) {
                System.out.printf("%2d", realcounts[row][col]);
            }
            System.out.println();
        }
    }

}
