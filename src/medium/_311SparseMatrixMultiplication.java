package medium;

import java.util.HashMap;

public class _311SparseMatrixMultiplication {
	//最初的版本，比较low
    public int[][] multiply1(int[][] A, int[][] B) {
        int rowA = A.length;
        int columnA = A[0].length;
        int rowB = B.length;
        int columnB = B[0].length;
        int[][] result = new int[rowA][columnB];
        for(int i = 0; i < rowA; i++) {
        	for(int j = 0; j < columnB; j++) {
        		int temp = 0;
        		for(int k = 0; k < columnA; k++) {
        			temp = temp + A[i][k] * B[k][j];
        		}
        		result[i][j] = temp;
        	}
        }
        return result;
    }
    
    //improved one,增加了判断是否为0，复杂度和上面的一样，但是可以通过了
    public int[][] multiply2(int[][] A, int[][] B) {
    	int rowA = A.length;
        int columnA = A[0].length;
        int rowB = B.length;
        int columnB = B[0].length;
        int[][] result = new int[rowA][columnB];
        for(int i = 0; i < rowA; i++) {
        	for(int j = 0; j < columnA; j++) {
        		if(A[i][j] != 0) {
        			for(int k = 0; k < columnB; k++) {
        				if(B[j][k] != 0) {
        					result[i][k] += A[i][j] * B[j][k];
        				}
        			}
        		}	
        	}
        }
        return result;
    }
    
    public int[][] multiply(int[][] A, int[][] B) {
    	int rowA = A.length;
        int columnA = A[0].length;
        int rowB = B.length;
        int columnB = B[0].length;
        int[][] result = new int[rowA][columnB];
        //HashMap<cloumn, value>
        HashMap<Integer, Integer>[] mapA = new HashMap[rowA];
        HashMap<Integer, Integer>[] mapB = new HashMap[rowB];
        for(int i = 0; i < rowA; i++) {
        	mapA[i] = new HashMap<>();
        	for(int j = 0; j < columnA; j++) {
        		if(A[i][j] != 0) {
        			mapA[i].put(j, A[i][j]);
        		}
        	}
        }
        for(int i = 0; i < rowB; i++) {
        	mapB[i] = new HashMap<>();
        	for(int j = 0; j < columnB; j++) {
        		if(B[i][j] != 0) {
        			mapB[i].put(j, B[i][j]);
        		}
        	}
        }
        
        for(int i = 0; i < rowA; i++) {
        	for(int keyA : mapA[i].keySet()) {
        		for(int keyB : mapB[keyA].keySet()) {
        			result[i][keyB] += mapA[i].get(keyA) * mapB[keyA].get(keyB);
        		}
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
		_311SparseMatrixMultiplication a = new _311SparseMatrixMultiplication();
		int[][] A = new int[][]{{1,0,0},{-1,0,3}};
		int[][] B = new int[][]{{7,0,0,0},{0,0,0,0},{0,0,0,1}};
		System.out.println(a.multiply(A, B));
	}
    
}
