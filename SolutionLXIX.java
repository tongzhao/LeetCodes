/**
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 */
public class SolutionLXIX {
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1;
        int right = x;
        int res = 1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (mid * mid == x) return mid;
            else if (mid > x/mid) right = mid ;
            else {
                res = mid;
                left = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int test = 10;
        System.out.print("SQRT OF "+test+": "+mySqrt(test));
    }
}
