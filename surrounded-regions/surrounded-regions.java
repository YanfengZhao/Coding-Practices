/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

// BFS.
// Solution 1 does not use the Node class.

public class Solution {
    // Solution 1
    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    helper(board, i, j);
                }
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void helper(char[][] board, int i, int j){
        boolean surrounded = true;
        boolean[][] marked = new boolean[board.length][board[0].length];
        List<Integer> listX = new ArrayList<Integer>();
        List<Integer> listY = new ArrayList<Integer>();
        Queue<Integer> queueX = new LinkedList<Integer>();
        Queue<Integer> queueY = new LinkedList<Integer>();
        queueX.add(i);
        queueY.add(j);
        marked[i][j] = true;
        while(!queueX.isEmpty()){
            Queue<Integer> tmpQueueX = new LinkedList<Integer>();
            Queue<Integer> tmpQueueY = new LinkedList<Integer>();
            while(!queueX.isEmpty()){
                int x = queueX.poll();
                int y = queueY.poll();
                if(atBoundary(x,y,board)){
                    surrounded = false;
                }
                listX.add(x);
                listY.add(y);
            
                if(ableToVisit(x-1, y, marked, board)){
                    tmpQueueX.add(x-1);
                    tmpQueueY.add(y);
                    marked[x-1][y] = true;
                }
                if(ableToVisit(x+1, y, marked, board)){
                    tmpQueueX.add(x+1);
                    tmpQueueY.add(y);
                    marked[x+1][y] = true;
                }
                if(ableToVisit(x, y-1, marked, board)){
                    tmpQueueX.add(x);
                    tmpQueueY.add(y-1);
                    marked[x][y-1] = true;
                }
                if(ableToVisit(x, y+1, marked, board)){
                    tmpQueueX.add(x);
                    tmpQueueY.add(y+1);
                    marked[x][y+1] = true;
                }
            }
            queueX = tmpQueueX;
            queueY = tmpQueueY;
        }
        if(surrounded){
            replace(listX, listY, board, 'X');
        }
        else{
            replace(listX, listY, board, '1');
        }
    }
    
    private boolean ableToVisit(int x, int y, boolean[][] marked, char[][] board){
        return x >= 0 && x < marked.length && y >= 0 && y < marked[0].length && !marked[x][y] && board[x][y] == 'O';
    }
    
    private boolean atBoundary(int x, int y, char[][] board){
        return x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1;
    }
    private void replace(List<Integer> listX, List<Integer> listY, char[][] board, char tmp){
        for(int i = 0; i < listX.size(); i++){
            board[listX.get(i)][listY.get(i)] = tmp;
        }
    }
    
    // Solution 2
    public void solve2(char[][] board) {
        if(board.length == 0){
            return;
        }
        
        int[][] doesNotFlip = new int[board.length][board[0].length];
        
        // preprocess edges
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O'){
                doesNotFlip[i][0] = 1;
            }
            if(board[i][board[0].length-1] == 'O'){
                doesNotFlip[i][board[0].length-1] = 1;
            }
        }
        
        for(int i = 0; i < board[0].length; i++){
            if(board[0][i] == 'O'){
                doesNotFlip[0][i] = 1;
            }
            if(board[board.length-1][i] == 'O'){
                doesNotFlip[board.length-1][i] = 1;
            }
        }
        
        for(int i = 1; i < board.length-1; i++){
            for(int j = 1; j < board[0].length-1; j++){
                if(board[i][j] == 'O' && doesNotFlip[i][j] == 0){
                    if(bfsFlips(i,j,doesNotFlip,board)){
                        board[i][j] = 'X';
                    }
                    else{
                        doesNotFlip[i][j] = 1;
                    }
                }
            }
        }
    }
    
    public boolean bfsFlips(int i, int j, int[][] doesNotFlip, char[][] board){
    	ArrayList<Node> hs = new ArrayList<Node>();
        Node node = new Node(i,j);
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            int tempi = n.i;
            int tempj = n.j;
            if(doesNotFlip[tempi-1][tempj] == 1 || doesNotFlip[tempi+1][tempj] == 1 || doesNotFlip[tempi][tempj+1] == 1 || doesNotFlip[tempi][tempj-1] == 1){
                for(Node temp: hs){
                	int ti = temp.i;
                	int tj = temp.j;
                	doesNotFlip[ti][tj] = 1;
                }
                return false;
            }
          
            if(board[tempi-1][tempj] != 'X'){
            	Node temp = new Node(tempi-1,tempj);
            	if(!hs.contains(temp)){
            		q.add(temp);
            		hs.add(temp);
                }
            }
            if(board[tempi+1][tempj] != 'X'){
                Node temp = new Node(tempi+1,tempj);
                if(!hs.contains(temp)){
            		q.add(temp);
            		hs.add(temp);
                }
            }
            if(board[tempi][tempj-1] != 'X'){
                Node temp = new Node(tempi,tempj-1);
                if(!hs.contains(temp)){
            		q.add(temp);
            		hs.add(temp);
                }
            }
            if(board[tempi][tempj+1] != 'X'){
                Node temp = new Node(tempi,tempj+1);
                if(!hs.contains(temp)){
            		q.add(temp);
            		hs.add(temp);
                }
            }
        }
        // flip all nodes in arraylist and change them to X in board
        for(Node n: hs){
        	int tempi = n.i;
        	int tempj = n.j;
        	board[tempi][tempj] = 'X';
        }
        return true;
    }
    
    public class Node{
        @Override
    	public boolean equals(Object n) {
        	if(n instanceof Node){
        		Node node = (Node)n;
        		return i == node.i && j == node.j;
        	}
        	return false;
    	}
    	int i;
        int j;
        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}


