import java.util.PriorityQueue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.
 */
public class SolutionCCCLXXVIII {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for (int j = 0; j < n; j++) pq.add(new Tuple(0, j, matrix[0][j]));
        for (int i = 0; i < k-1; i++) { // k-1 times
            Tuple top = pq.poll();
            if (top.x == n-1) continue;
            pq.add(new Tuple(top.x+1, top.y, matrix[top.x+1][top.y]));
        }
        return pq.poll().val;
    }
    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple (int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.val = value;
        }
        @Override
        public int compareTo(final Tuple o) {
            return this.val - o.val;
        }
    }
}
