/*
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

An easy approach is to sort the array first.
What are the possible values of h-index?
A faster approach is to use extra space.
*/

// O(n) time O(n) space with bubble sort concept.
// Create 0 to n+1 buckets.
// For each paper, add one to the corresponding bucket -1 .
// KEY -> if the citation is bigger than n, then put it in the nth bucket.
// Traverse the bucket in reverse order and keep track of the sum of citations you see.
// Once the sum exceed the index number, return that number.

public class Solution {
    public int hIndex(int[] citations) {
        int[] buckets = new int[citations.length+1];
        int bucketsLength = buckets.length;
        for (int cit : citations){
            if (cit >= bucketsLength){
                buckets[bucketsLength-1]++;
            } else {
                buckets[cit]++;
            }
        }
        int sum = 0;
        for(int i = bucketsLength-1; i >= 0; i--){
            sum += buckets[i];
            if (sum >= i){
                return i;
            }
        }
        return 0;
    }
}
