import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Search II:
 *
 * Given a 2D board and a list of words from the dictionary,
 * find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */
public class SolutionCCXII {
    Set<String> res = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWords(board, visited, "", i, j, trie);
            }
        }
        return new ArrayList<String>(res);
    }
    public void findWords(char[][] board, boolean[][] visited, String curr, int i, int j, Trie trie){
        if (i<0 || i>=board.length || j<0 || j>=board[0].length) return;
        if (visited[i][j]) return;

        curr += board[i][j];
        if (!trie.startsWith(curr)) return;

        if (trie.search(curr)) res.add(curr);

        visited[i][j] = true;
        findWords(board, visited, curr, i-1, j, trie);
        findWords(board, visited, curr, i+1, j, trie);
        findWords(board, visited, curr, i, j-1, trie);
        findWords(board, visited, curr, i, j+1, trie);
        visited[i][j] = false;
    }
}
