package datastructure.link;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 检查链表是否回文
 * @author lingxiang
 *
 */
public class _7link {
    //空间和时间复杂度都高
    public static boolean isHuiwen(Node node){
        ArrayList list1=new ArrayList();
        ArrayList list2=new ArrayList();
        while(node != null){
            list1.add(node.val);
            list2.add(0, node.val);;
            node=node.next;
        }
        return list1.equals(list2);
        
    }
    public static boolean isPalindrome(Node node){
        if(node == null){
            return false;
        }
        Stack<Node> s=new Stack();
        Node fre=node;
        Node sec=node;
        while(sec != null && sec.next != null){
            sec=sec.next.next;
            s.push(fre);
            fre=fre.next;
        }
        //链表为奇数个
        if(sec != null){
            fre=fre.next;
        }
        while(fre != null){
            Node help=s.pop();
            if(help.val != fre.val){
                return false;
            }
            fre=fre.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node list1=new Node(2);
        Node list2=new Node(6);
        Node list3=new Node(4);
        Node list4=new Node(6);
        Node list5=new Node(2);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        list5.next=null;
        boolean b=isHuiwen(list1);
        b=isPalindrome(list1);
        System.out.println(b);
    }

}
