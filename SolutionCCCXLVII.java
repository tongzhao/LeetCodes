import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 347. Top K Frequent Elements
 *
 * Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class SolutionCCCXLVII {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums==null || nums.length==0) return res;
        Set<ValCount> setvc = new HashSet<ValCount>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<ValCount> pq = new PriorityQueue<ValCount>(k, new Comparator<ValCount>() {
            @Override
            public int compare(ValCount v1, ValCount v2) {
                return v1.count - v2.count;
            }
        });

        for (int num: nums) update(map, num);
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) setvc.add(new ValCount(entry.getKey(), entry.getValue()));
        for (ValCount valCount: setvc) {
            if (pq.size()!=k) {
                pq.add(valCount);
            } else {
                if (pq.peek().count < valCount.count) {
                    pq.remove();
                    pq.add(valCount);
                }
            }
        }
        for (ValCount valCount: pq) res.add(valCount.val);
        return res;
    }

    public void update(Map<Integer, Integer> map, int num) {
        if (!map.containsKey(num)) map.put(num, 1);
        else map.put(num, map.get(num)+1);
    }
}

class ValCount {
    int val;
    int count;
    public ValCount(int val, int count) {
        this.val = val;
        this.count = count;
    }
}
