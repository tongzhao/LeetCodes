/**
 * 367. Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Returns: True
 Example 2:

 Input: 14
 Returns: False
 */
public class SolutionCCCLXVII {
    public static boolean isPerfectSquare(int num) {
        if (num==1) return true;
        int low = 1;
        int high = num;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == num) return true;
            else if (mid * mid > num) high = mid-1;
            else low = mid;
        }
        return false;
    }
    public static void main(String[] args) {
        if (isPerfectSquare(16)) System.out.println("Correct");
        if (!isPerfectSquare(14)) System.out.print("Correct");
    }
}
