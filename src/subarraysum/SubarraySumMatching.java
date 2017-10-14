package subarraysum;

/**
 * Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.
 * from http://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
 */
public class SubarraySumMatching {

  public static String findFirstSubarrayWithSum(int[] arr, int sum) {
    if(arr.length < 1) {
      return "Invalid input, array is empty.";
    } else if(arr.length == 1) {
      return (arr[0] == sum) ? "1 1" : "-1";
    }

    int start = 0;
    int end = 0;
    int curSum = arr[start];
    while(end < arr.length && start < arr.length) {
      if(curSum == sum) {
        return ++start + " " + ++end;
      } else if(curSum > sum) {
        if(start == end) {
          if(start < arr.length - 1) {
            ++end;
            curSum = arr[++start];
          } else {
            break;
          }
        } else {
          curSum = curSum - arr[start++];
        }
      } else {
        if(end < arr.length - 1) {
          curSum = curSum + arr[++end];
        } else {
          break;
        }
      }
    }
    return "-1";
  }
}
