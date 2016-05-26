/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

// O(n log n)
// Use Hashmap to keep track of the occurances.
// Create a wrapper class which implements Comparable.
// Traverse Hashmap and wrap every key value pair and put them in an ArrayList.
// Sort the ArrayList O(n log n).
// Get the first k elements of the ArrayList.

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i: nums){
            if(hm.containsKey(i)){
                hm.put(i,hm.get(i)+1);
            }
            else{
                hm.put(i,1);
            }
        }
        ArrayList<Wrapper> arr = new ArrayList<Wrapper>();
        for(int key:hm.keySet()){
            arr.add(new Wrapper(key,hm.get(key)));
        }
        Collections.sort(arr);
        int tmp = Math.min(k,arr.size());
        ArrayList<Integer> results = new ArrayList<Integer>();
        for(int i = 0; i < tmp; i++){
            results.add(arr.get(i).num);
        }
        return results;
    }
    
    public class Wrapper implements Comparable<Wrapper>{
        public int num;
        public int count;
        public Wrapper(int num, int count){
            this.num = num;
            this.count = count;
        }
        @Override
        public int compareTo(Wrapper other){
            if(this.count<other.count){
                return 1;
            }
            else if(this.count == other.count){
                return 0;
            }
            return -1;
        } 
    }
}
