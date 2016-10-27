import java.util.HashSet;
import java.util.Set;

/**
 * 323. Number of connected components in undirected graph
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

 Example 1:
 0          3
 |          |
 1 --- 2    4
 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

 Example 2:
 0           4
 |           |
 1 --- 2 --- 3
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 */
public class SolutionCCCXXIII {
    private int[] father;
    public int countComponents(int n, int[][] edges) {
        father = new int[n];
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) father[i] = i;
        for (int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1]);
        }
        for (int i = 0; i < n; i++) set.add(find(i));
        return set.size();
    }
    public int find(int node) {
        if (father[node]==node) return node;
        father[node] = find(father[node]);
        return father[node];
    }
    public void union(int node1, int node2) {
        father[find(node1)] = find(node2);
    }
}
