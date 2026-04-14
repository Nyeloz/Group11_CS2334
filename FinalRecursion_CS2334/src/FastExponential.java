import java.math.BigInteger;

public class FastExponential {

   

    public static double fastExpRecursive(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / fastExpRecursive(x, -n);
        double half = fastExpRecursive(x, n / 2);
        if (n % 2 == 0) return half * half;
        else return x * half * half;
    }

    public static double fastExpIterative(double x, long n) {
        if (n < 0) { x = 1 / x; n = -n; }
        double result = 1;
        while (n > 0) {
            if (n % 2 == 1) result *= x;
            x *= x;
            n /= 2;
        }
        return result;
    }
    
    
    
}

    
