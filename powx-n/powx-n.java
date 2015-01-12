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
/* recursion
 public class Solution {
        public double pow(double x, int m) {
            double temp=x;
            if(m==0)
            return 1;
            temp=pow(x,m/2);
            if(m%2==0)
            return temp*temp;
            else 
            {
            if(m > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
            }

    }
*/
