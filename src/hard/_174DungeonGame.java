package hard;

public class _174DungeonGame {
	//从前向后推导为什么错误，而从后行前推导则是正确的
    public int calculateMinimumHPUpsideDown(int[][] dungeon) {
    	int row = dungeon.length;
    	int column = dungeon[0].length;
        int[][] path = new int[row][column];
        int[][] hp = new int[row][column];
        path[0][0] = dungeon[0][0];
        hp[0][0] = -dungeon[0][0];
        for(int i = 1; i < column; i++) {
        	path[0][i] = path[0][i-1] + dungeon[0][i];
        	hp[0][i] = Math.max(hp[0][i-1], -path[0][i]);
        }
        for(int j = 1; j < row; j++) {
        	path[j][0] = path[j-1][0] +dungeon[j][0];
        	hp[j][0] = Math.max(hp[j-1][0], -path[j][0]);
        }
        
        for(int i = 1; i < row; i++) {
        	for(int j = 1; j < column; j++) {
        		int pathDown = path[i-1][j] + dungeon[i][j];
        		int pathRight = path[i][j-1] + dungeon[i][j];
        		int hpDown = Math.max(hp[i-1][j], -pathDown);
        		int hpRight = Math.max(hp[i][j-1], -pathRight);
        		if(hpDown > hpRight) {
        			path[i][j] = pathRight;
        			hp[i][j] = hpRight;
        		}else if(hpDown < hpRight) {
        			path[i][j] = pathDown;
        			hp[i][j] = hpDown;
        		}else{
        			path[i][j] = Math.max(pathDown, pathRight);
        			hp[i][j] = hpDown;
        		}
        	}
        }
        return Math.max(0, hp[row-1][column-1]) + 1;
    }
    
    /*
     * 从后向前计算，保证骑士的血至少有一格，并且这个血足够到达公主
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int column = dungeon[0].length;
        int[][] hp = new int[row][column];
        hp[row-1][column-1] = 1;
        for(int i = row-2; i >= 0; i--) {
        	hp[i][column-1] = Math.max(1, hp[i+1][column-1]-dungeon[i+1][column-1]);
        }
        for(int j = column-2; j >= 0; j--) {
        	hp[row-1][j] = Math.max(1, hp[row-1][j+1]-dungeon[row-1][j+1]);
        }
        for(int i = row-2; i >= 0; i--) {
        	for(int j = column-2; j >= 0; j--) {
        		hp[i][j] = Math.min(Math.max(1,hp[i+1][j]-dungeon[i+1][j]), Math.max(1,hp[i][j+1]-dungeon[i][j+1]));
        	}
        }
        return Math.max(1, hp[0][0]-dungeon[0][0]);
    }
    
    
    public static void main(String[] args) {
		_174DungeonGame a = new _174DungeonGame();
		int[][] dungeon = new int[][]{{1,-3,3},{0,-2,0},{-3,-3,-3}};
		System.out.println(a.calculateMinimumHP(dungeon));
	}
}
