/**
 * Find the Celebrity:
 * Use the minimum time of known method knows(int a, int b)
 */
public class SolutionCCLXXVII {
    public int findCelebrity(int n) {
        if (n<=1) return -1;
        int left = 0;
        int right = n-1;
        while (left < right) {
            if (knows(left, right)) left++;
            else right--;
        }
        int celebrity = right;
        for (int i = 0; i < n; i++) {
            // check if the celebrity really the result.
            if (i!=right && (!knows(i, celebrity) || knows(celebrity, i))) return -1;
        }
        return celebrity;
    }
    @Deprecated
    public boolean knows(int a, int b) {
        return a > b;
    }
}
