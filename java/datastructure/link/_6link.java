package datastructure.link;
/**
 * 给定一个有环链表，实现一个算法返回环路的开头节点
 * @author lingxiang
 *
 */
public class _6link {
    public static Node funtion(Node node){
        if(node == null){
            return null;
        }
        Node fre=node;
        Node sec=node;
        while(fre != null && sec != null){
            fre=fre.next;
            sec=sec.next.next;
            if(fre == sec){
                break;
            }
        }
        if(sec == null || sec.next == null){
            return null;
        }
        fre=node;
        while(fre != sec){
            fre=fre.next;
            sec=sec.next;
        }
        return fre;
    }
   
    public static void main(String[] args) {
        Node list1=new Node(2);
        Node list2=new Node(9);
        Node list3=new Node(4);
        Node list4=new Node(6);
        Node list5=new Node(1);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        list5.next=null;
        Node node=funtion(list1);
        System.out.println(node.val);

    }

}
