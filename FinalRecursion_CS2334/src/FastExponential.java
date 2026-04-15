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

    public static void fastExpTest(double base, int[] sizes) {

        System.out.println("Fast Exponential Testing");
        System.out.println("------------------------");

        for (int n : sizes) {

            long startItr = System.nanoTime();
            double itrResult = fastExpIterative(base, n);
            long endItr = System.nanoTime();

            long startRec = System.nanoTime();
            double recResult = fastExpRecursive(base, n);
            long endRec = System.nanoTime();

            System.out.println("Exponent = " + n);
            System.out.println("Iterative Time: " + (endItr - startItr) + " ns");
            System.out.println("Recursive Time: " + (endRec - startRec) + " ns");

            System.out.println("Match: " +
                (Math.abs(itrResult - recResult) < 1e-9));

            System.out.println();
        }
    }

   
    public static void main(String[] args) {

        int[] sizes = {5000, 10000, 30000, 50000, 70000, 100000};

        double base = 1.0001;

        fastExpTest(base, sizes);
    }
}
