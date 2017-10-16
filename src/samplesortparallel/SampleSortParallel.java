package samplesortparallel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by danielchu on 10/15/17.
 */
public class SampleSortParallel {

  public static void sort(int[] arr, int numThreads) {
    if (3 * (numThreads - 1) > arr.length) {
      Arrays.sort(arr);
      return;
    }

    CyclicBarrier barrier = new CyclicBarrier(numThreads);

    int[] samples = sample(arr, numThreads);
    int[] sizes = new int[numThreads];
    Thread[] threads = new Thread[numThreads];

    for (int i = 0; i < numThreads; i++) {
      final int threadNum = i;
      Runnable worker = () -> {
        int low = samples[threadNum];
        int high = samples[threadNum + 1];

        List<Integer> localArr = new ArrayList<Integer>();

        for (int j = 0; j < arr.length; j++) {
          if (arr[j] >= low && arr[j] < high) {
            localArr.add(arr[j]);
          }
        }
        sizes[threadNum] = localArr.size();

        Collections.sort(localArr);

        try {
          barrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }

        int startIndex = 0;
        int endIndex = 0;
        for(int j = 0; j <= threadNum - 1; j++) {
          startIndex += sizes[j];
        }
        for(int j = 0; j <= threadNum; j++) {
          endIndex += sizes[j];
        }

        for(int j = startIndex; j < endIndex; j++) {
          arr[j] = localArr.get(j - startIndex);
        }

      };
      Thread thread = new Thread(worker);
      threads[i] = thread;
      thread.start();
    }

    for (int i = 0; i < numThreads; i++) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    return;
  }

  private static int[] sample(int[] arr, int numThreads) {
    int tempSize = 3 * (numThreads - 1);
    int temp[] = new int[tempSize];
    Set<Integer> alreadyChosenIndices = new HashSet<Integer>();

    for (int i = 0; i < tempSize; i++) {
      int randIndex = (int) (Math.random() * tempSize);
      while (alreadyChosenIndices.contains(randIndex)) {
        randIndex = (int) (Math.random() * tempSize);
      }
      temp[i] = arr[randIndex];
      alreadyChosenIndices.add(randIndex);
    }
    Arrays.sort(temp);

    int samples[] = new int[numThreads + 1];
    samples[0] = 0;

    for (int i = 1; i < samples.length - 1; i++) {
      int groupStartIndex = (i - 1) * 3;
      if (groupStartIndex + 1 >= temp.length) {
        samples[i] = temp[groupStartIndex];
        continue;
      } else {
        samples[i] = temp[groupStartIndex + 1];
      }
    }
    samples[samples.length - 1] = Integer.MAX_VALUE;

    return samples;
  }

}
