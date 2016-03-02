package hard;

public class _25ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
        	len++;
        	temp = temp.next;
        }
        if(k > len) return head; 
        ListNode newHead = new ListNode(0);
        for (int i = 0; i < k; i++){
        	temp = head;
        	head = head.next;
        	temp.next = newHead.next;
        	newHead.next=temp;
        }
        temp = newHead;
        while (temp.next!=null){
        	temp = temp.next;
        }
        temp.next = reverseKGroup(head, k);
        return newHead.next;
    }
    
    //比我的方法优化了一点，我的是先计算ListNode的总长度，而他先从k里面扣，这样总共可以计算1次长度，而我得计算好几次的长度
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup2(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part, 
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group: 
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list 
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }

    
    public static void main(String[] args) {
    	_25ReverseNodesInKGroup a = new _25ReverseNodesInKGroup();
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	ListNode n5 = new ListNode(5);
    	n1.next=n2;
    	n2.next=n3;
    	n3.next=n4;
    	n4.next=n5;
    	a.reverseKGroup2(n1, 2);
	}
}
