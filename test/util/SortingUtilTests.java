package util;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by danielchu on 10/16/17.
 */
public class SortingUtilTests {

  @Test
  public void testCheckSorted() {
    int[] sortedArr = {0, 1, 6, 6, 13, 29, 34, 598};
    int[] unsortedArr = {0, 6, 1, 9, 13, 29, 34, 598};
    int[] emptyArr = {};

    Assert.assertTrue(SortingUtil.checkSorted(sortedArr));
    Assert.assertFalse(SortingUtil.checkSorted(unsortedArr));
    Assert.assertTrue(SortingUtil.checkSorted(emptyArr));
  }
}
