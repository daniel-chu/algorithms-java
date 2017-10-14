package subarraysum;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by danielchu on 10/14/17.
 */
public class SubarraySumMatchingTests {

  @Test
  public void findFirstSubarrayWithSumTest() {
    int arr1[] = {1, 2, 3, 7, 5};
    int arr2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int arr1SumToFind = 12;
    int arr2SumToFind = 15;

    int arr3[] = {69, 59, 45, 37, 91, 3, 1, 72, 37, 89};
    int arr3SumToFind1 = 173;
    int arr3SumToFind2 = 82;
    int arr3SumToFind3 = 37;

    Assert.assertEquals(SubarraySumMatching.findFirstSubarrayWithSum(arr1, arr1SumToFind), "2 4");
    Assert.assertEquals(SubarraySumMatching.findFirstSubarrayWithSum(arr2, arr2SumToFind), "1 5");
    Assert.assertEquals(SubarraySumMatching.findFirstSubarrayWithSum(arr3, arr3SumToFind1), "1 3");
    Assert.assertEquals(SubarraySumMatching.findFirstSubarrayWithSum(arr3, arr3SumToFind2), "3 4");
    Assert.assertEquals(SubarraySumMatching.findFirstSubarrayWithSum(arr3, arr3SumToFind3), "4 4");
  }
}
