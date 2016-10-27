/**
 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 */
public class WordDictionary {
    public class TrieNode {
        public String item = "";
        public TrieNode[] children = new TrieNode[26];
    }

    TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.item = word;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    public boolean match(char[] cs, int k, TrieNode node) {
        if (k==cs.length) return !node.item.equals("");
        if (cs[k] == '.') return node.children[cs[k] - 'a'] != null && match(cs, k+1, node.children[cs[k] - 'a']);
        else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(cs, k+1, node.children[i])) return true;
                }
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
