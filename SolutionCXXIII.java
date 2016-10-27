/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class SolutionCXXIII {
    public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int length = prices.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int leftStart = prices[0];
        int rightStart = prices[length-1];
        for (int i = 1; i < length; i++) {
            if (prices[i] < leftStart) leftStart = prices[i];
            left[i] = (prices[i]-leftStart) > left[i-1] ? (prices[i]-leftStart) : left[i-1];
        }
        for (int j = length-2; j >= 0; j--) {
            if (prices[j] > rightStart) rightStart = prices[j];
            right[j] = (rightStart - prices[j]) > right[j+1] ? (rightStart - prices[j]) : right[j+1];
        }
        int total = 0;
        for (int i = 0; i < length; i++) {
            total = (left[i] + right[i]) > total ? (left[i] + right[i]) : total;
        }
        return total;
    }
}
