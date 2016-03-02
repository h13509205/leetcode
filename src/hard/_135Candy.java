package hard;

import java.util.Stack;

public class _135Candy {
	
	public int candy(int[] ratings) {
		int[] candy = new int[ratings.length];
		for(int i = 0; i < candy.length; i++) {
			candy[i] = 1;
		}
		for(int i = 1; i < candy.length; i++) {
			if(ratings[i] > ratings[i-1]) {
				candy[i] = candy[i-1]+1;
			}
		}
		for(int i = candy.length-1; i > 0; i--) {
			if(ratings[i-1] > ratings[i]) {
				candy[i-1] = Math.max(candy[i]+1, candy[i-1]);
			}
		}
		int result = 0;
        for(int i = 0; i < candy.length; i++) {
        	result+=candy[i];
        }
        return result;
	}
	
	
	//这样回头的次数太多了，要超时。
    public int candy2(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for(int i = 1; i < ratings.length; i++) {
        	if(ratings[i] == ratings[i-1]){
        		candy[i]=1;
        	}else if(ratings[i] > ratings[i-1]) {
        		candy[i] = candy[i-1]+1;
        	}else{
        		candy[i] = 1;
        		for(int j = i-1; j>=0; j--) {
        			if(ratings[j]>ratings[j+1] && candy[j]<=candy[j+1]) {
        				candy[j] = candy[j+1]+1;
        			}else {
        				break;
        			}
        		}
        	}
        }
        int result = 0;
        for(int i = 0; i < candy.length; i++) {
        	result+=candy[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
		_135Candy a = new _135Candy();
		int[] ratings = new int[]{1,2,1};
		System.out.println(a.candy(ratings));
	}
}
