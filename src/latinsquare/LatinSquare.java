package latinsquare;

/**
 * Represents a latin square.
 */
public class LatinSquare {
  int[][] grid;

  /**
   * Constructor for a LatinSquare.
   *
   * @param grid the 2D array representing the grid
   */
  public LatinSquare(int[][] grid) {
    this.grid = grid;
  }

  /**
   * Solves the square.
   *
   * @param current the cell you start on (0, 0)
   * @return a boolean, if it is solvable or not
   */
  public boolean solveSquare(Cell current) {
    if (current == null) {
      return true;
    }
    if (grid[current.row][current.col] != 0) {
      return this.solveSquare(this.nextCell(current));
    }
    for (int i = 1; i <= grid.length; i++) {
      if (this.isValidValue(current, i)) {
        grid[current.row][current.col] = i;
        boolean solved = this.solveSquare(this.nextCell(current));
        if (solved) {
          return true;
        } else {
          grid[current.row][current.col] = 0;
        }
      }
    }
    return false;
  }

  /**
   * Checks if the given value is allowed to be in that location.
   *
   * @param cell  the cell you are in
   * @param value the value you want to put in that cell
   * @return if that value is allowed
   */
  private boolean isValidValue(Cell cell, int value) {
    for (int col = 0; col < grid[cell.row].length; col++) {
      if (grid[cell.row][col] == value)
        return false;
    }
    for (int row = 0; row < grid.length; row++) {
      if (grid[row][cell.col] == value)
        return false;
    }
    return true;
  }

  /**
   * Gets the next cell you are processing
   *
   * @param current your current cell
   * @return the next cell
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
   * Gives the string representing the latin square.
   *
   * @return the string representing the latin square
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