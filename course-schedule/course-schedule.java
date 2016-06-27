/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/

// Look up topological sort DFS.

public class Solution {
    HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create nodes for all classes and store in hashmap
        for (int i = 0; i < numCourses; i++){
            Node n = new Node(i);
            hm.put(i, n);
        }
        // populate the preReqOf field of nodes
        for(int[] arr: prerequisites){
            Node n = hm.get(arr[1]);
            n.preReqOf.add(arr[0]);
        }
        for (Integer i : hm.keySet()){
            if(hm.get(i).perm == true) continue;
            if(!traverse(i)) return false;
        }
        return true;
    }
    public boolean traverse(int i){
        Node curNode = hm.get(i);
        if (curNode.visited == true) return false;
        if (curNode.perm == true) return true;
        List<Integer> preReqOf = curNode.preReqOf;
        curNode.visited = true;
        for(Integer integer : preReqOf){
            if(!traverse(integer)) return false;
        }
        curNode.visited = false;
        curNode.perm = true;
        return true;
    }
    private class Node{
        private int courseNum; 
        private List<Integer> preReqOf;
        private boolean visited;
        private boolean perm;
        public Node(int courseNum){
            this.courseNum = courseNum;
            preReqOf = new ArrayList<Integer>();
            visited = false;
            perm = false;
        }
    }
}
