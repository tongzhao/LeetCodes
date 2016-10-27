import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Alien Dictionary:
 Given the following words in dictionary,
 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]
 The correct order is: "wertf".
 NOTE: WORDS are sorted
 "zebra"
 "zoo" - > "o" is behind "e"
 */
public class AlienDictionary_graph {
    public String alienOrder(String[] words) {
        if (words == null) return null;

        Map<Character, Set<Character>> graph_hm = new HashMap<Character, Set<Character>>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!graph_hm.containsKey(c)) {
                    graph_hm.put(c, new HashSet<Character>());
                }
            }
            if (i > 0) {	// order every two words
                getOrder(words[i-1], words[i], graph_hm);
            }
        }
        return topSort(graph_hm);

    }

    public void getOrder(String s, String t, Map<Character, Set<Character>> graph_hm) {

        for(int i = 0; i < Math.min(s.length(), t.length()); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);

            if (c1 != c2) {
                if (!graph_hm.get(c1).contains(c2)) {
                    graph_hm.get(c1).add(c2);
                }
                break; // stop here because after one char different, remaining chars doesn't matter
            }
        }
    }

    // standard top sort algorithm
    public String topSort(Map<Character, Set<Character>> graph_hm) {

        StringBuilder sb = new StringBuilder();

        // count initial indegree for every char vertex
        Map<Character, Integer> indegree = new HashMap<Character, Integer>();
        for(char c : graph_hm.keySet()) {
            for(char a : graph_hm.get(c)) {
                int count = indegree.containsKey(a) ? indegree.get(a) + 1 : 1;
                indegree.put(a, count);
            }
        }

        // find indegree==0, initialize the queue
        Queue<Character> queue = new LinkedList<Character>();
        for(char c : graph_hm.keySet()) {
            if(!indegree.containsKey(c)) {
                queue.offer(c);
            }
        }

        // topological sort
        while(!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for(char a : graph_hm.get(c)) {
                indegree.put(a, indegree.get(a) - 1);
                if(indegree.get(a) == 0) {
                    queue.offer(a);
                }
            }
        }

        for (int a : indegree.values()) {// if there is any non sorted, this is not a DAG, return false
            if (a != 0) return "";
        }
        return sb.toString();
    }

    public static void main(String [] args) {
        AlienDictionary_graph outer = new AlienDictionary_graph();

        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};

        System.out.println(outer.alienOrder(words));
    }
}
