package hard;

public class _41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
    	int len = nums.length;
    	if(len == 0) return 1;
    	int index = 0;
    	while(index < len) {
    		int num = nums[index];
    		if(num > len || num <= 0 || index == num-1 || nums[index] == nums[num-1]) {
    			index++;
    		}else {
    			swap(nums, index, num-1);
    		}
    	}
    	
    	for(int i = 0; i < len; i++) {
    		if(i != nums[i]-1) return i+1;
    	}
    	return len+1;
    }
    
    public void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
    public static void main(String[] args) {
		_41FirstMissingPositive a = new _41FirstMissingPositive();
		int[] nums = new int[]{1,1};
		System.out.println(a.firstMissingPositive(nums));
	}
}
