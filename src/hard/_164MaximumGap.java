package hard;

import java.util.Arrays;

public class _164MaximumGap {
	public static int[] n = new int[]{1, 1, 10, 100, 1000, 10000, 100000, 1000000,
		10000000, 100000000, 1000000000};
	//线性时间排序方法:
	//1.计数排序 2.基数排序 3.桶排序(基数排序又称桶排序)
	/*
	 * 1.计数排序是一个非基于比较的排序算法。
	 * 它的优势在于在对一定范围内的整数排序时，它的复杂度为Ο(n+k)（其中k是整数的范围），快于任何比较排序算法。
	 * 如果整数的个数较少，但是max和min的差值过大，那么导致额外空间的增多，不太划算。
	 * 计数排序的基本思想是对于给定的输入序列中的每一个元素x，确定该序列中值小于x的元素的个数。
	 * 一旦有了这个信息，就可以将x直接存放到最终的输出序列的正确位置上。
	 * 
	 */
    public int maximumGap(int[] nums) {
    	if(nums.length<2) return 0;
        int[] newnums = radixSortLSD(nums, n.length-1);
        int max = Integer.MIN_VALUE;
        for(int i=1; i<newnums.length; i++) {
        	max = Math.max(max, newnums[i]-newnums[i-1]);
        }
        return max;
    }
    
    //在leetcode里，会memory exceeded
    public int[] countingSort(int[] nums) {
    	int[] result = new int[nums.length];
    	int max = nums[0];
    	int min = nums[0];
    	for(int i:nums) {
    		if(i>max) {
    			max = i;
    		}
    		if(i<min) {
    			min = i;
    		}
    	}
    	int[] k = new int[max-min+1];
    	for(int i=0; i<nums.length; i++) {
    		k[nums[i]-min]++;
    	}
    	for(int i=1; i<k.length; i++) {
    		k[i] = k[i] + k[i-1];
    	}
    	//从后往前，所以它是稳定排序
    	for(int i=result.length-1; i>=0; i--) {
    		int pos = k[nums[i]-min]-1;
    		k[nums[i]-min]--;
    		result[pos] = nums[i];
    	}
    	return result;
    }
    
    //最高位优先(Most Significant Digit first)
    //个人感觉没有LSD好用
    public int[] radixSortMSD(int[] nums, int d) {
    	return radixSortLSD(nums, d);
    }
    
    //最低位优先(Least Significant digit first)
    //也是稳定排序
    public int[] radixSortLSD(int[] nums, int d) {
    	int[] result = new int[nums.length];
    	for(int i=0; i<nums.length; i++) {
    		result[i] = nums[i];
    	}
    	int[] count  = new int[10];
    	int[][] bucket = new int[10][nums.length];
    	for(int i=1; i<=d; i++) {
    		for(int j=0; j<result.length; j++) {
    			int digit = getDigit(result[j], i);
    			bucket[digit][count[digit]] = result[j];
    			count[digit]++;
    		}
    		int index = 0;
    		for(int k=0; k<10; k++) {
    			for(int j=0; j<count[k]; j++) {
    				result[index] = bucket[k][j];
    				index++;
    			}
    		}
    		count = new int[10];
    	}
    	return result;
    }
    
    public int getDigit(int num, int d) {
    	if(num < n[d]) return 0;
    	return (num / n[d]) % 10;
    }
    
    public static void main(String[] args) {
    	_164MaximumGap a = new _164MaximumGap();
    	int[] nums = new int[]{50, 123, 543, 187, 50, 30, 0, 2, 11, 100};
    	System.out.println(Arrays.toString(a.radixSortLSD(nums, 3)));
	}
}
