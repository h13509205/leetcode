package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _315CountofSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        Tuple[] tuple = new Tuple[nums.length];
        int[] smaller = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
        	tuple[i] = new Tuple(nums[i], i);
        }
        mergeSort(tuple, smaller);
        for(int i = 0; i < smaller.length; i++) {
        	result.add(smaller[i]);
        }
        return result;
    }
    
    //归并排序
    public Tuple[] mergeSort(Tuple[] tuple, int[] smaller) {
    	if(tuple.length<=1){
    		return tuple;
    	}
    	int mid = tuple.length/2;
    	Tuple[] left = mergeSort(Arrays.copyOfRange(tuple, 0, mid), smaller);
    	Tuple[] right = mergeSort(Arrays.copyOfRange(tuple, mid, tuple.length), smaller);
    	int i = 0;
    	int j = 0;
    	int k = 0;
    	while(i<left.length || j<right.length) {
    		if(j==right.length || i<left.length && left[i].val <= right[j].val) {
    			smaller[left[i].idx]+=j;
    			tuple[k++] = left[i++];
    		}else {
    			tuple[k++] = right[j++];
    		}
    	}
    	
    	return tuple;
    }
    
    public int binarySearch(int[] nums, int val, int start, int end){
    	if(start == end) return nums[start]>=val ? start:start+1;
    	int mid = (start+end)/2;
    	if(nums[mid] == val) {
    		return mid;
    	}else if(nums[mid] < val) {
    		return binarySearch(nums, val, mid+1, end);
    	}else{
    		return binarySearch(nums, val, start, mid);
    	}
    }
    
    public static void main(String[] args) {
    	_315CountofSmallerNumbersAfterSelf a = new _315CountofSmallerNumbersAfterSelf();
    	int[] nums = new int[]{1,2,5,6};
    	System.out.println(a.binarySearch(nums, 0, 0, nums.length-1));
	}
}

class Tuple {
	public int val;
	public int idx;
	public Tuple(int val, int idx){
		this.val = val;
		this.idx = idx;
	}
}
