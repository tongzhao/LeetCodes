import java.util.HashSet;

/**
 * 356. Line Reflection
 *
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.

 Example 1:
 Given points = [[1,1],[-1,1]], return true.

 Example 2:
 Given points = [[1,1],[-1,-1]], return false.

 Follow up:
 Could you do better than O(n^2)?
 */
public class SolutionCCCLVI {
    public boolean isReflected(int[][] points) {
        // symmetric
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<String>();
        for (int[] p : points) {
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            String s = p[0] + "SB" +p[1];
            set.add(s);
        }
        int sum = max + min;
        for (int[] p : points) {
            String s = (sum-p[0]) + "SB" + p[1];
            if (!set.contains(s)) return false;
        }
        return true;
    }
}
