package heapsort;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.SortingUtil;

/**
 * Created by danielchu on 10/16/17.
 */
public class HeapSortTests {

  @Test
  public void testHeapSort() {
    int[] arr;
    for(int i = 0; i <= 1000; i+=50) {
      arr = SortingUtil.genIntArrayOfSize(i);
      HeapSort.sort(arr);
      Assert.assertTrue(SortingUtil.checkSorted(arr));
    }
  }
}
