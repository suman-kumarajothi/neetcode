package problem.solving.neetcode150.problems.slidingwindow.besttimetobuyandsellstocks;

import java.util.Arrays;
import java.util.Collections;

public class BestTimeToBuyAndSellStocks
{
    public static void main(String[] args)
    {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(new BestTimeToBuyAndSellStocks().maxProfit(prices));
    }

    public int maxProfit(final int[] prices)
    {
        int buyStock = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++)
        {
            if(prices[i] > buyStock)
            {
                int earnings = prices[i] - buyStock;
                maxProfit = Math.max(earnings, maxProfit);
            }
            else
            {
                buyStock = prices[i];
            }
        }

        return maxProfit;
    }
}
