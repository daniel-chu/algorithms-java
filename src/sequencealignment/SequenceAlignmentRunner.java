package sequencealignment;

/**
 * Main runner for sequence alignment problem.
 */
public class SequenceAlignmentRunner {

  public static void main(String[] args) {
    // PUT STRINGS HERE
    String s1 = "principle";
    String s2 = "prinncipal";
    // put in costs here
    int gapCost = 100;
    int mismatchCost = 1;

    // initializes the solver
    SequenceAlignmentSolver solver = new SequenceAlignmentSolver(s1, s2, gapCost, mismatchCost);

    // finds the min edit distance/cost
    int minEditCost = solver.solveEditDistance();
    System.out.println("Minimum edit cost: " + minEditCost);
  }
}
