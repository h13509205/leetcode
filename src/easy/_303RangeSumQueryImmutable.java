package easy;

public class _303RangeSumQueryImmutable {
	public int[] sums;
	public _303RangeSumQueryImmutable(int[] nums) {
		if(nums.length == 0) return;
        sums = new int[nums.length+1];
        sums[0] = 0;
        for(int i = 0; i < nums.length; i++) {
        	sums[i+1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1]-sums[i];
    }
}
