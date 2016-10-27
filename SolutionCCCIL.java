import java.util.HashSet;
import java.util.Set;

/**
 349. Intersection of Two Arrays

 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 */
public class SolutionCCCIL {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        if (nums1.length==0 || nums2.length==0) return new int[0];
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) res.add(i);
        }
        if (res.size()==0) return new int[0];
        int[] result = new int[res.size()];
        int i = 0;
        for (int num : res) result[i++] = num;
        return result;
    }
}
