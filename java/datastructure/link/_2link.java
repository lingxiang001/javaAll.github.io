package datastructure.link;

import java.util.LinkedList;



//实现一个算法，找出单链表中倒数第k个结点
public class _2link {
    private static Node[] list=new Node[100];
    private static int index;
    //时间和空间效率都不高
    public static  void topK(Node node,int k){
       if(node == null){
            return;
        }
    int index=0;
     while(node !=null){
         list[index++]=node;
         node=node.next;
     }
     System.out.println(list[index-k].val);
      
    }
    //空间复杂度为O(1),时间复杂度是O(n)
    public static int topK2(Node node,int k){
       
        if(node ==null || k<=0){
            return -1;
        }
        Node fir=node;
        Node sec=node;
        int i=1;
        while(i<k){
            fir=fir.next;
            i++;
        }
        System.out.println(fir.val);
        while(fir.next != null){
            sec=sec.next;
            fir=fir.next;
        }
        return sec.val;
    }
    //递归的方式
    public static Node topK3(Node node,int k){
        if(node == null || k<=0){
            return null;
        }
        
        Node nodeT=topK3(node.next,k);
        index=index+1;
        if(index==k){
            return node;
        }
        
        return nodeT;
        
    }
    public static void main(String[] args) {
        Node list1=new Node(1);
        Node list2=new Node(2);
        Node list3=new Node(3);
        Node list4=new Node(4);
        Node list5=new Node(5);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        list5.next=null;
        int a=topK2(list1,0);
        Node node=topK3(list1,0);
        System.out.println(node.val);
    }

}
