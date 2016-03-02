package medium;

import hard.TreeNode;

public class _298BinaryTreeLongestConsecutiveSequence {
	int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        helper(root, 1);
        return max;
    }
    
    public void helper(TreeNode root, int num) {
    	max = Math.max(max, num);
    	if(root.left != null) {
    		if(root.val+1 == root.left.val) {
    			helper(root.left, num+1);
    		}else{
    			helper(root.left, 1);
    		}
    	}
    	if(root.right != null) {
    		if(root.val+1 == root.right.val) {
    			helper(root.right, num+1);
    		}else{
    			helper(root.right, 1);
    		}
    	}
    }
}
