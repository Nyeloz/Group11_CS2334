import java.math.BigInteger;
import java.util.Random;

public class Binary {
	
	//finds index
	public static int iterationBinarySearch(int[] arr, int target, int start, int end) {
		
		int midVal = 0;
		while(start <= end) {
			midVal = start + ( (end - start) / 2);
			
			if(arr[midVal]  < target) {
				start = midVal + 1;
			}else if(arr[midVal] > target) {
				end = midVal - 1;
			}else if(arr[midVal] == target) {
				return midVal;
			}
		}
		return  -1;
	
	}
	
	public static int recursiveBinarySearch(int[] arr, int target, int start, int end) {
		
		int midVal = start + ( (end - start) / 2);
		
		if(end < start) {
			return - 1;
		}
		
		if(target == arr[midVal]) {
			return midVal;
		}else if(target < arr[midVal]) {
			return recursiveBinarySearch(arr, target, start, midVal - 1);
		}else {
			return recursiveBinarySearch(arr, target, midVal + 1, end);
		}
	}
	
	public static void recBinaryTest(int[][] testArrays) {
		int result = 0;
		long startTime = 0;
		long elapsedNanos = 0;
		
		
		Random ran = new Random();
		
		for(int[] arr : testArrays) { // iterating over each sample size
			long totalTime = 0;
			
			for(int i = 0; i < 10; i++) { //doing each test ten times
				System.gc();
				int targetVal = arr[ran.nextInt(arr.length)];
				
				 startTime = System.nanoTime(); //starting the clock for current iteration
				
				result = recursiveBinarySearch(arr, targetVal, 0, arr.length - 1);
				
				 elapsedNanos = System.nanoTime() - startTime; // ending  clock
				 totalTime += elapsedNanos; //adding iteration to total
				
			}
			long nanoTime = totalTime / 10;
			
			
			System.out.println("Recursive Average for " + arr.length + ": " 
					+ nanoTime + " nanoseconds");
			
			
		}
		
		
	}
	public static void itrBinaryTest(int[][] testArrays) {
		int result = 0;
		long startTime = 0;
		long elapsedNanos = 0;
		
		
		Random ran = new Random();
		
		for(int[] arr : testArrays) { // iterating over each sample size
			long totalTime = 0;
			
			for(int i = 0; i < 10; i++) { //doing each test ten times
				System.gc();
				int targetVal = arr[ran.nextInt(arr.length)];
				
				 startTime = System.nanoTime(); //starting the clock for current iteration
				
				result = iterationBinarySearch(arr, targetVal, 0, arr.length - 1);
				
				 elapsedNanos = System.nanoTime() - startTime; // ending  clock
				 totalTime += elapsedNanos; //adding iteration to total
				
			}
			long nanoTime = totalTime / 10;
			double secTime = nanoTime / 1000000000.0;
			
			System.out.println("Iterative Average for " + arr.length + ": " 
					+ nanoTime + " nanoseconds" );
			
			
		}
		
		
	}
	
	
}
