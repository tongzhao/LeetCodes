/**
 *  H-Index II:
 *  What if the citations array is sorted in ascending order?
 *  Could you optimize your algorithm?
 */
public class SolutionCCLXXV {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n-1;
        int last = 0;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (n-mid == citations[mid]) return n-mid;
            if (citations[mid] > n-mid) {
                right = mid-1;
                last = n-mid; // might have larger value
            }
            else {
                left = mid+1;
            }
        }
        return last;
    }
}
