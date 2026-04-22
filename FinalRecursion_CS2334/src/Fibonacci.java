import java.math.BigInteger;



public class Fibonacci {

	public static int fibRecursive(int n) {

		if (n <= 1) {

			return n;

		}


		return fibRecursive(n-1) + fibRecursive(n-2);

	}
	

	public static int fibIterative(int n) {

		if (n <= 1) {

			return n;

		}


		int prev = 0;

		int curr = 1;


		for (int i = 2; i <= n; i++) {

			int next = prev + curr;

			prev = curr;

			curr = next;

		}


		return curr;

	}


	public static void fibTestingRec(int[] testSizes) {

		System.out.println(" Fibonacci Performance Testing recursive");



		for (int size : testSizes) {

			long totalTime = 0;

			int lastResult = 0;



			try {


				for (int i = 0; i < 10; i++) {

					System.gc();


					long startTime = System.nanoTime();

					lastResult = fibRecursive(size);

					long elapsedNanos = System.nanoTime() - startTime;


					totalTime += elapsedNanos;

				}



				long avgNano = totalTime / 10;

				double avgSec = avgNano / 1_000_000_000.0;



				System.out.printf("n=%d | Avg: %d ns (%.6f sec) | Result: %d%n",

						size, avgNano, avgSec, lastResult);


			} catch (StackOverflowError e) {

				System.err.println("Stack Overflow at n=" + size);

				break;

			}

		}

	}

	public static void fibTestingItr(int[] testSizes) {

		System.out.println(" Fibonacci Performance Testing itr ");



		for (int size : testSizes) {

			long totalTime = 0;

			int lastResult = 0;



			try {


				for (int i = 0; i < 10; i++) {

					System.gc();


					long startTime = System.nanoTime();

					lastResult = fibIterative(size);

					long elapsedNanos = System.nanoTime() - startTime;


					totalTime += elapsedNanos;

				}



				long avgNano = totalTime / 10;

				double avgSec = avgNano / 1_000_000_000.0;



				System.out.printf("n=%d | Avg: %d ns (%.6f sec) | Result: %d%n",

						size, avgNano, avgSec, lastResult);


			} catch (StackOverflowError e) {

				System.err.println("Stack Overflow at n=" + size);

				break;

			}

		}

	}


	}