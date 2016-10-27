import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Best Meeting Point:
 *
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1,
 * where each 1 marks the home of someone in the group.
 * The distance is calculated using Manhattan Distance,
 * where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

 For example, given three people living at (0,0), (0,4), and (2,2):

 1 - 0 - 0 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0
 The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal.
 So return 6.
 */
public class SolutionCCXCVI {
    public int minTotalDistance(int[][] grid) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1) {
                    list1.add(i);
                    list2.add(j);
                }
            }
        }
        // vector addition, so just get each dimension is enough
        return getMin(list1) + getMin(list2);
    }
    public int getMin(List<Integer> list) {
        Collections.sort(list);
        int i = 0;
        int j = list.size()-1;
        int res = 0;
        while (i < j) {
            res += list.get(j--) - list.get(i++);
        }
        return res;
    }
}
