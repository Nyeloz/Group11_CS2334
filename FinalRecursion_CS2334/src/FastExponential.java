import java.math.BigInteger;

public class FastExponential {



    public static double fastExpRecursive(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / fastExpRecursive(x, -n);

        double half = fastExpRecursive(x, n / 2);

        if (n % 2 == 0)
            return half * half;
        else
            return x * half * half;
    }

    public static double fastExpIterative(double x, long n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = 1;

        while (n > 0) {
            if (n % 2 == 1)
                result *= x;

            x *= x;
            n /= 2;
        }

        return result;
    }

    

    public static BigInteger factIteration(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    

    public static void factorialTest(int[] sizes) {
        System.out.println("Factorial Iteration Test");
        System.out.println("------------------------");

        for (int n : sizes) {
            long start = System.nanoTime();

            factIteration(n);

            long end = System.nanoTime();

            System.out.println("n = " + n + " | Time: " + (end - start) + " ns");
        }
    }

    public static void fastExpTest(int[] exponents) {
        double base = 5000;

        System.out.println("\nFast Exponential Test");
        System.out.println("------------------------");

        for (int n : exponents) {

            long startItr = System.nanoTime();
            double itrResult = fastExpIterative(base, n);
            long endItr = System.nanoTime();

            long startRec = System.nanoTime();
            double recResult = fastExpRecursive(base, n);
            long endRec = System.nanoTime();

            System.out.println("Exponent = " + n);
            System.out.println("Iterative Time: " + (endItr - startItr) + " ns");
            System.out.println("Recursive Time: " + (endRec - startRec) + " ns");

            
            System.out.println("Results match: " + (itrResult == recResult));
            System.out.println();
        }
    }

    
 
}
