import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * 390. Perfect Rectangular
 *
 * Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

 Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).


 Example 1:

 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [3,2,4,4],
 [1,3,2,4],
 [2,3,3,4]
 ]

 Return true. All 5 rectangles together form an exact cover of a rectangular region.

 Example 2:

 rectangles = [
 [1,1,2,3],
 [1,3,2,4],
 [3,1,4,2],
 [3,2,4,4]
 ]

 Return false. Because there is a gap between the two rectangular regions.

 Example 3:

 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [1,3,2,4],
 [3,2,4,4]
 ]

 Return false. Because there is a gap in the top center.

 Example 4:

 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [1,3,2,4],
 [2,2,4,4]
 ]

 Return false. Because two of the rectangles overlap with each other.
 */
public class SolutionCCCXC {
    // To make a perfect rectangle, two conditions need to be met:

    // 1. The total area of all sub-rectangles == (rightmost-leftmost)*(uppermost-lowermost);
    // 2. For every side of each sub-rectangle, there should be one or more sub-rectangles with corresponding counter-sides, except for the outermost sides,
    // i.e., for each top side, there should be corresponding bottom sides of other sub-rectangle(s) with the same values,
    // and the right sides should have corresponding left ones .
    // So we use four maps to store all sides(<Interval>) of the sub-rectangles,
    // and for each key in topmap, except for the uppermost side of the parent-rectangle,
    // there should be a same key in bottommap, and their values should be the same after merging.
    public boolean isRectangleCover(int[][] rectangles) {
        HashMap<Integer, List<Interval>> leftSide = new HashMap<Integer, List<Interval>>();
        HashMap<Integer, List<Interval>> rightSide = new HashMap<Integer, List<Interval>>();
        HashMap<Integer, List<Interval>> topSide = new HashMap<Integer, List<Interval>>();
        HashMap<Integer, List<Interval>> bottomSide = new HashMap<Integer, List<Interval>>();
        int area = 0;
        int top = Integer.MIN_VALUE, bottom = Integer.MAX_VALUE, leftmost = Integer.MAX_VALUE, rightmost = Integer.MIN_VALUE;
        for (int[] re : rectangles) {
            int l = re[0], r = re[2], b = re[1], t = re[3];
            top = Math.max(top, t); bottom = Math.min(bottom, b); leftmost = Math.min(leftmost, l); rightmost = Math.max(rightmost, r);
            if (!leftSide.containsKey(l)) leftSide.put(l, new ArrayList<Interval>());
            leftSide.get(l).add(new Interval(t, b));
            if (!rightSide.containsKey(r)) rightSide.put(r, new ArrayList<Interval>());
            rightSide.get(r).add(new Interval(t, b));
            if (!topSide.containsKey(t)) topSide.put(t, new ArrayList<Interval>());
            topSide.get(t).add(new Interval(l, r));
            if (!bottomSide.containsKey(b)) bottomSide.put(b, new ArrayList<Interval>());
            bottomSide.get(b).add(new Interval(l, r));
            area += (r - l) * (t - b);
        }
        if (area != (rightmost - leftmost) * (top - bottom)) return false; // have overlap or empty part
        if (topSide.size() != bottomSide.size() || leftSide.size() != rightSide.size()) return false; // not equivalent
        return compareSides(bottomSide, topSide, bottom) && compareSides(rightSide, leftSide, rightmost);
    }
    public boolean compareSides(HashMap<Integer, List<Interval>> map1, HashMap<Integer, List<Interval>> map2, int side) {
        for (int top : map1.keySet()) {
            if (top == side) continue;
            List<Interval> mergedList1 = merge(map1.get(top));
            if (!map2.containsKey(top)) return false;
            List<Interval> mergedList2 = merge(map2.get(top));
            if (mergedList1.size() != mergedList2.size()) return false;
            for (int i = 0; i < mergedList1.size(); i++) {
                if (mergedList1.get(i).start != mergedList2.get(i).start || mergedList1.get(i).end != mergedList2.get(i).end) return false;
            }
        }
        return true;
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals==null || intervals.size() < 2) return res;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(final Interval i1, final Interval i2) {
                return i1.start-i2.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start > end) {
                res.add(new Interval(start, end));
                start = curr.start;
            }
            if (curr.end > end){
                end = curr.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
