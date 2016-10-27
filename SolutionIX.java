public class SolutionIX {
    public boolean isPalindrome(int x) {
        int temp = Math.abs(x);
        int n = temp % 10;
        while (temp / 10 != 0) {
            temp = temp / 10;
            n = n * 10 + temp % 10;
        }
        if (n == x) {
            return true;
        }
        return false;
    }
}
