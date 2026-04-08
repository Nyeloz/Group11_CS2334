import java.math.BigDecimal;
import java.math.BigInteger;

public class Driver {

	public static void main(String[] args) {
	

		// Factorial tests for recursion and iteration
		int[] testSizes = {5000, 10000, 30000, 50000, 70000, 100000};
		Factorial.recFactorialTest(testSizes);
		System.out.println();
		Factorial.itrFactorialTest(testSizes);

	
		//Arrays with values of capacity in each index
		int[] testDataArr1 = new int[5000];
		int[] testDataArr2 = new int[10000];
		int[] testDataArr3 = new int[30000];
		int[] testDataArr4 = new int[50000];
		int[] testDataArr5 = new int[70000];
		int[] testDataArr6 = new int[100000];
		
	
		//adding values to arrays
		for(int i = 0; i < 5000; i++) { 
			testDataArr1[i] = i + 1;
			
		}
		//for binary search
		for(int i = 0; i < 10000; i++) { 
			testDataArr2[i] = i + 1;
		}
		for(int i = 0; i < 30000; i++) { 
			testDataArr3[i] = i + 1;
		}
		for(int i = 0; i < 50000; i++) { 
			testDataArr4[i] = i + 1;
		}
		for(int i = 0; i < 70000; i++) { 
			testDataArr5[i] = i + 1;
		}
		for(int i = 0; i < 100000; i++) { 
			testDataArr6[i] = i + 1;
		}
		
		//arrays of filled out arrays
		int[][] testArrays = {testDataArr1, testDataArr2, testDataArr3, testDataArr4, testDataArr5, testDataArr6};





	}
}
