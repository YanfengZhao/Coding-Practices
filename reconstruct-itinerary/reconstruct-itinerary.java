/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
*/

// Store itineraries in a Hashmap in the format of <Origin, List of Destinations>.
// Sort each destination list in order.
// Call the recursive helper function.
// Be careful of the corner cases (base cases) in the helper function.

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<String>();
        HashMap<String,ArrayList<String>> hm = new HashMap<String,ArrayList<String>>();
        int numOfStops = tickets.length+1;

        // add all itinerary to hashmap in the format of (orig, list of destinations)
        for(String[] pair: tickets){
            if(hm.containsKey(pair[0])){
                ArrayList<String> dests = new ArrayList<String>();
                dests = hm.get(pair[0]);
                dests.add(pair[1]);
                hm.put(pair[0],dests);
            }
            else{
                ArrayList<String> dests = new ArrayList<String>();
                dests.add(pair[1]);
                hm.put(pair[0],dests);
            }
        }
        
        // traverse the hashmap to sort the dest for each orig
        for(String orig:hm.keySet()){
            ArrayList<String> dests;
            dests = hm.get(orig);
            Collections.sort(dests);
            hm.put(orig,dests);
        }
        
        helper(result,hm,"JFK",numOfStops);
        return result;
    }
    
    public boolean helper(List<String> result, HashMap<String,ArrayList<String>> hm, String curLoc, int numOfStops){
        result.add(curLoc);
        numOfStops--;
        
        if(numOfStops < 0){
            return false;
        }
        
        ArrayList<String> dests = hm.get(curLoc);
        
        if(dests == null){
            if(numOfStops!= 0){
                result.remove(result.size()-1);
                return false;
            }
            else{
                return true;
            }
        }
        
        if(dests.size() == 0 && numOfStops == 0){
            return true;
        }

        for(String d: dests){
            // remove the dest from hm
            ArrayList<String> copy = new ArrayList<String>(dests);
            copy.remove(d);
            hm.put(curLoc,copy);
            if(helper(result,hm,d,numOfStops)){
                return true;
            }
            
            // put the unused dest back in hm
            hm.put(curLoc,dests);
        }
        
        result.remove(result.size()-1);
        return false;
    }
}
