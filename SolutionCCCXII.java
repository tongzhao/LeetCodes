/**
 * Burst Balloons
 *
 * Given n balloons, indexed from 0 to n-1.
 * Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons.
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

 Find the maximum coins you can collect by bursting the balloons wisely.

 Note:
 (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

 Example:

 Given [3, 1, 5, 8]

 Return 167

 nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class SolutionCCCXII {
    public int maxCoins(int[] nums) {
        // Divide and Conquer
        int[] numbers = new int[nums.length+2];
        for (int i = 0; i <= nums.length+1; i++) {
            if (i==0 || i==nums.length+1) numbers[i]=1;
            else numbers[i] = nums[i-1];
        }
        int[][] memo = new int[numbers.length][numbers.length];
        return burst(memo, numbers, 0, numbers.length-1);
    }
    public int burst(int[][] memo, int[] numbers, int left, int right) {
        if (left+1==right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int res = 0;
        for (int i = left+1; i < right; i++) {
            res = Math.max(res, numbers[left]*numbers[i]*numbers[right] +
                                burst(memo, numbers, left, i) +
                                burst(memo, numbers, i, right));
        }
        memo[left][right] = res;
        return res;
    }
}
