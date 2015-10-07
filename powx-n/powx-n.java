/*
Implement pow(x, n).
*/

// Recursion

public class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
		    return 1 / power(x, n);
	    } else {
		    return power(x, n);
	    }
    }
    public double power(double x, int n) {
    	if (n == 0)
    		return 1;
     
    	double v = power(x, n / 2);
     
    	if (n % 2 == 0) {
    		return v * v;
    	} else {
    		return v * v * x;
    	}
    }
}

// Iterative

public class Solution {
    public double pow(double x, int n) {
        if(n==0){
            return 1;
        }
        double product = 1.0;
        for(int i = n; i != 0; i /= 2, x *= x) {
            if( i % 2 != 0 ) {
                product*=x;
            }
        }
        return n < 0 ? 1.0 / product : product;
    }
}
