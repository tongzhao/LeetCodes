/**
 * 335. Self Crossing
 *
 * You are given an array x of n positive numbers.
 * You start at point (0,0) and moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on.
 * In other words, after each move your direction changes counter-clockwise.

 Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
 */
public class SolutionCCCXXXV {
    public static boolean isSelfCrossing(int[] x) {
        if (x.length <= 3) return false;
        int i = 2;
        // keep spiral outward first
        while (i < x.length && x[i] > x[i-2]) i++;
        if (i >= x.length) return false; // only have the outward spiral, no intersections
        // from outward to inward
        if ((i >= 4 && x[i] >= x[i-2] - x[i-4]) || ( i==3 && x[i] == x[i-2])) x[i-1] -= x[i-3];
        i++;
        // keep spiral inward
        while (i < x.length) {
            if (x[i] >= x[i-2]) return true;
            i++;
        }
        return false;
    }
}
