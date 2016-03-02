package medium;

import java.util.Arrays;

public class _280WiggleSort {
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
        	if(i%2 == 1) {
        		if(nums[i] < nums[i-1]) {
        			swap(nums, i, i-1);
        		}
        	}else if(i!=0 && nums[i]>nums[i-1]) {
        		swap(nums, i, i-1);
        	}
        }
        System.out.println(Arrays.toString(nums));
    }
    
    public void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
    public static void main(String[] args) {
		_280WiggleSort a = new _280WiggleSort();
		int[] nums = {3, 5, 2, 1, 6, 4};
		a.wiggleSort(nums);
	}
}
