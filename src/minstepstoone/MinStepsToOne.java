package minstepstoone;

/**
 * This solves the problem: Find the minimum number of steps to reach 1, starting from a given
 * number. Available steps include n - 1, n / 2, and n / 3.
 */
public class MinStepsToOne {

  public static int getMinStepsToOne(int n) {
    int[] cache = new int[n+1];
    for(int i = 0; i < cache.length; i++) {
      cache[i] = -1;
    }
    return solve(n, cache);
  }

  private static int solve(int n, int[] cache) {
    // base case
    if(n == 1) {
      return 0;
    }
    // if solved already, return cached answer
    if(cache[n] != -1) {
      return cache[n];
    }

    // -1 step
    int answer = 1 + solve(n - 1, cache);

    if(n % 2 == 0) {
      int temp = 1 + solve(n / 2, cache);
      answer = temp < answer ? temp : answer;
    }

    if(n % 3 == 0) {
      int temp = 1 + solve(n / 3, cache);
      answer = temp < answer ? temp : answer;
    }

    cache[n] = answer;
    return answer;
  }
}
