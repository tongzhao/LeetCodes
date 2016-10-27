/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit.
 You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]
 */
public class SolutionCCCIX {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int noOp = Integer.MIN_VALUE;
        int coolDown = 0;
        int sell = 0;
        for (int price: prices) {
            int buy_prev = buy;
            buy = coolDown - price;
            coolDown = Math.max(coolDown, sell);
            noOp = Math.max(noOp, buy_prev);
            sell = noOp + price;
        }
        return Math.max(coolDown, sell);
    }
}
