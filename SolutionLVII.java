import java.util.ArrayList;
import java.util.List;

public class SolutionLVII {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        // assumed in the question it is sorted
        for (Interval i1: intervals) {
            if (i1.end < newInterval.start) res.add(i1);
            else if (i1.start > newInterval.end) {
                res .add(newInterval);
                newInterval = i1;
            }
            else if (i1.end >= newInterval.start || i1.start <= newInterval.end) {
                newInterval = new Interval(Math.min(i1.start, newInterval.start), Math.max(i1.end, newInterval.end));
            }
        }
        res.add(newInterval);
        return res;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1,4);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(11,13);
        List<Interval> list = new ArrayList<Interval>();
        list.add(i1);
        list.add(i3);
        list.add(i4);
        Interval newInterval = new Interval(3,9);
        List<Interval> res = insert(list, newInterval);
        for (Interval i: res) {
            System.out.println("Interval: "+i.start+" "+i.end);
        }
    }
}
