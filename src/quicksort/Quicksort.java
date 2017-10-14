package quicksort;

/**
 * Created by danielchu on 10/13/17.
 */
public class Quicksort {

  // sorts the array
  public static void sort(int[] arr) {
    quicksortMain(arr, 0, arr.length - 1);
  }

  private static void quicksortMain(int[] arr, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(arr, low, high);

      quicksortMain(arr, low, pivotIndex - 1);
      quicksortMain(arr, pivotIndex + 1, high);
    }
  }

  private static int partition(int[] arr, int low, int high) {
    int randIndex = (int) (Math.random() * (high - low + 1) + low);
    swap(arr, randIndex, high);

    int i = low - 1;
    int j = low;
    while (j < high) {
      if (arr[j] < arr[high]) {
        swap(arr, ++i, j);
      }
      j++;
    }
    swap(arr, i + 1, high);

    return i + 1;
  }

  private static void swap(int[] arr, int i1, int i2) {
    int temp = arr[i1];
    arr[i1] = arr[i2];
    arr[i2] = temp;
  }

}
