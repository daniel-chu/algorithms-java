package sequencealignment;

/**
 * Main runner for sequence alignment problem.
 */
public class SequenceAlignmentRunner {

  public static void main(String[] args) {
    // PUT STRINGS HERE
    String s1 = "pain";
    String s2 = "pane";
    // put in costs here
    int gapCost = 1;
    int mismatchCost = 2;

    // initializes the solver
    SequenceAlignmentSolver solver = new SequenceAlignmentSolver(s1, s2, gapCost, mismatchCost);

    // finds the min edit distance/cost
    int minEditCost = solver.solveEditDistance();
    System.out.println("Minimum edit cost: " + minEditCost + "\n\n");

    // prints out the cache
    System.out.println("CACHE OF RESULTS: \n");
    for (int s2pos = s2.length(); s2pos >= 0; s2pos--) {
      for (int s1pos = 0; s1pos < s1.length() + 1; s1pos++) {
        System.out.print(solver.getCache()[s1pos][s2pos] + "      ");
      }
      System.out.println();
      System.out.println();
      System.out.println();
    }
  }
}
