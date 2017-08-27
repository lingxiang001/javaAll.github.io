package bianchengti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution16 {
         public ListNode Merge(ListNode list1,ListNode list2) {
             List<ListNode> l1=new ArrayList();
             
             while(list1 != null){
                 l1.add(list1);
                 list1=list1.next;
             }
             while(list2 != null){
                 l1.add(list2);
                 list2=list2.next;  
             }
             Collections.sort(l1, new Comparator<ListNode>(){

                @Override
                public int compare(ListNode o1, ListNode o2) {
                   return o1.val < o2.val?1:o1.val>o1.val?-1:0;
                }
             });
             ListNode head=l1.get(0);
             while(! l1.isEmpty()){
                 l1.get(0).next=l1.remove(0);
             }
             return head;
            
         
        
    }

}
