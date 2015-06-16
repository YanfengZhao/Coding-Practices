public class Solution {
    public String multiply(String num1, String num2) {
        int n1Size = num1.length();
        int n2Size = num2.length();
        int[] product = new int[n1Size+n2Size];
        
        // multiply and store in product
        for(int i = n1Size-1; i>=0; i--){
            for(int j = n2Size-1; j>=0; j--){
                product[i+j+1] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }
        
        // deal with carries
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        boolean greaterThanZero = false;
        for(int i = product.length - 1; i >= 0; i--){
            product[i] += carry;
            carry = product[i]/10;
            product[i] = product[i]%10;
            if(product[i]>0){
                greaterThanZero = true;
            }
            if(i!=0 || product[i]!=0){
                sb.insert(0, Integer.toString(product[i]));
            }
        }
        if(greaterThanZero == false){
            return "0";
        }
        return sb.toString();
    }
}
