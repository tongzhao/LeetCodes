import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 352. Data Stream as Disjoint Intervals
 *
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

 For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

 [1, 1]
 [1, 1], [3, 3]
 [1, 1], [3, 3], [7, 7]
 [1, 3], [7, 7]
 [1, 3], [6, 7]
 Follow up:
 What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    TreeMap<Integer, Interval> treeMap;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        treeMap = new TreeMap<Integer, Interval>();
    }

    public void addNum(int val) {
        if (treeMap.containsKey(val)) return;
        Integer low = treeMap.lowerKey(val);
        Integer high = treeMap.higherKey(val);
        // case 0: this value can connect two intervals
        if (low != null && high != null && treeMap.get(low).end+1 == val && treeMap.get(high).start-1 == val) {
            treeMap.get(low).end = treeMap.get(high).end;
            treeMap.remove(high);
        }
        // case 1: this value can connect one interval not on start
        else if (low != null && treeMap.get(low).end+1 >= val) treeMap.get(low).end = Math.max(val, treeMap.get(low).end);
        // case 2: this vlaue can connect one interval on its start
        else if (high != null && high-1 == val) {
            treeMap.put(val, new Interval(val, treeMap.get(high).end));
            treeMap.remove(high);
        }
        // case 3: no such interval, create new one
        else treeMap.put(val, new Interval(val, val));
    }

    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(treeMap.values());
    }
}
