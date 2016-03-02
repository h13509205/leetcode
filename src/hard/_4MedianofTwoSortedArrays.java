package hard;

import java.util.Arrays;

public class _4MedianofTwoSortedArrays {
    public double findMedianSortedArraysStupid(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length+nums2.length];
        int idx = 0;
    	for(int i = 0; i < nums1.length; i++,idx++) {
    		nums[idx] = nums1[i];
    	}
    	for(int i = 0; i < nums2.length; i++,idx++) {
    		nums[idx] = nums2[i];
    	}
    	Arrays.sort(nums);
    	if(nums.length%2 == 1) {
    		return (double) nums[nums.length/2];
    	}else{
    		return ((double) nums[nums.length/2] + (double) nums[nums.length/2-1])/2;
    	}
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
    }
}
