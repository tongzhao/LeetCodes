/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false
 */
public class SolutionLXXIX {
    public static boolean exist(char[][] board, String word) {
        if (word==null || word.length()==0 || board==null ||board[0].length==0) return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int count = 1;
                    visited[i][j] = true;
                    if (exist(board, word, i, j, count, visited)) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    public static boolean exist(char[][] board, String word, int i, int j, int count, boolean[][] visited) {
        if (word.length()==count) return true;
        visited[i][j] = true;
        if (i+1<board.length && board[i+1][j]==word.charAt(count) && !visited[i+1][j])
            return exist(board, word, i+1, j, count+1, visited);
        if (i-1>=0 && board[i-1][j]==word.charAt(count) && !visited[i-1][j])
            return exist(board, word, i-1, j, count+1, visited);
        if (j+1<board[0].length && board[i][j+1]==word.charAt(count) && !visited[i][j+1])
            return exist(board, word, i, j+1, count+1, visited);
        if (j-1>=0 && board[i][j-1]==word.charAt(count) && !visited[i][j-1])
            return exist(board, word, i, j-1, count+1, visited);
        visited[i][j] = false;
        return false;
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                         {'S','F','C','S'},
                         {'A','D','E','E'}};
        String test = "ABCCED";
        String test1 = "ABFCSEEDAS";
        if (exist(board, test1)) System.out.println("Yah!!!");
    }
}
