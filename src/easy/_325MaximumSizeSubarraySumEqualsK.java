package easy;

import java.util.HashMap;

public class _325MaximumSizeSubarraySumEqualsK {
	public int maxSubArrayLen(int[] nums, int k) {
	    int sum = 0;
	    int max = 0;
	    HashMap<Integer, Integer> map = new HashMap<>();
	    for(int i = 0; i < nums.length; i++) {
	    	sum = sum + nums[i];
	    	if(sum == k) {
	    		max = i + 1;
	    	}else if(map.containsKey(sum-k)) {
	    		max = Math.max(max, i - map.get(sum-k));
	    	}
	    	if(!map.containsKey(sum)) {
	    		map.put(sum, i);
	    	}
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		_325MaximumSizeSubarraySumEqualsK a = new _325MaximumSizeSubarraySumEqualsK();
		int[] nums = new int[]{-2, -1, 2, 1};
		int k = 1;
		System.out.println(a.maxSubArrayLen(nums, k));
	}
}
