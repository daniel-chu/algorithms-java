package latinsquare;

/**
 * Represents a cell, stores the x and y locations.
 */
public class Cell {
  int row;
  int col;

  /**
   * Constructor for a cell.
   *
   * @param row the row the cell is in
   * @param col the column the cell is in
   */
  public Cell(int row, int col) {
    this.row = row;
    this.col = col;
  }
}
