import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Meeting Rooms II
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return 2.
 */
public class SolutionCCLIII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals==null || intervals.length==0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(final Interval i1, final Interval i2) {
                return i1.start - i2.start;
            }
        });

        PriorityQueue<Interval> earliest = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(final Interval i1, final Interval i2) {
                return i1.end-i2.end;
            }
        });
        earliest.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval interval = intervals[i];

            Interval earliestInterval = earliest.poll();

            if (earliestInterval.end <= interval.start) {
                earliestInterval.end = interval.end;
            } else {
                earliest.add(interval);
            }
            earliest.add(earliestInterval);
        }
        return earliest.size();
    }
}
