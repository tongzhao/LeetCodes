import java.util.HashSet;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 Your algorithm should run in O(n) complexity.
 */
public class SolutionCXXVIII {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int res = 0;
        for (int n: nums) {
            set.add(n);
        }
        for (int n: nums) {
            if (!set.contains(n-1)) {
                int m = n + 1;
                while (set.contains(m)) {
                    m++;
                }
                res = res > m-n ? res : m-n;
            }
        }
        return res;
    }
}
