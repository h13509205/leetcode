package hard;

public class _45JumpGame2 {
    public int jump(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] result = new int[len];
        result[0] = 0;
        int index = 1;
        int max = nums[0];
        int tempMax = max;
        int step = 1;
        while(index < len) {
        	for(; index <= max && index < len; index++) {
        		tempMax = Math.max(tempMax, index+nums[index]);
        		result[index] = step;
        	}
        	step++;
        	max = tempMax;
        }
        return result[len-1];
    }
    
    public static void main(String[] args) {
		_45JumpGame2 a = new _45JumpGame2();
		int[] nums = new int[]{2,3,1,1,4};
		System.out.println(a.jump(nums));
	}
}
