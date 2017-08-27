package bianchengti;

import java.math.BigDecimal;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author lingxiang
 *
 */
public class Solution11 {
    public int NumberOf1(int n) {
        int  m=Math.abs(n);
        String str1=Integer.toBinaryString(m);
        int count=0;
        if(n<0){
           str1=str1.replaceAll("2","1");
           str1=str1.replaceAll("0", "1");
           str1=str1.replaceAll("2","1");
            if(str1.charAt(0)=='0'){
                str1.replaceFirst("0","1");
            }
            if(str1.charAt(str1.length()-1)=='0'){
                str1=str1.substring(0, str1.length()-2)+"1";
                System.out.println(str1);
            }else{
                int a=Integer.parseInt(str1, 2);
                str1=Integer.toBinaryString(a+1);
                System.out.println(str1);
            }
         
        }
        int a=Integer.parseInt(str1, 2);
        System.out.println(str1+a);
        int i=0;
        while(i <str1.length()){
            if(str1.charAt(i)=='1'){
                count++;
            }
            i++;
        }
        return count;

    }
    public static void main(String[] args){
        Solution11 s11=new Solution11();
        System.out.println(s11.NumberOf1(-7));
    }

}
