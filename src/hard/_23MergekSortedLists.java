package hard;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 可以用优先队列来做
 */
public class _23MergekSortedLists {
    public ListNode mergeKListsTimeLimitExceeded(ListNode[] lists) {
        ListNode preHead = new ListNode(-1);
        ListNode temp = preHead;
        int idx = -1;
        while((idx = min(lists)) != -1) {
        	temp.next = lists[idx];
        	temp = temp.next;
        	lists[idx] = lists[idx].next;
        }
        return preHead.next;
    }
    
    //用这种方式每次都要计算最小值，重复计算的次数太多，可以减少
    public int min(ListNode[] lists){
    	int idx = -1;
    	int minValue = Integer.MAX_VALUE;
    	for(int i = 0; i < lists.length; i++) {
    		if(lists[i] != null && lists[i].val < minValue) {
    			minValue = lists[i].val;
    			idx = i;
    		}
    	}
    	return idx;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
    	Queue<ListNode> queue = new ArrayDeque<>();
    	for(int i = 0; i < lists.length; i++) {
    		if(lists[i] != null)
    			queue.add(lists[i]);
    	}
    	while(queue.size() >= 2) {
    		ListNode n = helper(queue.poll(), queue.poll());
    		queue.add(n);
    	}
    	return queue.size()==0?null:queue.poll();
    }
    
    public ListNode helper(ListNode list1, ListNode list2) {
    	ListNode preHead = new ListNode(-1);
        ListNode temp = preHead;
        while(list1 != null && list2 != null) {
        	if(list1.val <= list2.val) {
        		temp.next = list1;
        		temp = temp.next;
        		list1 = list1.next;
        	}else {
        		temp.next = list2;
        		temp = temp.next;
        		list2 = list2.next;
        	}
        }
        if(list1 != null) {
        	temp.next = list1;
        }
        if(list2 != null) {
        	temp.next = list2;
        }
        return preHead.next;
    }
    
    public static void main(String[] args) {
		_23MergekSortedLists a = new _23MergekSortedLists();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(0);
		ListNode[] lists = new ListNode[2];
		lists[0] = n1;
		lists[1] = n2;
		System.out.println(a.mergeKLists(lists));
	}
}
