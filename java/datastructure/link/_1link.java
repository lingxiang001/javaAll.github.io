package datastructure.link;

import java.util.Hashtable;



//移出未排序的链表中的重复节点
//进阶：如果不使用额外的缓存空间
public class _1link {
    //利用hashtable
    public static  void removeNode(Node node){
        if(node == null){
            return;
        }
        Hashtable table=new Hashtable();
        Node current=null;
        while(node != null){   
            if(table.containsKey(node.val)){
                current.next=node.next;
            }else{
                table.put(node.val, true);
                current=node;
            }
            node=node.next;
        } 
    }
    //进阶：
    public static void jinJie(Node node){
        if(node == null){
            return;
        }
        Node current=node;
       
        while(current != null){
            for(Node run=current;run.next!=null;run=run.next){
                if(run.next.val== current.val){
                    run.next=run.next.next;
                }
            }
            current =current.next;
        }
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
        Node list3=new Node(4);
        Node list4=new Node(4);
        Node list5=new Node(5);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        list5.next=null;
     //   removeNode(list1);
        jinJie(list1);
        print(list1);

    }

}
