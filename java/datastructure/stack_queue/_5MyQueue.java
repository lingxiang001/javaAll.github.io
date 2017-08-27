package datastructure.stack_queue;
import java.util.Stack;
/**
 * 实现一个MyQueue 类，该类用两个栈来实现队列
 * @author lingxiang
 *
 */
public class _5MyQueue<K> {
      Stack<K> newS=null;
      Stack<K> oldS=null;
      public _5MyQueue(){
          newS=new Stack();
          oldS=new Stack();
      }
      public void push(K val){
          newS.push(val);
      }
      public K pop(){
          newToOld(newS,oldS);
          return oldS.pop();
      }
      private void newToOld(Stack s1,Stack s2){
          if(s1 == null && s2 == null){
              return;
          }
          if(s2.isEmpty()){
              while(!s1.isEmpty()){
                  s2.push(s1.pop());
              }
          }
      }
      public static void main(String[] args){
          _5MyQueue my=new _5MyQueue();
          my.push("av");
          my.push("gv");
          System.out.println(my.pop());
      }

}
