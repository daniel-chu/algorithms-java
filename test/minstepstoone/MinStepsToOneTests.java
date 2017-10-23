package minstepstoone;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by danielchu on 10/22/17.
 */
public class MinStepsToOneTests {

  @Test
  public void testGetMinStepsToOne() {
    Assert.assertEquals(MinStepsToOne.getMinStepsToOne(10), 3);
    Assert.assertEquals(MinStepsToOne.getMinStepsToOne(999), 8);
  }
}
