package queuewithstacks;

import java.util.Stack;

/**
 * Created by danielchu on 10/12/17.
 */
public class QueueWithStack<T> {
  Stack<T> stack1;
  Stack<T> stack2;

  public QueueWithStack() {
    stack1 = new Stack<T>();
    stack2 = new Stack<T>();
  }

  public void enqueue(T item) {
    stack1.push(item);
  }

  public T dequeue() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }

  public T peek() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.peek();
  }

}
