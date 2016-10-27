import java.util.Arrays;

/**
 * Graph Valid Tree:
 * Eg.
 * Edges =
 * [[0, 1],
 *  [0, 2],
 *  [1, 2]]
 *  Return false;
 */
public class SolutionCCLXI {
    public boolean validTree(int n, int[][] edges) {
        // union-find, check if the two ancestor are same.
        // return false if they are same, otherwise union
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        // pick each edge to union-find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            if (x==y) return false;
            // union
            nums[x] = y;
        }
        return edges.length==n-1; // if there is other edges not connected
    }
    public int find(int[] nums, int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
    /**
     * Mock Process:
     * i = 0: x = 0, y = 1, nums = [1, -1, -1]
     * i = 1: x = 1, y = 2, nums = [1, 2, -1]
     * i = 2: x = 2, y = 2, x==y, return false;
     */
}
