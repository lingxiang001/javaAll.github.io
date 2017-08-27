package jingdong;

import java.util.*;
public class Main{
  public static void fun(){
    Scanner scan=new Scanner(System.in);
    for(int q=0;q<5;q++){
      
        int n=scan.nextInt();
        int m=scan.nextInt();
        Set<Integer> set=new TreeSet();
        for(int j=0;j<n;j++){
           
          int x=scan.nextInt();
          set.add(x);
          }
        for(int i=0;i<m;i++){
            int y=scan.nextInt();
            set.add(y);
        }
        Iterator<Integer> it=set.iterator();
        while(it.hasNext()){
          System.out.print(it.next()+" ");
        }
        
        
    }
  
       
  
  
  }
  public static void main(String[] args){
    fun();
  }
  
  
}