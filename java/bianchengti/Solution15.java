package bianchengti;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * @author lingxiang
 *
 */
public class Solution15 {
    public ListNode ReverseList(ListNode head) {
        int a=(int) System.currentTimeMillis();
        LinkedList<ListNode> list=new LinkedList<ListNode>();
        int i=0;
       
        ListNode root = head;
        while(root != null){
            list.addLast(root);
            root=root.next;
        }
       head.next=null;
        head=list.getLast();
        while(!list.isEmpty()){
            
          list.getLast().next= list.removeLast();
          
        }
       int b=(int) (System.currentTimeMillis()-a);
       System.out.println(b);
        return head;

    }
  
    public static void main(String[] args){
        Solution15 s15=new Solution15();
        ListNode list1=new ListNode(1);
        ListNode list2=new ListNode(2);
        ListNode list3=new ListNode(3);
        ListNode list4=new ListNode(4);
        ListNode list5=new ListNode(5);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        list5.next=null;
        for(int i=0;i<5;i++){
            System.out.println(s15.ReverseList(list1));
        }
        
    }

}
class ListNode2 {
    int val;
    ListNode2 next = null;

    ListNode2(int val) {
        this.val = val;
    }
}
