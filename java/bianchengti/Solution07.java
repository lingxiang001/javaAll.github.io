/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
n<=39
 */
package bianchengti;

public class Solution07 {
    public int Fibonacci(int n) {
        
        if(n<=2){
            return 1;
        }
                
        return Fibonacci(n-1)+Fibonacci(n-2);

    }
    public static void main(String[] args){
        Solution07 s7=new Solution07();
        System.out.println(s7.Fibonacci(4));
    }

}
