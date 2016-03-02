package medium;

import java.util.Stack;

public class _255VerifyPreorderSequenceinBinarySearchTree {
	//由于DFS要每次都确定每边树是否在最大最小中间，复杂度应该是O(nlogn)
    public boolean verifyPreorderDFS(int[] preorder) {
    	int len = preorder.length;
        if(len == 0) return true;
        return helper(preorder, 0, len-1, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    public boolean helper(int[] preorder, int start, int end, int max, int min) {
    	if(start >= end) {
    		return true;
    	}
    	int partition = end+1;
    	boolean flag = true;
    	for(int i = start+1; i <= end; i++) {
    		if(preorder[i] >= max || preorder[i] <= min) {
    			return false;
    		}
    		if(flag && preorder[i] > preorder[start]) {
    			partition = i;
    			flag = false;
    		}
    	}
    	return helper(preorder, start+1, partition-1, preorder[start], min) && helper(preorder, partition, end, max, preorder[start]);
    }
    
    //使用stack模拟preorder的过程，时间复杂度为O(n)
    public boolean verifyPreorder(int[] preorder) {
    	Stack<Integer> stack = new Stack<>();
    	int min = Integer.MIN_VALUE;
    	for(int i = 0; i < preorder.length; i++) {
    		if(preorder[i] <= min) {
    			return false;
    		}
    		if(stack.isEmpty() || preorder[i] < stack.peek()) {
    			stack.push(preorder[i]);
    		}else if(stack.peek() < preorder[i]) {
    			min = stack.pop();
    			i--;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		_255VerifyPreorderSequenceinBinarySearchTree a = new _255VerifyPreorderSequenceinBinarySearchTree();
		int[] preorder = {4,2,3,1};
		System.out.println(a.verifyPreorder(preorder));
	}
}
