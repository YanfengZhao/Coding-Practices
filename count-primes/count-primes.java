/*
Description:

Count the number of prime numbers less than a non-negative number, n.
*/

// Solution 1 is optimized with O(N log log N). VERY CLEVER SOLUTION
// TRICK:
// Sieve of Eratosthenes ALgorithm.
// create a boolean array with size n initialized to all true.
// for loop from 2 to i*i < n:
// if i is not prime, continue. if i is prime, from i*i, to n, mark every i as non prime.
// at the end, everything left in the array that's prime is prime, count them up

// Solution 2 is not optimized.
// when check if a number is prime, only need to check from dividing by 2 to dividing by Math.sqrt(n)

public class Solution {
    public int countPrimes(int n) {
        // Solution 1
        boolean[] isPrime = new boolean[n];
        //set isPrime to all true
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i < n; i++) { // note, i*i < n is more efficient than using sqrt(n) 
            if (!isPrime[i]) {
                continue;
            }
            // if a number is prime, then mark its all multiple as non prime
            // IMPORTANT: start marking at i*i, not i, since everthing before i*i has already been marked false
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        
        // at the end everything that's not marked are prime, so just count.
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
    
    // Solution 2
    public int countPrimesS2(int n) {
        if(n<2){
            return 0;
        }
        int counter = 0;
        for(int i = 2; i < n; i++){
            if(isPrimeS2(i)){
                counter++;
            }
        }
        return counter;
    }
    
    public boolean isPrimeS2(int p){
        if(p<2){
            return false;
        }
        if(p == 2){
            return true;
        }
        for(int i = 2; i*i <= p; i++){
            if(p%i==0){
                return false;
            }
        }
        return true;
    }
}
