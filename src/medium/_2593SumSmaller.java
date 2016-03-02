package medium;

import java.util.Arrays;

public class _2593SumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
    	Arrays.sort(nums);
    	int result = 0;
        for(int i = 0; i <= nums.length-3; i++) {
        	int start = i+1;
        	int end = nums.length-1;
        	int tempTarget = target - nums[i];
        	while(start < end) {
        		if(nums[start] + nums[end] < tempTarget) {
        			result = result + end - start;
        			start++;
        		}else{
        			end--;
        		}
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
		_2593SumSmaller a = new _2593SumSmaller();
		int[] nums = {3,1,0,-2};
		int target = 4;
		System.out.println(a.threeSumSmaller(nums, target));
	}
}
