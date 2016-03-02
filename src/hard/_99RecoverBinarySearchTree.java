package hard;

public class _99RecoverBinarySearchTree {
	public TreeNode pre = null;
	public TreeNode cur = null;
	
	public TreeNode swap1 = null;
	public TreeNode swap2 = null;
	
	//in-order traverse
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = temp;
    }
    
    public void traverse(TreeNode root) {
    	if(root == null) return;
    	traverse(root.left);
    	
    	if(cur == null) {
    		cur = root;
    	}else {
    		pre = cur;
    		cur = root;
    	}
    	
    	if(pre != null) {
    		if(cur.val < pre.val && swap1 == null) {
    			swap1 = pre;
    			swap2 = cur;
    		}else if(cur.val < pre.val){
    			swap2 = cur;
    		}
    	}
    	
    	traverse(root.right);
    }
    
    public static void main(String[] args) {
		_99RecoverBinarySearchTree a = new _99RecoverBinarySearchTree();
		TreeNode t1 = new TreeNode(0);
		TreeNode t2 = new TreeNode(1);
		t1.left=t2;
		a.recoverTree(t1);
	}
}
