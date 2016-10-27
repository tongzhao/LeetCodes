import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SolutionLVI {
    public static List<Interval> merge(List<Interval> intervals) {
        /**
         * [1,4][2,6][8,10][11,13]
         * [1,6][8,10][11,13]
         */
        List<Interval> res = new ArrayList<Interval>();
        if (intervals==null || intervals.size()<=1) return intervals;
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(final Interval i1, final Interval i2) {
                return i1.start-i2.start;
            }
        };
        Collections.sort(intervals, comparator);
        Interval in1 = intervals.get(0);
        for (int i=1; i<intervals.size(); i++) {
            Interval in2 = intervals.get(i);
            if (in1.end >= in2.start) {
                in1 = new Interval(in1.start, Math.max(in1.end, in2.end));
            }
            else {
                res.add(in1);
                in1 = in2;
            }
        }
        res.add(in1);
        return res;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1,4);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(11,13);
        List<Interval> list = new ArrayList<Interval>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        List<Interval> res = merge(list);
        for (Interval i: res) {
            System.out.println("Interval: "+i.start+" "+i.end);
        }
    }
}
