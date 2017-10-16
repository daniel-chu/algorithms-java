package priorityqueue;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by danielchu on 10/15/17.
 */
public class MinHeapIntTests {

  @Test
  public void testMinHeap() {
    MinHeapInt minHeap = new MinHeapInt();

    Assert.assertEquals(minHeap.getLength(), 0);

    minHeap.add(5);
    Assert.assertEquals(minHeap.getLength(), 1);
    Assert.assertEquals(minHeap.peek(), 5);

    minHeap.add(-1);
    Assert.assertEquals(minHeap.getLength(), 2);
    Assert.assertEquals(minHeap.peek(), -1);

    minHeap.add(100);
    Assert.assertEquals(minHeap.getLength(), 3);
    Assert.assertEquals(minHeap.peek(), -1);

    minHeap.add(-5);
    Assert.assertEquals(minHeap.getLength(), 4);
    Assert.assertEquals(minHeap.peek(), -5);

    Assert.assertEquals(minHeap.pop(), -5);
    Assert.assertEquals(minHeap.pop(), -1);
    Assert.assertEquals(minHeap.pop(), 5);
    Assert.assertEquals(minHeap.pop(), 100);
  }
}
