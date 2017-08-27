package datastructure.link;

import java.util.ArrayList;

//以给定的值x 为基准将链表分为两部分，所有小于x的结点排在大于或等于x的前面
public class _4link {
    //空间复杂度为O(n),时间复杂度为O(n)
    public  static Node function(Node node,int x){
        Node head=null;
        ArrayList list=new ArrayList();
        while(node !=null){
            if(node.val<x){
               list.add(0,node);
            }else{
               list.add(node);
            }
            node=node.next;
        }
        head=(Node) list.get(0);
        Node current=head;
        for(int i=1;i<list.size();i++){
           current.next=(Node) list.get(i);
           current=current.next;
        }
        current.next=null;
        System.out.println(list);
        return head;
    } 
    //空间复杂度为O(1),时间复杂度为O(n)
    
    public static Node function2(Node node,int x){
        if(node==null){
            return null;
        }
        Node head=null;
        Node end=null;
        while(node !=null){
            Node next=node.next;
            if(node.val<x){
                    node.next=head;
                    head=node;
            }else{
                node.next=end;
                end=node;
            }
            node=next;
        }
        if(head == null){
            return end;
        }
        Node current=head;
        while(head.next !=null){
            head=head.next;
        }
        head.next=end;
        return current;
    }
    public static  void print(Node node){
        while(node !=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
    public static void main(String[] args) {
        Node list1=new Node(6);
        Node list2=new Node(2);
        Node list3=new Node(3);
        Node list4=new Node(4);
        Node list5=new Node(1);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        list5.next=null;
        Node node=function2(list1, 4);
        print(node);

    }

}
