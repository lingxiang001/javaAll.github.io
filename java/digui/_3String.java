package digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class _3String {
    public static int print(String str){
        if(str.length()<=0 || str.length()>50){
            return 0;
        }
        String help=quChong(str);
       // System.out.print(help);
        if(help.length()==2){
            return 2;
        }else if(help.length() ==1){
            return 1;
        }else{
            return 0;
        }
    }
    public static String quChong(String str){
        if(str.length() <=0){
            return null;
        }
       Set set=new HashSet();
       for(int i=0;i<str.length();i++){
           char c=str.charAt(i);
           set.add(c);
       }
        StringBuffer sb=new StringBuffer("");
        for(Object c: set){
            sb=sb.append(c);
        }
        return sb.toString();
    }
    
    public static void isDengCha(){
        boolean flag=true;
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        Arrays.sort(arr);
        int a1=arr[0];
        int d=arr[1]-arr[0];
        System.out.println(arr[2]);
        for(int i=1;i<arr.length;i++){
           if(arr[i]!=a1+(n+1-1)*d){
               flag=false;
               System.out.println("Impossible");
               return;
               
           }
        }
        if(flag=true){
           System.out.println("Possible");
        }
        
       
    }
    public static void main(String[] args) {
        System.out.println(quChong("AAA"));
        System.out.println(print("AbAb"));
        isDengCha();
    }

}
