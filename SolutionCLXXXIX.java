/**
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class SolutionCLXXXIX {
    // or reverse partials then reverse total
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if ( n == 0 || k <= 0) return;
        int[] tmp = new int[n];
        for(int i=0; i<n; i++) {
            tmp[(i+k) % n] = nums[i];
        }
        for(int i=0; i<n; i++) {
            nums[i] = tmp[i];
        }
    }
}
