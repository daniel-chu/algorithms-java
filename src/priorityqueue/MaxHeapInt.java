package priorityqueue;

import java.util.Comparator;

/**
 * Created by danielchu on 10/16/17.
 */
public class MaxHeapInt extends PriorityQueue<Integer> {

  public MaxHeapInt() {
    super(new Comparator<Integer>() {
      @Override
      public int compare(Integer t1, Integer t2) {
        return (t1 > t2) ? -1 : (t1 == t2) ? 0 : 1;
      }
    });
  }

}
