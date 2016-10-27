import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode: Factor Combinations
 Numbers can be regarded as product of its factors. For example,
 8 = 2 x 2 x 2;
 = 2 x 4.
 Write a function that takes an integer n and return all possible combinations of its factors.
 Note:
 Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
 You may assume that n is always positive.
 Factors should be greater than 1 and less than n.
 Examples:
 input: 1
 output:
 []
 input: 37
 output:
 []
 input: 12
 output:
 [
 [2, 6],
 [2, 2, 3],
 [3, 4]
 ]
 input: 32
 output:
 [
 [2, 16],
 [2, 2, 8],
 [2, 2, 2, 4],
 [2, 2, 2, 2, 2],
 [2, 4, 4],
 [4, 8]
 ]
 */
public class SolutionCCLIV {
    public static List<List<Integer>> getFactors(int n) {
        // RECURSIVE, first smaller factor, then recursive on the bigger one
        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        getFactors(n, 2, tmp, res);
        return res;
    }
    public static void getFactors(int n, int start, List<Integer> tmp, List<List<Integer>> res) {
        if (n <= 1) {
            if (tmp.size() > 1) {
                List<Integer> temp = new ArrayList<Integer>(tmp);
                res.add(temp);
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) { // start is the factor of n
                tmp.add(i);
                getFactors(n/i, i, tmp, res);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> res = getFactors(32);
        for (List<Integer> list: res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
