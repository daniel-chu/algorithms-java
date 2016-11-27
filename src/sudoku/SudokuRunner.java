package sudoku;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the main runner class. Allows user to input a standard 9x9 sudoku grid number by
 * number. The inputs must follow a valid sudoku layout and be solvable (for this to work
 * correctly). Enter 0 for a blank square. Command + D when done entering.
 *
 * Sample Sudoku below:
 * 5 3 0 0 7 0 0 0 0
 * 6 0 0 1 9 5 0 0 0
 * 0 9 8 0 0 0 0 6 0
 * 8 0 0 0 6 0 0 0 3
 * 4 0 0 8 0 3 0 0 1
 * 7 0 0 0 2 0 0 0 6
 * 0 6 0 0 0 0 2 8 0
 * 0 0 0 4 1 9 0 0 5
 * 0 0 0 0 8 0 0 7 9
 */
public class SudokuRunner {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    // creates the 9 x 9 and fills it in
    int[][] grid = new int[9][9];

    // adds all inputs into the 2D array
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        grid[i][j] = scanner.nextInt();
      }
    }

    // intializes the sudoku puzzle using the grid
    Sudoku sudoku = new Sudoku(grid);

    // solves the sudoku puzzle
    if (sudoku.solveSudoku()) {
      System.out.println("\nSolved Sudoku: ");
      System.out.print(sudoku.getResult());
    } else {
      System.out.println("No Solution");
    }
  }
}
