package queuewithstacks;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.EmptyStackException;

/**
 * Created by danielchu on 10/12/17.
 */
public class QueueWithStackTests {

  @Test
  public void testA() {
    QueueWithStack<Integer> queue = new QueueWithStack<>();
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(1);
    queue.enqueue(5);
    queue.enqueue(9);

    Assert.assertEquals(queue.peek(), Integer.valueOf(3));
    Assert.assertEquals(queue.dequeue(), Integer.valueOf(3));
    Assert.assertEquals(queue.dequeue(), Integer.valueOf(4));
    Assert.assertEquals(queue.peek(), Integer.valueOf(1));
    Assert.assertEquals(queue.dequeue(), Integer.valueOf(1));
    Assert.assertEquals(queue.dequeue(), Integer.valueOf(5));
    Assert.assertEquals(queue.dequeue(), Integer.valueOf(9));
  }

  @Test(expectedExceptions = EmptyStackException.class)
  public void testDequeueEmptyQueue() {
    QueueWithStack<Integer> queue = new QueueWithStack<>();
    queue.enqueue(3);
    queue.enqueue(4);

    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
  }
}
