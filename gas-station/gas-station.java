/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

// Keep two pointers, start is the last element, end is the first elemnt.
// initial dif is to see if start can reach end
// if dif is greater than 0, which means can reach, calculate dif with end, and increment end.
// if dif is less than 0, means you need more gas from before, so decrement start, and recalculate dif.
// dif is always cumulative, so at the end of the while loop, dif < 0 means there is no solution.
// if dif is >= 0, return start.

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int start = gas.length-1;
        int end = 0;
        int dif = gas[start] - cost[start];
        
        while(start>end){
            if(dif >= 0){
                dif += gas[end]-cost[end];
                end++;
            }
            else{
                start--;
                dif += gas[start]-cost[start];
            }
        }
        if(dif<0){
            return -1;
        }
        else{
            return start;
        }
    }
}

// Solution with DO WHILE loop
// Have 2 pointers, p1 is for going back when there isn't enough gas,
// p2 is for going foward. GasLeft keeps track of net gas amount at
// a certain time.
// The key is to use a DO WHILE loop so it is ok to have p1 and p2
// both start at index 0.
// The do while loop terminates when the 2 pointers overlap again.
// In the end if the net is not negative, just return p1,
// otherwise return -1 which mean isn't possible.

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int p1 = 0;
        int p2 = 0;
        int gasLeft = 0;
        do{
            if (gasLeft < 0){
                p1 = (p1+ gas.length - 1) % gas.length;
                gasLeft = gasLeft + gas[p1] - cost[p1];
            }
            else{
                gasLeft = gasLeft + gas[p2] - cost[p2];
                p2++;
            }
        }
        while(p2 % gas.length!=p1);
        if (gasLeft>=0){
            return p1;
        }
        return -1;
    }
}
