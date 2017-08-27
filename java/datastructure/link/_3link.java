package datastructure.link;
//删除单链表的某个节点，假定你只能访问该结点
public class _3link {
    public static  void removeNode(Node node){
        if(node == null || node.next == null){
            return;
        }
      
      node.val=node.next.val;
       node.next=node.next.next;
       
    }
    public static  void print(Node node){
        while(node !=null){
            System.out.println(node.val);
            node=node.next;
        }
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
        removeNode(list1);
        print(list1);

    }

}
