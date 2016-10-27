import java.util.Arrays;
import java.util.Comparator;

/**
 * Meeting Rooms
 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 determine if a person could attend all meetings.
 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return false.
 */
public class SolutionCCLII {
    public static boolean canAttendMeetings(Interval[] intervals) {
        if (intervals==null || intervals.length==0) return true;
        Comparator<Interval> newComparator = new Comparator<Interval>() {
            @Override
            public int compare(final Interval i1, final Interval i2) {
                return i1.start-i2.start;
            }
        };
        Arrays.sort(intervals, newComparator);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i-1].end) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(0, 30);
        Interval i2 = new Interval(5, 10);
        Interval i3 = new Interval(15, 20);
        Interval[] intervals = new Interval[]{i1, i2, i3};
        if (canAttendMeetings(intervals)) {
            System.out.print("True");
        }
        else {
            System.out.print("False");
        }
    }
}
