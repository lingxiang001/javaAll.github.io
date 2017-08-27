package bianchengti;

import java.util.ArrayList;
import java.util.List;

class ListNode {
      int val;
      ListNode next = null;

    ListNode(int val) {
         this.val = val;
      }
}

public class Solution03 {
     public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<Integer>();
         while(null !=listNode){
             list.add(0,listNode.val);
             listNode=listNode.next;
         }
        return list;
        
    }
     
     public static void main(String[] args){
         Solution03 s3=new Solution03();
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
             ArrayList<Integer> a=s3.printListFromTailToHead(list1);
             for(Integer i:a){
                 System.out.println(i);
             }
             
         
         
     }
     

}
