package samplesortparallel;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import quicksort.Quicksort;

/**
 * Created by danielchu on 10/15/17.
 */
public class SampleSortParallelTest {

  @Test
  public void checkSpeedVsQuickSort() {
    int[] arr1;
    int[] arr2;
    for(int i = 0; i < 3; i++) {
      int size = 15000000;
      arr1 = genIntArrayOfSize(size);
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

