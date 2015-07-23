/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

// O(n). Have 2 pointers at beginning and ending of the array.
// Take the minimum of the two numbers and calculate the area.
// If area is greater than max, update max.
// Find the shorter size between left and right pointer, increment pointer for left or decrement pointer for right
// until you find a size that's bigger than you originally had, calculate the area again and update max.
// Return max when left == right.
// Solution 2 has to calculate the area each time you change left or right, but Solution 1 only need to change when
// you find a height[l] > previous height[l] or height[r] > previous height[r]

public class Solution {
    public int maxArea(int[] height) {
        if(height.length < 2){
            return 0;
        }
        int max = 0;
        int l = 0;
        int r = height.length-1;
        
        while(l<r){
            int h = Math.min(height[l],height[r]);
            int area = h*(r-l);
            if(area>max){
                max = area;
            }
            
            if(height[l]<height[r]){
                int lheight = height[l];
                while(l<r && height[l] <= lheight){
                    l++;
                }
            }
            else{
                int rheight = height[r];
                while(l<r && height[r] <= rheight){
                    r--;
                }
            }
        }
        return max;
    }
    
    public int maxAreaS2(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while(left<right){
            result = Math.max(result,(right - left)*Math.min(height[left],height[right]));
            if(height[left]<height[right]) left++;
            else if(height[right]<=height[left]) right--;
        }
        return result;
    }
}
