import java.util.ArrayList;
import java.util.List;

public class SolutionLX {
    public static String getPermutation(int n, int k) {
        String res = "";
        if (k>fact(n)) return res;
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k--; // for order use
        while (n > 1) {
            int val = k / fact(n-1);
            res += (char)(nums.get(val) + '0');
            nums.remove(val);
            k = k % fact(n-1);
            n--;
        }
        res += (char)(nums.get(0) + '0');
        return res;
    }
    public static int fact(int n) {
        if (n<=0) return 1;
        return n * fact(n-1);
    }

    public static void main(String[] args) {
        System.out.println("3, 4: "+ getPermutation(3,4));
        System.out.println("4, 5: " + getPermutation(4, 5));
    }
}
