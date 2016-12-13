package sequencealignment;

/**
 * Class to solve a sequence alignment problem using dynamic programming.
 */
public class SequenceAlignmentSolver {

  /**
   * First string.
   */
  String s1;

  /**
   * Second string.
   */
  String s2;

  /**
   * Cache of subproblem's answers.
   */
  int cache[][];

  /**
   * The cost of leaving a gap
   */
  int gapPenalty;

  /**
   * The cost of a mismatched character.
   */
  int mismatchPenalty;

  /**
   * Constructor for a Sequence Alignment Solver.
   *
   * @param s1              string one
   * @param s2              string two
   * @param gapPenalty      the penalty of leaving a gap
   * @param mismatchPenalty the penalty of mismatching a character
   */
  public SequenceAlignmentSolver(String s1, String s2, int gapPenalty, int mismatchPenalty) {
    if (s1.isEmpty() || s2.isEmpty()) {
      throw new IllegalArgumentException("Strings cannot be empty.");
    }
    this.s1 = s1;
    this.s2 = s2;
    this.gapPenalty = gapPenalty;
    this.mismatchPenalty = mismatchPenalty;
    this.cache = new int[s1.length() + 1][s2.length() + 1];
    for (int i = 0; i < s2.length() + 1; i++) {
      for (int j = 0; j < s1.length() + 1; j++) {
        this.cache[j][i] = -1;
      }
    }
  }

  /**
   * Solves the problem by filling the cache and giving the lowest edit distance.
   */
  public int solveEditDistance() {
    for (int jy = 0; jy < s2.length() + 1; jy++) {
      for (int xi = 0; xi < s1.length() + 1; xi++) {
        cache[xi][jy] = this.editDistanceHelper(xi, jy);
      }
    }
    return cache[s1.length()][s2.length()];
  }

  public int editDistanceHelper(int x, int y) {
    // if this subproblem has already been solved, return the answer
    if (cache[x][y] != -1) {
      return cache[x][y];
    }
    // if we are at the 0 position in the x string (string one), the edit distance will be the #
    // of gaps equal to the position in the y (string two) string.
    if (x == 0) {
      return y * gapPenalty;
    }
    // if we are at the 0 position in the y string (string two), the edit distance will be the #
    // of gaps equal to the position in the x (string one) string.
    if (y == 0) {
      return x * gapPenalty;
    }

    // Otherwise, we must solve by finding the min between three cases.
    // - The first case is if we were to leave a gap in x and leave that character unmatched (we
    //   move on with x by going back a character, stay at the same character with y
    // - The second case is if we were to leave a gap in y and leave that character unmatched. We
    //   move on with y by going back a character, and stay at the same character in x
    // - The third case is if we were to match the character. We move back a character in both
    // strings, and then add the cost of matching those (if they are the same, 0, otherwise
    // mismatchPenalty)

    // finds the smaller of the gap cases
    int minIfGap = Math.min(gapPenalty + this.editDistanceHelper(x - 1, y), gapPenalty + this
            .editDistanceHelper(x, y - 1));
    // returns the minimum between matching and leaving a gap cases, which is the answer to the
    // subproblem.
    return Math.min(minIfGap, cost(s1.charAt(x - 1), s2.charAt(y - 1)) + this
            .editDistanceHelper(x - 1, y - 1));
  }

  /**
   * Gives the cost of a matching between two characters. 0 if they are the same, mismatchPenalty
   * otherwise.
   */
  public int cost(char x, char y) {
    // if they are the same character, 0 penalty
    if (x == y) {
      return 0;
    } else {
      return mismatchPenalty;
    }
  }

}
