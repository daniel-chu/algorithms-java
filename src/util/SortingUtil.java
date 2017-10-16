package util;

/**
 * Created by danielchu on 10/16/17.
 */
public class SortingUtil {

  public static int[] genIntArrayOfSize(int size) {
    int[] arr = new int[size];

    for (int i = 0; i < size; i++) {
      arr[i] = (int) (Math.random() * 10000);
    }

    return arr;
  }

  public static boolean checkSorted(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        return false;
      }
    }
    return true;
  }
}
