package binarysearchtree;

/**
 * Created by danielchu on 10/20/17.
 */
public class BSTNode<T> {
  private T data;
  private BSTNode left;
  private BSTNode right;

  public BSTNode(T data) {
    this(data, null, null);
  }

  public BSTNode(T data, BSTNode left, BSTNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public BSTNode<T> getLeft() {
    return left;
  }

  public BSTNode<T> getRight() {
    return right;
  }

  public void setLeft(BSTNode left) {
    this.left = left;
  }

  public void setRight(BSTNode right) {
    this.right = right;
  }

  public boolean hasLeft() {
    return left != null;
  }

  public boolean hasRight() {
    return right != null;
  }

  public boolean isLeaf() {
    return left == null && right == null;
  }

  @Override
  public String toString() {
    if(isLeaf()) {
      return data.toString();
    } else if(!hasLeft()) {
      return data.toString() + ", " + right.toString();
    } else if (!hasRight()) {
      return left.toString() + ", " + data.toString();
    } else {
      return left.toString() + ", " + data.toString() + ", " + right.toString();
    }
  }
}
