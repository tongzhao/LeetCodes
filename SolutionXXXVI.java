import java.util.HashSet;

public class SolutionXXXVI {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length==0) return false;
        int size = board.length;
        // 1. row-level
        for (int i = 0; i < size; i++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int j = 0; j < size; j++) {
                char c = board[i][j];
                if (c!='.') {
                    if (!set.contains(c)) set.add(c);
                    else return false;
                }
            }
            set.clear();
        }
        // 2. column-level
        for (int i = 0; i < size; i++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int j = 0; j < size; j++) {
                char c = board[j][i];
                if (c!='.') {
                    if (!set.contains(c)) set.add(c);
                    else return false;
                }
            }
            set.clear();
        }
        // 3. cluster-level
        for (int i = 0; i < size; i++) {
            int m = i / 3;
            int n = i % 3;
            HashSet<Character> set = new HashSet<Character>();
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    char c = board[m*3+k][n*3+l];
                    if (c!='.') {
                        if (!set.contains(c)) set.add(c);
                        else return false;
                    }
                }
            }
            set.clear();
        }
        return true;
    }
}
