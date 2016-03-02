package medium;

public class _286WallsandGates {
    public void wallsAndGates(int[][] rooms) {
        int row = rooms.length;
        int column = rooms[0].length;
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < column; j++) {
        		if(rooms[i][j] == 0) {
        			helper(rooms, i-1, j, 1);
        			helper(rooms, i+1, j, 1);
        			helper(rooms, i, j-1, 1);
        			helper(rooms, i, j+1, 1);
        		}
        	}
        }
    }
    
    public void helper(int[][] rooms, int i, int j, int num) {
    	if(i >= rooms.length || i < 0 || j < 0 || j >= rooms[0].length || rooms[i][j] < num) {
    		return;
    	}else{
    		rooms[i][j] = num;
    		helper(rooms, i-1, j, num+1);
			helper(rooms, i+1, j, num+1);
			helper(rooms, i, j-1, num+1);
			helper(rooms, i, j+1, num+1);
    	}
    }
    
    public static void main(String[] args) {
		_286WallsandGates a = new _286WallsandGates();
		int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
		a.wallsAndGates(rooms);
	}
}
