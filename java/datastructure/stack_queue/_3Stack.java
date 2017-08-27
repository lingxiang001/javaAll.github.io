 package datastructure.stack_queue;

import java.util.ArrayList;
/**
 * 设计多个栈，一个栈满时 新建一个栈；
 * 进阶：？
 * 
 * @author lingxiang
 *
 */
public class _3Stack {
    ArrayList<Stack> stacks=new ArrayList();
    public int capacity;
    public int size;
    
    public _3Stack(int ca){
        this.capacity=ca;
        stacks.add(new Stack(this.capacity));
       
    }
    public void push(int val){
        
        Stack last=getLastStack();
        if(last == null){
            Stack s=new Stack(capacity);
            stacks.add(s); 
            last=s;
        }
        last.push(val);
        //检查存放一个数据后栈是否满，新建一个栈
        if(last.isFull()){
            Stack s=new Stack(capacity);
            stacks.add(s);
        }       
    }
    public int pop(){
        Stack last=getLastStack();
        if(last == null){
            return Integer.MIN_VALUE;
        }
        
        int val=last.pop();
        
        if(last.isEmpty()){
            stacks.remove(stacks.size()-1);
        }
        return val;
    }
    private Stack getLastStack() { 
        if(stacks.size() <= 0){
            return null;
        }
        return stacks.get(stacks.size()-1);
    }
    public static void main(String[] args) {
        _3Stack st=new _3Stack(3);
        st.push(1);
        
        st.push(2);
      
        st.push(3);
      
        st.push(4);
        st.push(5);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
       
      
      

    }

}
class Stack{
    private int capacity;
    private Node top,bottom;
     int size=0;
    public Stack(int capacity){
        this.capacity=capacity;
    }
    public boolean isFull(){
        return this.capacity==size;
    }
    public void join(Node above,Node below){
        if(below !=null){
           below.above=above;
        }
        if(above !=null){
            above.below=below;
        }
    }
    
    public boolean push(int v){
        if(isFull()){
            return false;
        }
        size++;
        Node n=new Node(v);
        if(size==1){
            bottom=n;
        }
        join(n,top);
        top=n;
        return true;
    }
    
    public int pop(){
        if(isEmpty()){
            return Integer.MAX_VALUE;
        }
        Node t=top;
        top=top.below;
        size--;
        return t.val;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public int removeButtom(){
        Node b=bottom;
        bottom=bottom.above;
        if(bottom!=null){
            bottom.below=null;
        }
        size--;
        return b.val;
    }
}
class Node{
    Node above;
    Node below;
    int val;
    public Node(int val){
        this.val=val;
    }
}
