import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II
 *
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to num2's size? Which algorithm is better?

 */
public class SolutionCCCL {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map3 = new HashMap<Integer, Integer>();
        for (int i: nums1) addToMap(i, map1);
        for (int i: nums2) addToMap(i, map2);
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) map3.put(key, Math.min(map1.get(key), map2.get(key)));
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int key: map3.keySet()) {
            output(key, map3.get(key), list);
        }
        return listToArray(list);
    }

    public void addToMap(int num, Map<Integer, Integer> map) {
        if (map.containsKey(num)) map.put(num, map.get(num)+1);
        else map.put(num, 1);
    }
    public void output(int key, int value, List<Integer> list) {
        for (int i = 0; i < value; i++) list.add(key);
    }
    public int[] listToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        int index = 0;
        for (int i: list) res[index++] = i;
        return res;
    }
}
