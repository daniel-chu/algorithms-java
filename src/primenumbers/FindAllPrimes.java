package primenumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds all primes under a certain number
 */
public class FindAllPrimes {
  public static void main(String[] args) {
    // Number we are finding primes under
    // 20,000,000 takes around 17 sec for brute force, 3.5 sec for the algorithm
    int primesUnderThisNumber = 20000000;

    // performs the algorithmic method and stores runtime
    long startTime = System.nanoTime();
    List<Integer> primes = findAllPrimes(primesUnderThisNumber);
    long endTime = System.nanoTime();
    // performs the brute force method and stores runtime
    long startTimeBrute = System.nanoTime();
    List<Integer> primesBrute = findAllPrimesBruteForce(primesUnderThisNumber);
    long endTimeBrute = System.nanoTime();
    // prints list out
    for (int i : primes) {
      System.out.println(i);
    }
    // prints run times for comparison and checks that both methods return the same list
    System.out.println("Algorithm runtime (ms): " + (endTime - startTime) / 1000000);
    System.out.println("Brute force runtime (ms): " + (endTimeBrute - startTimeBrute)
            / 1000000);
    System.out.println("Same Output: " + primes.equals(primesBrute));
  }

  /**
   * Finds all primes under the given number through brute force.
   *
   * @param n the upper limit of primes we are finding
   * @return a list of all primes under the given number
   */
  public static List<Integer> findAllPrimesBruteForce(int n) {
    List<Integer> result = new ArrayList<Integer>();
    // loops through all numbers from 2 to n, if the number is prime, add it to the list
    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) {
        result.add(i);
      }
    }
    return result;
  }

  /**
   * Tells us if the given number is prime.
   *
   * @param n the number we are checking
   * @return if the given number is prime or not
   */
  public static boolean isPrime(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Finds all primes that are less than or equal to the given number.
   *
   * @param n the upper limit of primes we are finding
   * @return a list of all primes under the given number
   */
  public static List<Integer> findAllPrimes(int n) {
    List<Integer> result = new ArrayList<Integer>();
    int[] nums = new int[n + 1];
    // sets all cells in the array to their index
    for (int i = 0; i < nums.length; i++) {
      nums[i] = i;
    }
    // loops through every number from 2 to n
    for (int i = 2; i < n; i++) {
      // starting from the 2nd multiple of i, delete (set to -1) cells that are multiples of i
      for (int j = 2 * i; j <= n; j = j + i) {
        nums[j] = -1;
      }
    }
    // add every non deleted number (not equal to -1) into the result list
    for (int i = 2; i < nums.length; i++) {
      if (nums[i] != -1) {
        result.add(nums[i]);
      }
    }
    return result;
  }
}
