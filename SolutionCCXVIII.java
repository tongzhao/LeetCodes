import java.util.LinkedList;
import java.util.List;

/**
 * Skyline Problem
 */
public class SolutionCCXVIII {
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length == 0)
            return new LinkedList<int[]>();
        return recurSkyline(buildings, 0, buildings.length - 1);
    }
    // Divide and Conquer
    public LinkedList<int[]> recurSkyline(int[][] buildings, int left, int right) {
        if (left < right) {
            int mid = left + (right-left)/2;
            return merge(recurSkyline(buildings, left, mid), recurSkyline(buildings, mid+1, right));
        } else {
            LinkedList<int[]> res = new LinkedList<int[]>();
            res.add(new int[]{buildings[left][0], buildings[left][2]});
            res.add(new int[]{buildings[left][1], 0});
            return res;
        }
    }
    public LinkedList<int[]> merge(LinkedList<int[]> l1, LinkedList<int[]> l2) {
        LinkedList<int[]> res = new LinkedList<int[]>();
        int h1 = 0;
        int h2 = 0;
        while (l1.size()>0 && l2.size()>0) {
            int x = 0;
            int h = 0;
            if (l1.getFirst()[0] < l2.getFirst()[0]) {
                x = l1.getFirst()[0];
                h1 = l1.getFirst()[1];
                h = Math.max(h1, h2);
                l1.removeFirst();
            } else if (l1.getFirst()[0] > l2.getFirst()[0]) {
                x = l2.getFirst()[0];
                h2 = l2.getFirst()[1];
                h = Math.max(h1, h2);
                l2.removeFirst();
            } else {
                x = l1.getFirst()[0];
                h1 = l1.getFirst()[1];
                h2 = l2.getFirst()[1];
                h = Math.max(h1, h2);
                l1.removeFirst();
                l2.removeFirst();
            }
            if (res.size()==0 || h!=res.getLast()[1]) {
                res.add(new int[]{x, h});
            }
        }
        res.addAll(l1);
        res.addAll(l2);
        return res;
    }
}
