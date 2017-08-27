package datastructure.link;
/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。这些数位式反向存放的，
 * 也就是个位排在链表的首部，编写函数，并用链表形式返回结果
 * 进阶 ：?
 * @author lingxiang
 *
 */
public class _5link {
   

    public static Node add(Node fir,Node sec){
       int a=turnInt(fir);
       int b=turnInt(sec);
       Node node=turnNode(a+b);
        return node;
        
    }
    
    private static Node turnNode(int num) {
        Node head=null;
        Node current=head;
        int i=0;
        while(true){
            int b=(int) (num/Math.pow(10, i++));
            if(b == 0){
                break;
            }
            int a=(int) (b%10);
            Node node=new Node(a);
            if(head == null){
                head=node;
                current=head;
            }
            current.next=node;
            current=current.next;
        }
        current.next=null;
        return head;
    }

    private static int turnInt(Node fir) {
        int num=0;
        int i=0;
        while( fir !=null){
          num+= fir.val*Math.pow(10, i++);
          fir=fir.next;
        }
        return num;
    }
    //递归的方式
    public static Node add2(Node fir,Node sec,int carry){
      if(fir ==null && sec== null && carry ==0 ){
          return null;
      }
      int value=carry;
      if(fir !=null){
          value=value+fir.val;
      }
      if(sec != null){
          value=value+sec.val;
      }
      Node result=new Node(0);
      Node more=add2(fir==null?null:fir.next, sec==null ? null : sec.next,value>=10?1:0);
      result.val=value%10;
      result.next=more;
      return result;
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
        Node list3=new Node(4);
        Node list4=new Node(1);
        Node list5=new Node(1);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        list5.next=null;
        Node head=add2(list3, list3,0);
        print(head);
       
    }

}
