package latinsquare;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the main runner class. Allows user to input a latin square number by number. The
 * number of inputs must be a square number to be a valid latin square (and for this to work
 * correctly).
 */
public class LatinSquareRunner {

    public static void main(String[] args) {

      // creates the arraylist of inputs
      ArrayList<Integer> inputList = new ArrayList<Integer>();
      Scanner scanner = new Scanner(System.in);
      while (scanner.hasNextInt()) {
        inputList.add(scanner.nextInt());
      }

      // gets the size of the 2D array
      int n = (int) (Math.sqrt(inputList.size()));
      int grid[][] = new int[n][n];

      // adds all inputs into the 2D array
      for (int i = 0; i < inputList.size(); i++) {
        grid[i / n][i % n] = inputList.get(i);
      }

      // intializes the LatinSquare using the grid
      LatinSquare square = new LatinSquare(grid);

      // solves the LatinSquare
      if (square.solveSquare(new Cell(0, 0))) {
        System.out.print(square.getResult());
      } else {
        System.out.println("No Solution");
      }
    }
}
