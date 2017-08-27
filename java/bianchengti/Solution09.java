/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
package bianchengti;

public class Solution09 {
public int JumpFloorII(int target) {
    int num;
    if(target == 1){
        return 1;
    }
    if(target == 2){
        return 2;
    }
    if(target == 3){
        return 4;
    }
    int result=0;
    int[ ] arr=new int[target+1];
    arr[1]=1;
    arr[2]=2;
    arr[3]=4;
    int sum=0;
    for(int i=4;i<=target;i++){
        
       arr[i]=result+7;
       
       result=result+arr[i];
       sum=arr[i];
       System.out.println(i+":"+arr[i]);
    }
  
    return sum;
    
    }
    public static void main(String[] args){
        Solution09 s9=new Solution09();
        System.out.println(s9.JumpFloorII(7));
    }


}
