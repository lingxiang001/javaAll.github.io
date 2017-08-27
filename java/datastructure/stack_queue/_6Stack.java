package datastructure.stack_queue;
/**
 * 给一个栈进行升序（最大元素位于栈顶 ），只许用一个额外的栈存放数据，不得使用其他数据结构
 * 若是不限制空间，则用归并和快速排序的算法解决？
 * @author lingxiang
 *
 */
import java.util.Stack;
public class _6Stack {
    public static  void ascStack(Stack s1,Stack s2){
        while(!s1.isEmpty()){
            int tmp=(int) s1.pop();
            while(!s2.isEmpty() &&( (int)s2.peek())>tmp){
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }
    }
    public static void main(String[] args) {
       Stack s1=new Stack();
       s1.push(2);
       s1.push(6);
       s1.push(1);
       s1.push(3);
       Stack s2=new Stack();
       ascStack(s1, s2);
       System.out.println( s2.pop());
       System.out.println( s2.pop());
       System.out.println( s2.pop());
       System.out.println( s2.pop());
      
       
    }

}
