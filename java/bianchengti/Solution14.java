package bianchengti;

import java.util.ArrayList;
import java.util.List;


public class Solution14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        List<ListNode> list=new ArrayList<ListNode>();
        while(head != null){
            list.add(head);
            head=head.next;
            
        }
        return list.get(list.size()-k);
      
    }
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) { 
            this.val = val;
        }
    }

}
