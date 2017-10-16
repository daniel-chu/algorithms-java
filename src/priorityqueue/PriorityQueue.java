package priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by danielchu on 10/15/17.
 */
public abstract class PriorityQueue<T> {
  private List<T> heap;

  // comparator based on what kind of priority queue we are implementing. If comparator.compare
  // returns -1, that means the first element is better (for the kind of heap we want, so for ex.
  // in a min heap, if comparator.compare(t1, t2) returns -1, t1 is less than t2)
  private Comparator<T> comparator;

  public PriorityQueue(Comparator<T> comparator) {
    this.heap = new ArrayList<T>();
    this.comparator = comparator;
  }

  public void add(T obj) {
    heap.add(obj);
    heapifyUp();
  }

  public T peek() {
    return heap.get(0);
  }

  public T pop() {
    T topElement = heap.remove(0);

    if (heap.size() > 0) {
      T lastElement = heap.remove(heap.size() - 1);
      heap.add(0, lastElement);
      heapifyDown();
    }

    return topElement;
  }

  @Override
  public String toString() {
    return heap.toString();
  }

  public int getLength() {
    return heap.size();
  }

  private T getLeftChild(int index) {
    int childIndex = index * 2 + 1;
    return childIndex < heap.size() ? heap.get(childIndex) : null;
  }

  private T getRightChild(int index) {
    int childIndex = index * 2 + 2;
    return childIndex < heap.size() ? heap.get(childIndex) : null;
  }

  private T getParentElement(int index) {
    int parentIndex = (index - 1) / 2;
    return parentIndex >= 0 ? heap.get((index - 1) / 2) : null;
  }

  private void swap(int index1, int index2) {
    T temp = heap.get(index1);
    heap.set(index1, heap.get(index2));
    heap.set(index2, temp);
  }

  private void heapifyDown() {
    int elementIndex = 0;

    while (true) {
      T leftChild = getLeftChild(elementIndex);
      T rightChild = getRightChild(elementIndex);
      int indexToSwapTo;

      if (leftChild == null) {
        break;
      } else if (rightChild == null) {
        indexToSwapTo = elementIndex * 2 + 1;
      } else {
        indexToSwapTo =
                (comparator.compare(getLeftChild(elementIndex), getRightChild(elementIndex)) < 0)
                        ? elementIndex * 2 + 1
                        : elementIndex * 2 + 2;
      }

      if (comparator.compare(heap.get(elementIndex), heap.get(indexToSwapTo)) > 0) {
        swap(elementIndex, indexToSwapTo);
        elementIndex = indexToSwapTo;
      } else {
        break;
      }
    }

  }

  private void heapifyUp() {
    int elementIndex = heap.size() - 1;

    while (true) {
      T parentElement = getParentElement(elementIndex);
      if (parentElement == null) {
        break;
      }
      if (comparator.compare(heap.get(elementIndex), getParentElement(elementIndex)) < 0) {
        int parentIndex = (elementIndex - 1) / 2;
        swap(elementIndex, parentIndex);
        elementIndex = parentIndex;
      } else {
        break;
      }
    }
  }
}
