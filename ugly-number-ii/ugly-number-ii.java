/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
*/

// Generate the multiples of 2, 3, and 5 of numbers starting at 1.
// Use a priority queue to keep track of those numbers.
// Be careful you might add duplicated numbers.
// So every time you poll, just make sure you peek and make sure the next number isn't the same.
// Make sure to use a long to prevent integer overflow.

public class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add((long)1);
        long temp = 1;
        for (int i = 0; i < n; i++){
            temp = pq.poll();
            while(pq.peek()!=null && temp == pq.peek()){
                pq.poll();
            }
            pq.add(temp * 2);
                pq.add(temp * 3);
                pq.add(temp * 5);
        }
        return (int)temp;
    }
}
