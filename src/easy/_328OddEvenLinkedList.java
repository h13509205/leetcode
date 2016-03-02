package easy;

import hard.ListNode;

public class _328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
    	if(head == null) return head;
    	ListNode anotherHead = head;
        ListNode end = head;
        int len = 1;
        while(end.next != null) {
        	end = end.next;
        	len++;
        }
        if(len <= 2) return head;
        int count = len/2;
        for(int i = 0; i < count; i++) {
        	ListNode temp = head.next;
        	head.next = temp.next;
        	head = head.next;
        	end.next = temp;
        	end = temp;
        	temp.next = null;
        }
        return anotherHead;
    }
}
