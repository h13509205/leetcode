package medium;

import java.util.Stack;

import hard.TreeNode;

public class _285InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) {
        	return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root.val != p.val) {
        	if(root.val > p.val) {
        		stack.push(root);
        		root = root.left;
        	}else{
        		root = root.right;
        	}
        }
        if(root.right!=null) {
        	root = root.right;
        	while(root.left != null) {
        		root = root.left;
        	}
        	return root;
        }else if(!stack.isEmpty()) {
        	return stack.pop();
        }else{
        	return null;
        }
    }
    
    /*
     * 使用了迭代
     * 当p大于等于root的时候，他的后继肯定在root的右子树上；
     * 当p小于root的时候，如果他的后继不在左子树上，那么他的后继就是root。
     */
    public TreeNode successor(TreeNode root, TreeNode p) {
    	  if (root == null)
    	    return null;

    	  if (root.val <= p.val) {
    	    return successor(root.right, p);
    	  } else {
    	    TreeNode left = successor(root.left, p);
    	    return (left != null) ? left : root;
    	  }
    	}
}
