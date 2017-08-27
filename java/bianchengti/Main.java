package bianchengti;

import java.util.*;

public class Main{
    public static void count(){
        System.out.println("input num");
        Scanner scan=new Scanner(System.in);
        Set set=new TreeSet();
        int n=scan.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
       Arrays.sort(arr);
        //单个
       for(int i=0;i<n;i++){
          set.add(arr[i]*arr[i]); 
       }
         int len=n;
        for(int i=0;i<n;i++){
           
            for(int j=i;j<len;j++){
                int sum=0;
                for(int m=i;m<len;m++){
                    sum+=arr[i];
                }
                int num=arr[n-1]*sum;
                set.add(num);
                len--;
                continue;
            }
        }
        int[] native1=new int[10000];
       int count=0;
       Iterator it=set.iterator();
       while(it.hasNext()){
           int n2=(int) it.next();
           native1[count]= n2;
           System.out.println(n2);
          count++;
       }
        System.out.println(native1[count-1]);
       
 
}
   
public static void main(String[] args){
    count();
}
}