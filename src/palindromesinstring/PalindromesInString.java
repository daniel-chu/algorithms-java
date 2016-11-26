package palindromesinstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Gets a list of all palindromes in a given string in linear time.
 */
public class PalindromesInString {

  public static void main(String[] args) {

    // the word we are using - INPUT STRING HERE
    String word = "adasaasadadasaas";

    // gets answer
    long startTime = System.nanoTime();
    List<String> result = findAllPalindromes(word);
    long endTime = System.nanoTime();
    long totalTime = endTime - startTime;

    // prints result
    for (int i = 0; i < result.size(); i++) {
      if (i < result.size() - 1) {
        System.out.print(result.get(i) + ", ");
      } else {
        System.out.println(result.get(i));
      }
    }

    // prints runtime
    System.out.println("RUNTIME: " + totalTime);
  }

  /**
   * Finds all palindromes in the word.
   *
   * @param word word we are getting the palindromes from
   * @return the list of all palindromes
   */
  public static List<String> findAllPalindromes(String word) {
    List<String> result = new ArrayList<String>();
    // FIND ALL ODD LENGTH PALINDROMES
    for (int i = 0; i < word.length(); i++) {
      for (int j = i, k = i; j >= 0 && k < word.length(); j--, k++) {
        if (word.charAt(j) == word.charAt(k)) {
          result.add(word.substring(j, k + 1));
        } else {
          break;
        }
      }
    }
    // FIND ALL EVEN LENGTH PALINDROMES
    for (int i = 0; i < word.length(); i++) {
      for (int j = i, k = i + 1; j >= 0 && k < word.length(); j--, k++) {
        if (word.charAt(j) == word.charAt(k)) {
          result.add(word.substring(j, k + 1));
        } else {
          break;
        }
      }
    }
    return result;
  }
}
