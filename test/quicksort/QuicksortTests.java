package quicksort;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.SortingUtil;

/**
 * Created by danielchu on 10/13/17.
 */
public class QuicksortTests {

  @Test
  public void testQuicksort() {
    int[] arr;
    for(int i = 0; i <= 1000; i+=50) {
      arr = SortingUtil.genIntArrayOfSize(i);
      Quicksort.sort(arr);
      Assert.assertTrue(SortingUtil.checkSorted(arr));
    }
  }

}
