/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 If you were only permitted to complete at most one transaction
 (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class SolutionCXXI {
    public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int min = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for (int i=0; i<prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i]-min);
        }
        return res;
    }
}
