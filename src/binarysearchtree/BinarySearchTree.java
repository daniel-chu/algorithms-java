package binarysearchtree;

/**
 * Implementation of a binary search tree of generic type T. Objects that are equal to one
 * already in the tree are ignored and not inserted in this implementation.
 */
public class BinarySearchTree<T extends Comparable<T>> {

  private BSTNode<T> root;

  BinarySearchTree() {
    this.root = null;
  }

  BinarySearchTree(BSTNode<T> root) {
    this.root = root;
  }

  // adds the element into the tree if it is not a duplicate
  public void add(T data) {
    root = addHelper(root, data);
  }

  // recursive helper for add, returns the root node after adding in the new data
  private BSTNode<T> addHelper(BSTNode<T> curNode, T data) {
    if (curNode == null) {
      curNode = new BSTNode<T>(data);
      return curNode;
    }

    T nodeData = curNode.getData();
    if (data.compareTo(nodeData) < 0) {
      curNode.setLeft(addHelper(curNode.getLeft(), data));
    } else if (data.compareTo(nodeData) > 0) {
      curNode.setRight(addHelper(curNode.getRight(), data));
    }

    return curNode;
  }

  // searches for and returns the element if it is in the tree
  public T search(T data) {
    return searchHelper(root, data);
  }

  // recursive helper for search, returns the data if it is found within the subtree represented
  // by curNode
  private T searchHelper(BSTNode<T> curNode, T data) {
    if (curNode == null) {
      return null;
    }

    T curData = curNode.getData();
    if (data.compareTo(curData) == 0) {
      return curData;
    } else if (data.compareTo(curData) < 0) {
      return searchHelper(curNode.getLeft(), data);
    } else {
      return searchHelper(curNode.getRight(), data);
    }
  }

  // removes the element from the tree if it is in it
  public void remove(T data) {
    root = removeHelper(root, data);
  }

  // recursive helper for remove, returns the removed element (null if none)
  private BSTNode<T> removeHelper(BSTNode<T> curNode, T data) {
    if(curNode == null) {
      return null;
    }

    T curData = curNode.getData();
    if(data.compareTo(curData) == 0) {
      if(curNode.isLeaf()) {
        return null;
      } else if(!curNode.hasLeft()) {
        return curNode.getRight();
      } else if(!curNode.hasRight()) {
        return curNode.getLeft();
      } else {
        T minInRightSubTree = findMin(curNode.getRight());
        curNode.setData(minInRightSubTree);
        removeHelper(curNode.getRight(), minInRightSubTree);
      }
    } else if (data.compareTo(curData) < 0) {
      curNode.setLeft(removeHelper(curNode.getLeft(), data));
    } else {
      curNode.setRight(removeHelper(curNode.getRight(), data));
    }

    return curNode;
  }

  private T findMin(BSTNode<T> curNode) {
    if(curNode.hasLeft()) {
      return findMin(curNode.getLeft());
    } else {
      return curNode.getData();
    }
  }

  // returns a string representing the elements in order
  public String toString() {
    return root.toString();
  }

}
