/**
 * Shortest Word Distance III:
 *
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 word1 and word2 may be the same and they represent two individual words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 Given word1 = "makes", word2 = "coding", return 1.
 Given word1 = "makes", word2 = "makes", return 3.
 */
public class SolutionCCXLV {
    public static int shortestWordDistance(String[] words, String word1, String word2) {
        // two cases: if same, else diff
        int index1 = -1;
        int index2 = -1;
        int res = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            for (int i = 0; i < words.length; i++) {
                if (word1.equals(words[i])) {
                    if (index1 > index2) {
                        index2 = i;
                        res = Math.min(res, Math.abs(index1-index2));
                    } else {
                        index1 = i;
                        if (index2 != -1) {
                            res = Math.min(res, Math.abs(index1-index2));
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < words.length; i++) {
                if (word1.equals(words[i])) {
                    index1 = i;
                    if (index2 >= 0) res = Math.min(res, Math.abs(index1-index2));
                }
                if (word2.equals(words[i])) {
                    index2 = i;
                    if (index1 >= 0) res = Math.min(res, Math.abs(index1-index2));
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "makes";
        System.out.println(shortestWordDistance(words, word1, word2));
    }
}
