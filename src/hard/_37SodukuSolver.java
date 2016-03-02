package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


//https://leetcode.com/discuss/34552/singapore-prime-minister-hsien-loongs-sudoku-solver-code-runs  
//别人的1ms解法，我的是58ms
public class _37SodukuSolver {
	public boolean flag = false;
    public void solveSudoku(char[][] board) {
        HashSet[][][] hashset = new HashSet[3][9][9]; //第一行放的是横的，第二行放的是竖的，第三行放的是3*3的
        List<HashSet> hashlist1 = new ArrayList<HashSet>();
        List<HashSet> hashlist2 = new ArrayList<HashSet>();
        List<HashSet> hashlist3 = new ArrayList<HashSet>();
        for(int i = 0; i < 9; i++) {
        	hashlist1.add(new HashSet());
        	hashlist2.add(new HashSet());
        	hashlist3.add(new HashSet());
        }
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		if(board[i][j] != '.'){
        			int which = whichHashTable(i, j);
        			hashlist1.get(i).add(board[i][j]);
        			hashlist2.get(j).add(board[i][j]);
        			hashlist3.get(which).add(board[i][j]);
        		}        		
        	}
        }
        helper(hashlist1, hashlist2, hashlist3, board, 0); 
        //System.out.println(board);
    }
    
    public void helper(List<HashSet> hashlist1, List<HashSet> hashlist2, List<HashSet> hashlist3, char[][] board, int k) {
    	if(k == 81) {
    		flag = true;
    		return;
    	}
    	int i = k / 9;
    	int j = k % 9;
    	int which = whichHashTable(i, j);
    	if(board[i][j] == '.') {
    		for(int num = 1; num <= 9; num++) {
    			char charNum = (char) ('1'-1+num);
    			if(!hashlist1.get(i).contains(charNum) && !hashlist2.get(j).contains(charNum) && !hashlist3.get(which).contains(charNum)) {
    				board[i][j] = charNum;
    				hashlist1.get(i).add(charNum);
    				hashlist2.get(j).add(charNum);
    				hashlist3.get(which).add(charNum);
    				
    				helper(hashlist1, hashlist2, hashlist3, board, k+1);
    				if(flag) return;
    				
    				board[i][j] = '.';
    				hashlist1.get(i).remove(charNum);
    				hashlist2.get(j).remove(charNum);
    				hashlist3.get(which).remove(charNum);
    			}
    		}
    	}else{
    		helper(hashlist1, hashlist2, hashlist3, board, k+1);
    		if(flag) return;
    	}
    }
    
    public int whichHashTable(int i, int j) {
    	if(i < 3) {
    		if(j < 3) {
    			return 0;
    		}else if(j < 6) {
    			return 1;
    		}else{
    			return 2;
    		}
    	}else if(i < 6) {
    		if(j < 3) {
    			return 3;
    		}else if(j < 6) {
    			return 4;
    		}else{
    			return 5;
    		}
    	}else {
    		if(j < 3) {
    			return 6;
    		}else if(j < 6) {
    			return 7;
    		}else{
    			return 8;
    		}
    	}
    }
    
    public static void main(String[] args) {
		_37SodukuSolver a = new _37SodukuSolver();
		char[][] board = new char[][]{{'.','.','9','7','4','8','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'.','2','.','1','.','9','.','.','.'},
				{'.','.','7','.','.','.','2','4','.'},
				{'.','6','4','.','1','.','5','9','.'},
				{'.','9','8','.','.','.','3','.','.'},
				{'.','.','.','8','.','3','.','2','.'},
				{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','2','7','5','9','.','.'}};
		a.solveSudoku(board);
	}
}
