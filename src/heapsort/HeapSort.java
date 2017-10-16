package heapsort;

import priorityqueue.MaxHeapInt;

/**
 * Created by danielchu on 10/15/17.
 */
public class HeapSort {

  public static void sort(int arr[]) {
    MaxHeapInt maxHeap = new MaxHeapInt();

    for (int i = 0; i < arr.length; i++) {
      maxHeap.add(arr[i]);
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      arr[i] = maxHeap.pop();
    }
  }

}
