public class SolutionVII {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        long y = 0;
        x = Math.abs(x);
        while (x > 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        y = y * sign;
        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) return 0;
        return (int)y;
    }
}
