/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class SolutionCCXXXI {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        return isPowerOfTwo(n/2) && n%2==0;
    }
}
