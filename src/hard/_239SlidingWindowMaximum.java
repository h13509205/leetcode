package hard;

import java.util.ArrayDeque;
import java.util.Arrays;

public class _239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums.length==0) return nums;
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        int[] result = new int[nums.length-k+1];
        int index = 0;
        for(; index < k; index++) {
        	if(queue.isEmpty()) {
        		queue.addLast(nums[index]);
        		continue;
        	}
        	while(!queue.isEmpty() && queue.peekLast() < nums[index]) {
        		queue.pollLast();
        	}
        	queue.addLast(nums[index]);
        }
        result[0] = queue.peekFirst();
        for(; index < nums.length; index++) {
        	int first = nums[index-k];
        	int last = nums[index];
        	if(first == queue.peekFirst()) {
        		queue.pollFirst();
        	}
        	while(!queue.isEmpty() && queue.peekLast() < last) {
        		queue.pollLast();
        	}
        	queue.addLast(last);
        	result[index-k+1] = queue.peekFirst();
        }
        return result;
    }
    
    //效率并不高，还是得计算最大的那个数处在什么位置
    public int[] anothersolution(int[] nums, int k) {
    	if(nums.length==0) return nums;
    	int[] result = new int[nums.length-k+1];
    	for(int i = 0; i < result.length; i++) {
    		int max = nums[i];
    		for(int j=i+1;j-i<k;j++){
    			max = Math.max(max, nums[j]);
    		}
    		result[i]=max;
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		_239SlidingWindowMaximum a = new _239SlidingWindowMaximum();
		int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
		System.out.println(Arrays.toString(a.anothersolution(nums, 3)));
	}
}
