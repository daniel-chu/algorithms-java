package knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * Solver for Knapsack Problem using dynamic programming - tabulation.
 */
public class KnapsackSolverTabulation {

  /**
   * The list of items we are picking from.
   */
  private List<Item> allItems;

  /**
   * The max weight we are able to carry.
   */
  private int capacity;

  /**
   * We store the previous results in this object. X is the weight, Y is the item
   */
  private int[][] cache;


  /**
   * Constructor for a KnapsackSolver
   *
   * @param allItems the list of items we must pick from
   * @param capacity how much total weight we are able to carry
   */
  public KnapsackSolverTabulation(List<Item> allItems, int capacity) {
    if (capacity == 0 || allItems.isEmpty()) {
      throw new IllegalArgumentException("Capacity must be greater than 0 and list of items " +
              "cannot be empty");
    }
    this.allItems = allItems;
    this.capacity = capacity;

    // creates the cache of results, and sets all values to -1, which indicates we have not
    // solved for that particular cell yet
    this.cache = new int[capacity + 1][allItems.size() + 1];
    for (int itemNum = 0; itemNum <= this.allItems.size(); itemNum++) {
      for (int weight = 0; weight <= this.capacity; weight++) {
        this.cache[weight][itemNum] = -1;
      }
    }
  }

  /**
   * Returns the total max value we are able to get.
   *
   * @return the max value
   */
  public int solveMaxPrice() {
    // initializes first cell to a value of 0
    this.cache[0][0] = 0;
    // uses the helper to solve all subproblems in the cache
    for (int itemNum = 0; itemNum <= this.allItems.size(); itemNum++) {
      for (int weight = 0; weight <= this.capacity; weight++) {
        this.cache[weight][itemNum] = this.solveHelper(weight, itemNum);
      }
    }
    // returns the last cell of the cache, which is our final answer
    return this.cache[this.capacity][this.allItems.size()];
  }

  /**
   * Gets the result that should be at the cell with given weight num and item num in the cache.
   *
   * @param curWeightNum the current weight we are allowing
   * @param curItemNum   what item we are currently allowed to use up to
   * @return the value in the cache given this weight and item #
   */
  private int solveHelper(int curWeightNum, int curItemNum) {
    // if cell is not -1, that means it has already been solved. Return the value.
    if (this.cache[curWeightNum][curItemNum] != -1) {
      return this.cache[curWeightNum][curItemNum];
    }
    // if the item number is 0, we cannot choose any items so the value must be 0
    if (curItemNum == 0) {
      return 0;
    }
    // checks the cache - if the item is light enough to be carried, it will compare two
    // different cases.
    // - CASE 1: item's weight + the result of the subproblem using the weight - item's weight,
    // and previous items (itemNum - 1).
    // - CASE 2: the subproblem using the weight, and previous items (itemNum - 1).
    Item item = this.allItems.get(curItemNum - 1);
    if (item.getWeight() <= curWeightNum) {
      return Math.max(item.getPrice() + solveHelper(curWeightNum - item.getWeight(),
              curItemNum - 1), solveHelper(curWeightNum, curItemNum - 1));
    }
    // If the item is too heavy, it just uses the subproblem of weight and previous items answer.
    else {
      return solveHelper(curWeightNum, curItemNum - 1);
    }
  }

  /**
   * Returns the items that make up that max value.
   *
   * @return a list of items
   */
  public List<Item> solveWhichItems() {
    // if the result cell in the cache is -1, that means this hasn't been solved yet. Solves it.
    if (this.cache[this.capacity][this.allItems.size()] == -1) {
      solveMaxPrice();
    }
    // creates the result array list
    List<Item> result = new ArrayList<Item>();
    int curWeight = this.capacity;
    int curItem = this.allItems.size();
    // while there are still items left to check, run this loop
    while (curItem > 0) {
      // if the value at this cell in the cache is the same as the value in the cell directly
      // underneath (same weight, previous items), then that means this current item was not one
      // of the one's selected. If it is not equal, that means this item was selected. Adds it to
      // the list, and subtracts the weight and uses the previous items, and continues.
      if (this.cache[curWeight][curItem] != this.cache[curWeight][curItem - 1]) {
        Item item = this.allItems.get(curItem - 1);
        result.add(item);
        curWeight = curWeight - item.getWeight();
        curItem = curItem - 1;
      }
      // if the item was not used, checks the previous items, same weight remaining.
      else {
        curItem = curItem - 1;
      }
    }
    return result;
  }

  /**
   * Gets the cache of results.
   *
   * @return the 2d array of results
   */
  public int[][] getCache() {
    return this.cache;
  }

  /**
   * Gets the list of items we are picking from.
   *
   * @return list of items
   */
  public List<Item> getAllItems() {
    return new ArrayList<Item>(this.allItems);
  }

  /**
   * Gets the weight we can hold (the capacity)
   *
   * @return the capacity
   */
  public int getCapacity() {
    return this.capacity;
  }

}
