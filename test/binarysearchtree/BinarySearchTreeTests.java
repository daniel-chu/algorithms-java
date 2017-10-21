package binarysearchtree;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.management.RuntimeErrorException;

/**
 * Created by danielchu on 10/21/17.
 */
public class BinarySearchTreeTests {

  BinarySearchTree<Integer> integerBST;

  @BeforeMethod
  public void init() {
    integerBST = new BinarySearchTree<>();
    integerBST.add(30);
    integerBST.add(11);
    integerBST.add(13);
    integerBST.add(1);
    integerBST.add(50);
    integerBST.add(70);
    integerBST.add(2);
    integerBST.add(12);
    integerBST.add(40);
    integerBST.add(31);
    integerBST.add(60);
    integerBST.add(200);
    integerBST.add(45);
  }

  @Test
  public void testSearch() {
    Assert.assertEquals(integerBST.search(40), Integer.valueOf(40));
    Assert.assertEquals(integerBST.search(12), Integer.valueOf(12));
    Assert.assertEquals(integerBST.search(31), Integer.valueOf(31));
    Assert.assertEquals(integerBST.search(60), Integer.valueOf(60));
    Assert.assertEquals(integerBST.search(1), Integer.valueOf(1));

    Assert.assertNull(integerBST.search(999));
    Assert.assertNull(integerBST.search(14));
    Assert.assertNull(integerBST.search(58));
  }

  @Test
  public void testAdd() {
    Assert.assertNull(integerBST.search(14));
    integerBST.add(14);
    Assert.assertEquals(integerBST.search(14), Integer.valueOf(14));
  }

  @Test
  public void testRemove() {
    Assert.assertEquals(integerBST.search(50), Integer.valueOf(50));
    integerBST.remove(50);
    Assert.assertNull(integerBST.search(50));
    Assert.assertEquals(integerBST.search(30), Integer.valueOf(30));
    Assert.assertEquals(integerBST.search(40), Integer.valueOf(40));
    Assert.assertEquals(integerBST.search(70), Integer.valueOf(70));
    Assert.assertEquals(integerBST.search(60), Integer.valueOf(60));
  }

  @Test
  public void testToString() {
    Assert.assertEquals(integerBST.toString(), "1, 2, 11, 12, 13, 30, 31, 40, 45, 50, 60, 70, 200");
    integerBST.remove(11);
    Assert.assertEquals(integerBST.toString(), "1, 2, 12, 13, 30, 31, 40, 45, 50, 60, 70, 200");
    integerBST.add(137);
    Assert.assertEquals(integerBST.toString(), "1, 2, 12, 13, 30, 31, 40, 45, 50, 60, 70, 137, "
            + "200");
  }

}
