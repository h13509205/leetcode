package easy;

import hard.TreeNode;

public class _270ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        double gap = Double.MAX_VALUE;
        int cur = 0;
        int closest = 0;
        while(root != null) {
        	cur = root.val;
        	double curGap = Math.abs(target - (double) cur);
        	if(gap > curGap) {
        		gap = curGap;
        		closest = cur;
        	}
        	if(target > (double) cur) {
        		root = root.right;
        	}else if(target < (double) cur) {
        		root = root.left;
        	}else{
        		return cur;
        	}
        }
        return closest;
    }
}
