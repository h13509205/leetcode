package medium;

import hard.TreeNode;

public class _250CountUnivalueSubTrees {
	public int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return count;
    }
    public boolean helper(TreeNode root) {
    	if(root == null) return true;
    	boolean left = helper(root.left);
    	boolean right = helper(root.right);
    	boolean flag = true;
    	if(!left || !right) {
    		return false;
    	}
    	if(root.left != null) {
    		flag = flag && root.val==root.left.val;
    	}
    	if(root.right != null) {
    		flag = flag && root.val==root.right.val;
    	}
    	if(flag) count++;
    	return flag;
    }
}
