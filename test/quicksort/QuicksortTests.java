package quicksort;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by danielchu on 10/13/17.
 */
public class QuicksortTests {

  @Test
  public void testCheckSorted() {
    int[] sortedArr = {0, 1, 6, 6, 13, 29, 34, 598};
    int[] unsortedArr = {0, 6, 1, 9, 13, 29, 34, 598};
    int[] emptyArr = {};

    Assert.assertTrue(checkSorted(sortedArr));
    Assert.assertFalse(checkSorted(unsortedArr));
    Assert.assertTrue(checkSorted(emptyArr));
  }

  @Test
  public void testQuicksort() {
    int[] arr;
    for(int i = 0; i <= 1000; i+=50) {
      arr = genIntArrayOfSize(i);
      Quicksort.sort(arr);
      Assert.assertTrue(checkSorted(arr));
    }
  }

  private int[] genIntArrayOfSize(int size) {
    int[] arr = new int[size];

    for(int i = 0; i < size; i++) {
      arr[i] = (int) (Math.random() * 10000);
    }

    return arr;
  }

  private boolean checkSorted(int arr[]) {
    for(int i = 0; i < arr.length - 1; i++) {
      if(arr[i] > arr[i + 1]) {
        return false;
      }
    }
    return true;
  }

}
