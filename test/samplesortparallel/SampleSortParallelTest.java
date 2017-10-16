package samplesortparallel;

import org.testng.Assert;
import org.testng.annotations.Test;

import quicksort.Quicksort;
import util.SortingUtil;

/**
 * Created by danielchu on 10/15/17.
 */
public class SampleSortParallelTest {

  @Test
  public void checkSpeedVsQuickSort() {
    int[] arr1;
    int[] arr2;
    for (int i = 0; i < 3; i++) {
      int size = 15000000;
      arr1 = SortingUtil.genIntArrayOfSize(size);
      arr2 = arr1.clone();
      System.out.println("==== TEST WITH " + size + " NUMBERS ====");

      System.out.print("Regular Quicksort: ");
      long startTime = System.nanoTime();
      Quicksort.sort(arr1);
      long endTime = System.nanoTime();
      long timeTakenMs = (endTime - startTime) / 1000000;
      System.out.println(timeTakenMs + "ms");

      System.out.print("Multithread Sample Sort: ");
      startTime = System.nanoTime();
      SampleSortParallel.sort(arr2, 4);
      endTime = System.nanoTime();
      timeTakenMs = (endTime - startTime) / 1000000;
      System.out.println(timeTakenMs + "ms");

      System.out.println("==================================\n\n");
    }
  }

  @Test
  public void sampleSortParallelTest() {
    int[] arr;
    for (int i = 0; i <= 1000; i += 50) {
      arr = SortingUtil.genIntArrayOfSize(i);
      Quicksort.sort(arr);
      Assert.assertTrue(SortingUtil.checkSorted(arr));
    }
  }

}

