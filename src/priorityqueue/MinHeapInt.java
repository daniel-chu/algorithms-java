package priorityqueue;

import java.util.Comparator;

/**
 * Created by danielchu on 10/15/17.
 */
public class MinHeapInt extends PriorityQueue {

  public MinHeapInt() {
    super(new Comparator() {
      @Override
      public int compare(Object t1, Object t2) {
        int num1 = (int) t1;
        int num2 = (int) t2;
        return (num1 < num2) ? -1 : (num1 == num2) ? 0 : 1;
      }
    });
  }
}
