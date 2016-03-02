package hard;

import java.util.ArrayList;
import java.util.List;

public class _124BinaryTreeMaximumSum {
	public int maxValue = Integer.MIN_VALUE;
	
    public int maxPathSum(TreeNode root) {
    	if(root == null) return 0;
        helper(root);
        return maxValue;
    }
    
    public int helper(TreeNode root) {
    	if(root == null) return 0;
    	int maxLeft = Math.max(0, helper(root.left));
    	int maxRight = Math.max(0, helper(root.right));
    	maxValue = Math.max(maxValue, maxLeft+maxRight+root.val);
    	return Math.max(maxLeft, maxRight)+root.val;
    }
}
