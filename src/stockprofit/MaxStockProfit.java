package stockprofit;

/**
 * Finds what the best profit is, as well as when the best day to buy and best day to sell is,
 * given an array of numbers representing stock prices.
 */
public class MaxStockProfit {

  public static void main(String[] args) {
    // array representing stock prices over a period of time
    int[] list = {14, 4, 2, 17, 3, 20};

    int curBuyDate = 0;
    int curSale;
    int bestBuyDate = 0;
    int bestSellDate = 0;
    int bestSale = 0;

    // for loop that will iterate through the array once, hence linear time
    for (int i = 0; i < list.length; i++) {
      // stores the current sale price
      curSale = list[i] - list[curBuyDate];
      // if it is higher than our best sale, update best sale
      if(curSale > bestSale) {
        // updates our buy date to be the same as our current buy date
        bestBuyDate = curBuyDate;
        bestSale = curSale;
        // updates our sell date
        bestSellDate = i;
      }
      // if our current sale is ever negative, we can update our current buy date because we have
      // now found a lower price to buy at
      else if (curSale < 0) {
        curBuyDate = i;
      }
    }

    // prints results
    System.out.println("Start: " + bestBuyDate);
    System.out.println("End: " + bestSellDate);
    System.out.println("Total: " + bestSale);
  }

}
