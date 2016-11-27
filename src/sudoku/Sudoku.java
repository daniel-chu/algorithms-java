package sudoku;

/**
 * Represents a sudoku puzzle.
 */
public class Sudoku {
  /**
   * Represents the grid
   */
  int[][] grid;

  /**
   * Constructor to create a 9x9 sudoku puzzle.
   *
   * @param grid the grid we are using
   * @throws IllegalArgumentException if the given grid is not 9x9
   */
  public Sudoku(int[][] grid) {
    if (grid.length < 9 || grid[0].length < 9) {
      throw new IllegalArgumentException("Sudoku must be 9x9.");
    }
    this.grid = grid;
  }

  /**
   * Solves the sudoku puzzle. If this function is called without parameters, it will call the
   * overloaded function with a default starting cell of 0, 0.
   *
   * @return If this is solvable or not.
   */
  public boolean solveSudoku() {
    return this.solveSudoku(new Cell(0, 0));
  }

  /**
   * Solves the sudoku puzzle by filling in the grid. Returns if this puzzle is solvable or not.
   *
   * @param current the cell you start on
   * @return if the puzzle is solvable or not
   */
  public boolean solveSudoku(Cell current) {
    // if our current cell is null, we have solved the puzzle (null only returned after we have
    // left the grid)
    if (current == null) {
      return true;
    }
    // if the grid has a non-zero number in it, then it has already been solved in this branch
    // and we should move on
    if (this.grid[current.row][current.col] != 0) {
      return this.solveSudoku(this.nextCell(current));
    }
    // tries all possible options (1-9)
    for (int i = 1; i <= 9; i++) {
      // checks if this number will work in this spot
      if (this.validInput(current, i)) {
        // sets this spot to the number and continues
        this.grid[current.row][current.col] = i;
        boolean solved = this.solveSudoku(this.nextCell(current));
        // if it has been solved, we can return.
        if (solved) {
          return true;
        }
        // if it was not solvable with this input, reset the cell value to 0, and continue looping
        else {
          this.grid[current.row][current.col] = 0;
        }
      }
    }
    // if we have exhausted all possible options (1-9), this branch is unsolvable and we return
    // false
    return false;
  }

  /**
   * Checks if the given number is a valid input in the current cell based on Sudoku rules.
   *
   * @param current the cell we are currently in
   * @param num     the number we are trying to put at this cell's location
   * @return if it is valid or not
   */
  private boolean validInput(Cell current, int num) {
    // checks the row and column
    for (int i = 0; i < 9; i++) {
      if (this.grid[i][current.col] == num) {
        return false;
      }
      if (this.grid[current.row][i] == num) {
        return false;
      }
    }
    // checks the sub grid (3x3 grid) the number will be in
    int subGridRow = current.row / 3;
    int subGridCol = current.col / 3;
    for (int i = subGridRow * 3; i < subGridRow * 3 + 3; i++) {
      for (int j = subGridCol * 3; j < subGridCol * 3 + 3; j++) {
        if (this.grid[i][j] == num) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Gets the next cell using the current given one. If our current cell is the last one, return
   * null.
   *
   * @param current the cell we are currently on.
   * @return the next cell. Null if our current cell is the last one.
   */
  private Cell nextCell(Cell current) {
    int row = current.row;
    int col = current.col;
    col++;
    if (col == grid[row].length) {
      col = 0;
      row++;
    }
    if (row == grid.length) {
      return null;
    }
    return new Cell(row, col);
  }

  /**
   * Gives the string representing the sudoku puzzle.
   *
   * @return the string representing the sudoku puzzle
   */
  public String getResult() {
    String result = "";
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        result += grid[i][j] + " ";
      }
      result += "\n";
    }
    return result;
  }
}