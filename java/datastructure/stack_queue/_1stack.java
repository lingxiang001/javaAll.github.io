package datastructure.stack_queue;
/**
 * 实现用一个数组实现三个栈 push,pop,peek,pop(stacksindex)
 * @author lingxiang
 *
 */
public class _1stack {
    //固定空间分配
    private static  int stackSize=10;
    static Object[] stack=new Object[stackSize*3];
    private static int[] stackPointer=new int[]{-1,-1,-1};
    /**
     * 选择栈存放数据
     * @param stackNum
     * @param values
     * @throws Exception 
     */
    public static void push(int stackNum,Object value) throws Exception{
        if(stackNum>=3 || stackNum<0){
            throw new Exception(" input error");
        }
        //检查是否还有空余空间
        if(stackPointer[stackNum]+1>=stackSize){
            throw new Exception(" no  more space");
        }
        stackPointer[stackNum]++;
        stack[abcTopofStack(stackNum)]=value;
        
    }
    /**
     * 返回栈顶元素的索引
     * @param stackNum
     * @return
     */
    private static int abcTopofStack(int stackNum) {
        return stackSize * stackNum+stackPointer[stackNum];
    }
    /**
     * 选择栈输出元素
     * @return
     * @throws Exception 
     */
    public static Object pop(int stackNum) throws Exception{
        if(stackNum>=3 || stackNum<0){
            throw new Exception(" input error");
        }
        /**
         * 检查是否栈为空
         */
        if(stackPointer[stackNum] == -1){
            throw new Exception(" no values");
        }
        Object obj=stack[abcTopofStack(stackNum)];
        stackPointer[stackNum]--;
        return obj;
         
    }
    private static boolean isEmpty(int stackNum) {
      
        return stackPointer[stackNum]==-1;
    }
    public static Object peek(int stackNum) throws Exception{
        if(stackNum>=3 || stackNum<0){
            throw new Exception(" input error");
        }
        /**
         * 检查是否栈为空
         */
        if(stackPointer[stackNum] == -1){
            throw new Exception(" no values");
        }
        return stack[abcTopofStack(stackNum)];
    }
    public static void main(String[] args) throws Exception {
        
        for(int i=0;i<9;i++){
            push(0, "abc");
           
        }
        push(0,"OLP");
        
        push(1,"Asd");
        push(2,"Qwe");
        int i=0;
        for(Object obj:stack){
            System.out.println(i+" "+obj+"    "+stackPointer[0]);
            i++;
        }
        
     //   System.out.println(pop(1));
        System.out.println(peek(0));
    }

}
