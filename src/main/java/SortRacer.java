import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

/**
 * A class that races sorting algorithms.
 * 
 * @author Joel Ross
 */
public class SortRacer {


	public static class MergeSort implements Runnable {
		public MergeSort() {}
		@Override
		public void run() {
			Integer[] nums = shuffled((int)Math.pow(10,7), 448); //a list of shuffled 10 million numbers
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSSS"); //for output
			System.out.println("Starting merge sort at "+ dateFormat.format(new Date()));
			Sorting.mergeSort(nums);
			System.out.println("Merge sort finished at "+ dateFormat.format(new Date())+" !");
		}
	}

	public static class QuickSort implements Runnable {
		public QuickSort() {}
		@Override
		public void run() {
			Integer[] nums = shuffled((int)Math.pow(10,7), 448); //a list of shuffled 10 million numbers
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSSS"); //for output
			System.out.println("Starting quicksort at "+dateFormat.format(new Date()));
			Sorting.quickSort(nums);
			System.out.println("Quicksort finished at "+dateFormat.format(new Date())+" !");
		}
	}

	public static void main(String[] args) 
	{
		/** Merge Sort **/
		MergeSort ms = new MergeSort();

		/** Quick Sort **/
		QuickSort qs = new QuickSort();

		// Initialize threads
		Thread[] threads = new Thread[2];
		threads[0] = new Thread(ms);
		threads[1] = new Thread(qs);

		// Start each thread
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
			System.out.println("Thread #" + i + " has started.");
		}

	}
	
	
	/**
	 * A utility method that returns a shuffled (randomly sorted) array of integers from 1 to the given number.
	 * @param n The number of numbers to shuffle
	 * @param seed A random seed, if less than 0 then unseeded
	 * @return An array of shuffled integers
	 */
	public static Integer[] shuffled(int n, int seed)
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			nums.add(i+1);
		}
		if(seed >= 0)
			Collections.shuffle(nums, new Random(seed));
		else
			Collections.shuffle(nums);
		return nums.toArray(new Integer[0]);		
	}
	
}