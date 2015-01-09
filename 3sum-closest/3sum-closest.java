public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num == null) return 0;
        int sum=0;
        int ans=0;
        if(num.length < 3){
            for(int number:num){
                sum+=number;
            }
            return sum;
        }
        Arrays.sort(num);
        
        ans = num[0]+num[1]+num[2];
        for(int i=0; i<num.length-2; i++) {//left
            int j = i + 1; //middle
            int k = num.length - 1; //right
            while(j<k){
                sum=num[i]+num[j]+num[k];
                if (Math.abs(target - ans) > Math.abs(target - sum)) {
                    ans = sum;
                    if (ans == target) return ans;
                }
                if (sum > target){ 
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return ans;
    }
}
