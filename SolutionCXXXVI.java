/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SolutionCXXXVI {
    public int singleNumber(int[] nums) {
        // reference: http://www.tutorialspoint.com/java/java_bitwise_operators_examples.htm
        int res = 0;
        for (int num: nums) res ^= num;
        return res;
    }
}
