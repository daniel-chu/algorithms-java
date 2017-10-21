package dictionary;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by danielchu on 10/21/17.
 */
public class DictionaryTests {

  Dictionary dict1;
  Dictionary dict2;
  Dictionary dict3;

  @BeforeClass
  public void init() {
    dict1 = new Dictionary();
    dict1.addFromFile("testresources/words.txt");
  }

  @Test
  public void testAdd() {
    dict2 = new Dictionary();
    Assert.assertFalse(dict2.contains("hello"));
    dict2.add("hell");
    Assert.assertFalse(dict2.contains("hello"));
    dict2.add("hello");
    Assert.assertTrue(dict2.contains("hello"));
    dict2.add("help");
    Assert.assertTrue(dict2.contains("hello"));
    Assert.assertTrue(dict2.contains("help"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class,
          expectedExceptionsMessageRegExp = "Cannot add empty string to the Dictionary.")
  public void testAddEmptyString() {
    dict1.add("");
  }

  @Test
  public void testContains() {
    Assert.assertFalse(dict1.contains("gre"));
    Assert.assertTrue(dict1.contains("green"));
    Assert.assertTrue(dict1.contains("greedy"));

    Assert.assertTrue(dict1.contains("a"));
    Assert.assertFalse(dict1.contains("ac"));
    Assert.assertTrue(dict1.contains("act"));

    Assert.assertTrue(dict1.contains("crime"));
    Assert.assertFalse(dict1.contains("cyig"));
    Assert.assertTrue(dict1.contains("crying"));

    Assert.assertFalse(dict1.contains("asfwefef"));
  }

  @Test
  public void testRemove() {
    dict3 = new Dictionary();
    dict3.add("act");
    dict3.add("actress");
    dict3.add("actor");
    dict3.add("acting");
    dict3.add("blue");
    Assert.assertTrue(dict3.contains("act"));
    Assert.assertTrue(dict3.contains("actress"));
    Assert.assertTrue(dict3.contains("actor"));
    Assert.assertTrue(dict3.contains("acting"));
    Assert.assertTrue(dict3.contains("blue"));

    dict3.remove("actor");
    Assert.assertTrue(dict3.contains("act"));
    Assert.assertTrue(dict3.contains("actress"));
    Assert.assertFalse(dict3.contains("actor"));
    Assert.assertTrue(dict3.contains("acting"));
    Assert.assertTrue(dict3.contains("blue"));

    dict3.remove("act");
    Assert.assertFalse(dict3.contains("act"));
    Assert.assertTrue(dict3.contains("actress"));
    Assert.assertFalse(dict3.contains("actor"));
    Assert.assertTrue(dict3.contains("acting"));
    Assert.assertTrue(dict3.contains("blue"));

    dict3.remove("acting");
    Assert.assertFalse(dict3.contains("act"));
    Assert.assertTrue(dict3.contains("actress"));
    Assert.assertFalse(dict3.contains("actor"));
    Assert.assertFalse(dict3.contains("acting"));
    Assert.assertTrue(dict3.contains("blue"));

    dict3.remove("actress");
    Assert.assertFalse(dict3.contains("act"));
    Assert.assertFalse(dict3.contains("actress"));
    Assert.assertFalse(dict3.contains("actor"));
    Assert.assertFalse(dict3.contains("acting"));
    Assert.assertTrue(dict3.contains("blue"));

    dict3.remove("blue");
    Assert.assertFalse(dict3.contains("act"));
    Assert.assertFalse(dict3.contains("actress"));
    Assert.assertFalse(dict3.contains("actor"));
    Assert.assertFalse(dict3.contains("acting"));
    Assert.assertFalse(dict3.contains("blue"));
  }

}
