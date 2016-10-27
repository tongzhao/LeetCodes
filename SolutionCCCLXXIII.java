import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:
 Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

 Return: [1,2],[1,4],[1,6]

 The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 Example 2:
 Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

 Return: [1,1],[1,1]

 The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 Example 3:
 Given nums1 = [1,2], nums2 = [3],  k = 3

 Return: [1,3],[2,3]

 All possible pairs are returned from the sequence:
 [1,3],[2,3]
 */
public class SolutionCCCLXXIII {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if (nums1==null || nums2==null || nums1.length==0 || nums2.length==0) return res;
        int len1 = nums1.length;
        int len2 = nums2.length;

        PriorityQueue<Pair> q = new PriorityQueue<Pair>(k, new ComparePair());
        for (int i = 0; i < nums1.length && i < k; i++) {
            q.offer(new Pair(0, nums1[i], nums2[0])); // only need first k numbers in nums1 to start
        }
        for (int i = 1; i <= k && !q.isEmpty(); i++) {
            Pair p = q.poll();
            res.add(p.pair);
            if (p.index < len2-1) {
                int next = p.index + 1;
                q.offer(new Pair(next, p.pair[0], nums2[next]));
            }
        }
        return res;
    }

    class Pair {
        int index;
        int[] pair;
        long sum;
        public Pair(int index, int n1, int n2) {
            this.index = index;
            this.pair = new int[] {n1, n2};
            this.sum = (long) n1 + (long) n2;
        }
    }
    class ComparePair implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            return (int)p1.sum;
        }
    }
}
