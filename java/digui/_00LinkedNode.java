package digui;

public class _00LinkedNode {
    public static void link(Node node){
        if(node.next == null){
            System.out.println(node.val);
            return ;
        }
        link(node.next);
        System.out.println(node.val);
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
        link(list1);
    }

}
