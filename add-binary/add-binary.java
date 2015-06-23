public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        if(a.length()>b.length()){
            sb.append(b);
            for(int i = b.length(); i< a.length(); i++){
                sb.insert(0,"0");
            }
            b = sb.toString();
        }
        else if(a.length()<b.length()){
            sb.append(a);
            for(int i = a.length(); i< b.length(); i++){
                sb.insert(0,"0");
            }
            a = sb.toString();
        }
        sb.setLength(0);
        for(int i = a.length()-1; i>=0; i--){
            int sum = a.charAt(i)-'0' + b.charAt(i)-'0'+ carry;
            if(sum>1){
                carry = 1;
            }
            else{
                carry = 0;
            }
            sb.insert(0,sum%2);
        }
        if(carry == 1){
            sb.insert(0,"1");
        }
        return sb.toString();
    }
}
