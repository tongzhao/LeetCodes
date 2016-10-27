import java.util.HashMap;
import java.util.Map;

/**
 * Implement a trie with insert, search, and startsWith methods.
 */
class TrieNode {
    char c;
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    public TrieNode() {}
    public TrieNode(char c) {
        this.c = c;
    }
}
// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // insert a word into the trie
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t = null;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
            if (i==word.length()-1) t.isLeaf = true;
        }
    }

    public boolean search(String word) {
        TrieNode t = searchNode(word);
        if (t!=null && t.isLeaf) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix)!=null;
    }

    public TrieNode searchNode(String word) {
        TrieNode t = null;
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }
        return t;
    }
}
