/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
package bianchengti;

import java.util.Stack;

public class Solution05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        
        stack1.push(node);
        
        
    }
    
    public int pop() {
        int len=stack1.size();
        if(len!=0){
            for(int i=0;i<len;i++){
                int a=stack1.pop();
                stack2.add(a);
                //System.out.println(a);
               
            }
         /*   for(int i=0;i<len;i++){
               System.out.println(stack2.pop()); 
            }
           
           // System.out.println(b);
*/        }
        int b= stack2.pop();
       
        return b;
    
    }
    public static void main(String[] args){
        Solution05 s5=new Solution05();
       s5.push(0);
       s5.push(1);
       s5.push(2);
   for(int i=0;i<3;i++){
          System.out.println(s5.pop()); 
      }
      
     /* s5.pop();

      s5.pop();

      s5.pop();*/
       
        
        
    }
}