/**
 * L2. Best Time to Buy and Sell Stock
 * Find maximum profit by buying and selling once (buy before sell)
 */
public class L2BestTimeToBuyAndSellStock {
    
    /**
     * Calculate maximum profit from one buy-sell transaction
     * @param prices array where prices[i] is the price on day i
     * @return maximum profit possible, or 0 if no profit available
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];  // Track lowest price seen so far
        
        // Walk through the array once, left to right
        for (int i = 1; i < prices.length; i++) {
            // Calculate profit if we sell today
            int profit = prices[i] - minPrice;
            
            // Keep track of the largest profit seen
            maxProfit = Math.max(maxProfit, profit);
            
            // Update minimum price if current price is lower
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return maxProfit;
    }
    
    public static void main(String[] args) {
        // Test case 1: Normal case with profit opportunity
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int result1 = maxProfit(prices1);
        System.out.println("Test 1: prices = [7, 1, 5, 3, 6, 4]");
        System.out.println("Maximum Profit: " + result1);
        System.out.println("Explanation: Buy on day 2 (price=1), sell on day 5 (price=6), profit = 6 - 1 = 5");
        
        System.out.println();
        
        // Test case 2: Descending prices (no profit)
        int[] prices2 = {7, 6, 4, 3, 1};
        int result2 = maxProfit(prices2);
        System.out.println("Test 2: prices = [7, 6, 4, 3, 1]");
        System.out.println("Maximum Profit: " + result2);
        System.out.println("Explanation: Prices only go down, so maximum profit is 0");
        
        System.out.println();
        
        // Test case 3: Single profitable point
        int[] prices3 = {2, 4, 1, 7, 5, 11};
        int result3 = maxProfit(prices3);
        System.out.println("Test 3: prices = [2, 4, 1, 7, 5, 11]");
        System.out.println("Maximum Profit: " + result3);
        System.out.println("Explanation: Buy on day 3 (price=1), sell on day 6 (price=11), profit = 11 - 1 = 10");
    }
}
