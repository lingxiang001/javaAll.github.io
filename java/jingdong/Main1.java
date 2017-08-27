package jingdong;
import java.util.*;
public class Main1{
  public static void fun(){
    Scanner scan=new Scanner(System.in);
    while(scan.hasNext()){
      int n=0;
      int m=0;
      while(n<m){
          n=scan.nextInt();
          m=scan.nextInt();
          
      }
      int[] arr=new int[n];
      Set<String> set=new HashSet();
      for(int i=0;i<n;i++){
        arr[i]=scan.nextInt();
      }
      for(int i=0;i<m;i++){
        String str=scan.next();
        set.add(str);
      }
      Arrays.sort(arr);
      int len=m-set.size();
      int min=0;
      int max=0;
      int num=n-1;
     
        if(len==0){
           for(int i=0;i<m;i++){
             min+=arr[i];
             max+=arr[num--];
           }
        }else if(set.size()==1){
             min=arr[0]*m;
             max=arr[n-1]*m;
        }else{
            System.out.println(len);
             min=arr[0]*len;
             max=arr[n-1]*len;
             for(int i=0;i<set.size();i++){
                   min+=arr[i];
                   System.out.println(arr[i]+"____"+min);
                   System.out.println(arr[num]+"___________"+max);
                   max+=arr[num--];
                   
              }
        }
        System.out.println(min+"  "+max);
    
      }
    }
  public static void main(String[] args){
      fun();
  }
  }
