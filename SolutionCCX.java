import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them.

 If it is impossible to finish all courses, return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */
public class SolutionCCX {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int length = prerequisites.length;
        if (length==0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
        // setup counters
        int[] counters = new int[numCourses];
        for (int i = 0; i < length; i++) {
            counters[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (counters[i]==0) q.add(i);
        }
        int numNoPre = q.size();

        int[] result = new int[numCourses];

        int j = 0;

        while (!q.isEmpty()) {
            int top = q.remove();
            result[j++] = top;
            for (int i = 0; i < length; i++) {
                if (prerequisites[i][1]==top) {
                    counters[prerequisites[i][0]]--;
                    if (counters[prerequisites[i][0]]==0) {
                        numNoPre++;
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }
        if (numCourses == numNoPre) return result;
        return new int[0];
    }
}
