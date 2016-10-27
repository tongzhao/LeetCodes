import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the total number of courses and a list of prerequisite pairs,
 * is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take.
 To take course 1 you should have finished course 0.
 So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take.
 To take course 1 you should have finished course 0,
 and to take course 0 you should also have finished course 1.
 So it is impossible.
 */
public class SolutionCCVII {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // BFS to find if there is DAC
        if (prerequisites==null) return false;
        int len = prerequisites.length;
        if (numCourses==0 || len==0) return true;
        // setup counters
        int[] counters = new int[numCourses];
        for (int i = 0; i < len; i++) {
            counters[prerequisites[i][0]]++; // number of precourses for course i
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (counters[i]==0) q.add(i); // add the courses with prerequisites
        }

        int numNoPre = q.size();

        while (!q.isEmpty()) {
            int top = q.remove();
            for (int i = 0; i < len; i++) {
                if (prerequisites[i][1]==top) {
                    counters[prerequisites[i][0]]--;
                    if (counters[prerequisites[i][0]]==0) {
                        numNoPre++;
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return numCourses == numNoPre;
    }
}
