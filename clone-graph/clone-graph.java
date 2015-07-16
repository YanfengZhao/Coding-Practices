/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 
// BFS. The key is to use a hashmap label as key node itself as value.

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null){
			return null;
		}
		HashMap<Integer,UndirectedGraphNode> hm = new HashMap<Integer,UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(node);
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        hm.put(root.label, root);
        while(!q.isEmpty()){
        	UndirectedGraphNode oldNode = q.poll();
        	for(UndirectedGraphNode n : oldNode.neighbors){
        		if (!hm.containsKey(n.label)) {
                    hm.put(n.label, new UndirectedGraphNode(n.label));
                    q.add(n);
                }
                hm.get(oldNode.label).neighbors.add(hm.get(n.label));
        	}
        }
        return root;
    }
}
