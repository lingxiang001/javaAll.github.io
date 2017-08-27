/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法

我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
package bianchengti;

public class Solution08 {
    public int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
       
        return JumpFloor(target-1)+JumpFloor(target-2);

    }
    public static void main(String[] args){
        Solution08 s8=new Solution08();
       System.out.println(s8.JumpFloor(4)); 
    }

}
