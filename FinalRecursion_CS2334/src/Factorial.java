import java.math.BigInteger;

public class Factorial {
	
	public static BigInteger recFactorial(int number) {
		BigInteger result = BigInteger.valueOf(number);
		if (number <= 1) {
			return BigInteger.ONE; // base case
		}
		else {
			result = result.multiply(recFactorial(number - 1)); // recursive case
			return result;
		}
	}

	public static BigInteger itrFactorial(int number) {
		BigInteger result = BigInteger.ONE;
		for(int i = 2; i <= number; ++i) {
			result = result.multiply(BigInteger.valueOf(i));
		}

		return result;
	}

	public static void recFactorialTest(int[] testSizes) {
		long startTime = 0;
		long elapsedNanos = 0;
		long totalTime = 0;
		BigInteger result = BigInteger.ZERO;
		
		// Warming up Java for recursion
		for(int i = 0; i < 5000; i++) { 
			recFactorial(testSizes[0]); 
		}

		System.out.println("FACTORIAL RECURSION");
		for (int size : testSizes) {
			// Average runtime calculation (10 iterations)
			try {
				for(int i = 0; i < 10; i++) {
					System.gc();
					startTime = System.nanoTime();
					// ... the code being measured ...
					result = recFactorial(size); // storing the result so that it does not get skipped in time calculation
					elapsedNanos = System.nanoTime() - startTime; // Calculate time spent on operation
					totalTime = totalTime + elapsedNanos; // Total time spent for the iterations
				}
				// Total time spent divided by the amount of iterations
				long nanoTime = (totalTime / 10);
				double secTime = nanoTime / 1000000000.0;
				System.out.println("Recursive Average for " + size + ": " 
									+ nanoTime + " nanoseconds OR " 
									+ secTime + " seconds" );
			}
			catch (StackOverflowError e) {
				System.out.println("Recursion Cliff reached at: " + size);
				break; // Stop testing recursion once it fails
			}
		}
	}
	
	public static void itrFactorialTest(int[] testSizes) {
		long startTime = 0;
		long elapsedNanos = 0;
		long totalTime = 0;
		BigInteger result = BigInteger.ZERO;
		/*ITERATION TESTING CODE*/

		// Warming up Java for iteration
		for(int i = 0; i < 5000; i++) { 
			itrFactorial(testSizes[0]);  
		}

		System.out.println("FACTORIAL ITERATION");
		for (int size : testSizes) {
			// Average runtime calculation (10 iterations)
			try {
				for(int i = 0; i < 10; i++) {
					System.gc();
					startTime = System.nanoTime();
					// ... the code being measured ...
					result = itrFactorial(size); // storing the result so that it does not get skipped in time calculation
					elapsedNanos = System.nanoTime() - startTime; // Calculate time spent on operation
					totalTime = totalTime + elapsedNanos; // Total time spent for the iterations
				}
				// Total time spent divided by the amount of iterations
				long nanoTime = (totalTime / 10);
				double secTime = nanoTime / 1000000000.0;
				System.out.println("Recursive Average for " + size + ": " 
									+ nanoTime + " nanoseconds OR " 
									+ secTime + " seconds" );
			}
			catch (StackOverflowError e) {
				System.out.println("Iteration Cliff reached at: " + size);
				break; // Stop testing iteration once it fails
			}
		}
	
	}
}
