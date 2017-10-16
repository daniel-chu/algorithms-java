package priorityqueue;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by danielchu on 10/15/17.
 */
public class MaxHeapIntTests {

  @Test
  public void testMaxHeap() {
    MaxHeapInt maxHeap = new MaxHeapInt();

    Assert.assertEquals(maxHeap.getLength(), 0);

    maxHeap.add(5);
    Assert.assertEquals(maxHeap.getLength(), 1);
    Assert.assertEquals(maxHeap.peek(), Integer.valueOf(5));

    maxHeap.add(-1);
    Assert.assertEquals(maxHeap.getLength(), 2);
    Assert.assertEquals(maxHeap.peek(), Integer.valueOf(5));

    maxHeap.add(100);
    Assert.assertEquals(maxHeap.getLength(), 3);
    Assert.assertEquals(maxHeap.peek(), Integer.valueOf(100));

    maxHeap.add(-5);
    Assert.assertEquals(maxHeap.getLength(), 4);
    Assert.assertEquals(maxHeap.peek(), Integer.valueOf(100));

    Assert.assertEquals(maxHeap.pop(), Integer.valueOf(100));
    Assert.assertEquals(maxHeap.pop(), Integer.valueOf(5));
    Assert.assertEquals(maxHeap.pop(), Integer.valueOf(-1));
    Assert.assertEquals(maxHeap.pop(), Integer.valueOf(-5));
  }
}
