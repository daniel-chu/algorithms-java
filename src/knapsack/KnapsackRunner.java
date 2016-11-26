package knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * Main runner class to use it and see run times.
 */
public class KnapsackRunner {

  public static void main(String[] args) {

    // creating items - CREATE ITEMS HERE
    Item item1 = new Item("A", 6, 50);
    Item item2 = new Item("B", 2, 70);
    Item item3 = new Item("C", 3, 40);
    Item item4 = new Item("D", 6, 110);

    // creates list of items - ADD ALL ITEMS INTO LIST HERE
    List<Item> itemList = new ArrayList<Item>();
    itemList.add(item1);
    itemList.add(item2);
    itemList.add(item3);
    itemList.add(item4);

    // CAPACITY - SET CAPACITY HERE
    int capacity = 6;

    // Creates the tabulation solver and the memoization solver
    KnapsackSolverTabulation solverT = new KnapsackSolverTabulation(itemList, capacity);
    KnapsackSolverMemoization solverM = new KnapsackSolverMemoization(itemList, capacity);

    // ========= TABULATION SECTION ==========

    // prints max value we can get, as well as gets how fast it runs
    System.out.println("=============== TABULATION METHOD: ===============");
    long startTimeT = System.nanoTime();
    System.out.println("\nMAX VALUE: " + solverT.solveMaxPrice());
    long endTimeT = System.nanoTime();
    long totalTimeT = endTimeT - startTimeT;

    // prints list of which items to choose
    String listBestItems = "";
    for (Item i : solverT.solveWhichItems()) {
      listBestItems += i.toString() + "\n";
    }
    System.out.println("\nLIST OF ITEMS: \n" + listBestItems);

    // prints the cache of results
    System.out.println("CACHE OF RESULTS: \n");
    for (int item = solverT.getAllItems().size(); item >= 0; item--) {
      for (int weight = 0; weight <= solverT.getCapacity(); weight++) {
        System.out.print(solverT.getCache()[weight][item] + "      ");
      }
      System.out.println();
      System.out.println();
      System.out.println();
    }
    // ==========================================

    // ============ MEMOIZATION SECTION ==============

    // prints max value we can get, as well as gets how fast it runs
    System.out.println("=============== MEMOIZATION METHOD: ===============");
    long startTimeM = System.nanoTime();
    System.out.println("\nMAX VALUE: " + solverM.solveMaxPrice());
    long endTimeM = System.nanoTime();
    long totalTimeM = endTimeM - startTimeM;

    // prints list of which items to choose
    listBestItems = "";
    for (Item i : solverM.solveWhichItems()) {
      listBestItems += i.toString() + "\n";
    }
    System.out.println("\nLIST OF ITEMS: \n" + listBestItems);

    // prints the cache of results
    System.out.println("CACHE OF RESULTS: \n");
    for (int item = solverM.getAllItems().size(); item >= 0; item--) {
      for (int weight = 0; weight <= solverM.getCapacity(); weight++) {
        System.out.print(solverM.getCache()[weight][item] + "      ");
      }
      System.out.println();
      System.out.println();
      System.out.println();
    }
    // =======================================

    // PRINTS RUN TIMES FOR EACH
    System.out.println("=============== RUN TIMES ===============");
    System.out.println("Tabulation time: " + totalTimeT);
    System.out.println("Memoization time: " + totalTimeM);
  }
}
