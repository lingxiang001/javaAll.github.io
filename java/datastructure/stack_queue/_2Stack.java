package datastructure.stack_queue;

import java.util.Stack;

public class _2Stack extends Stack<Integer> {
    Stack  sta=null;
    public _2Stack() {
        super();
        sta =new  Stack ();
    }

    @Override
    public Integer push(Integer item) {
       if(item<=min()){
            return (Integer) sta.push(item);
           
       }
        super.push(item);
         return -1;
    }

    private Integer min() {
       if(sta.isEmpty()){
           return Integer.MAX_VALUE;
       }
        return (Integer) sta.peek();
    }

    @Override
    public synchronized Integer pop() {
        int value=super.pop();
        if(value==min()){
            sta.pop();
        }
        return value;
    }
    

    public static void main(String[] args) {
        

    }

}
