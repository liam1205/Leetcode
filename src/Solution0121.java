public class Solution0121 {

    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

[7,5,4,3,6,1]

[2,3,5,4,1,2,3,4,5]

2 - 1
3 - 1
4 - 1
5 - 1 = 4
2 - 1

3 - 2
4 - 2
5 - 2
2 - 2

4 - 3
5 - 3
2 - 3

5 - 4
2 - 4

2 - 5

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
     */
    public int maxProfit(int[] prices) {

        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;

        /*
        integer profit = 0
        int min = prices[0]
        for durch array beginnend bei i = 1
            if prices[i] < min
                min = prices[i]
            else
                profit = Math.max(profit, prices[i] - min)
        return profit
         */

        // [2,5,1,3]
        // profit = 0, min = 2
        // 1: profit = (0) oder (5-2) -> profit = 3; min = 2
        // 2: profit = (3) oder (1-2) -> profit = 3; min = 1
        // 3: profit = (3) oder (3-2) -> profit = 3; min = 1

    }
}
