package medium;

import java.util.Arrays;

public class _167TwoSum2InputArrayIsSorted {
	//high：寻找比target小，但是其右边比target大的坐标
	//low：寻找比target大，但是左边比target小的坐标
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        while(low < high) {
        	if((numbers[low] + numbers[high]) > target) {
        		int start = low+1;
        		int end = high;
        		while(start < end) {
        			int mid = (start+end)/2;
        			if((numbers[low] + numbers[mid]) > target) {
        				end = mid-1;
        			}else if((numbers[low] + numbers[mid]) < target) {
        				start = mid+1;
        			}else{
        				end = mid;
        				break;
        			}
        		}
        		if((numbers[low] + numbers[end]) > target) end--;
        		high = end;
        	}else if((numbers[low] + numbers[high]) < target) {
        		int start = low;
        		int end = high-1;
        		while(start < end) {
        			int mid = (start+end)/2;
        			if((numbers[high] + numbers[mid]) > target) {
        				end = mid-1;
        			}else if((numbers[high] + numbers[mid]) < target) {
        				start = mid+1;
        			}else{
        				end = mid;
        				break;
        			}
        		}
        		if((numbers[end] + numbers[high]) < target) end++;
        		low = end;
        	}else{
        		break;
        	}
        }
        return new int[]{low+1, high+1};
    }
    
    public static void main(String[] args) {
		_167TwoSum2InputArrayIsSorted a = new _167TwoSum2InputArrayIsSorted();
		int[] numbers = new int[]{3,24,50,79,88,150,345};
		int target = 200;
		System.out.println(Arrays.toString(a.twoSum(numbers, target)));
	}
}
