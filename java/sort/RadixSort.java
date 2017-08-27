package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
    private static ArrayList<Integer>[] list=new ArrayList[10];
    static {
        for(int i=0;i<list.length;i++){
            list[i]=new ArrayList<Integer>();
        }
    }
    public static void redixSort(int[] arr){
        int d=1;
        try{
        
          while(true){
               sort(arr,d++);
               System.out.println(Arrays.toString(arr) );
           }
        
            
        }catch(Exception e){
            e.getMessage();
        }
        
    }
    public static void sort(int[] arr,int d){
        //根据需要的位数入桶
      
        for(int i=0;i<arr.length;i++){
            input(arr[i],digit(arr[i],d));
          
        }
        //System.out.println(Arrays.toString(arr));
        if(list[0].size()==arr.length && d!=1){
            throw new RuntimeException("位数已到");
        }
       
        //每个桶在依次归还给数组
        int index=0;
        for(int i=0;i<list.length;i++){
            for(Integer m: list[i]){
                arr[index++]=m;
            }
        }
        clearAll();
    }
    
    private static void clearAll() {
        for(ArrayList a:list){
            a.clear();
        }
        
    }
    public static int digit(int num,int n){
        return (int) (num/Math.pow(10, n-1))%10;
    }
    public static void input(int count,int d){
     //   System.out.println(d);
       switch(d) {
       case 0:
           list[0].add(count);
          
           break;
       case 1:
           list[1].add(count);
           break;
       case 2:
           list[2].add(count);
           break;
       case 3:
           list[3].add(count);
           break;
       case 4: 
           list[4].add(count);
           break;
       case 5: 
           list[5].add(count);
           break;
       case 6: 
           list[6].add(count);
           break;
       case 7: 
           list[7].add(count);
           break;
       case 8: 
           list[8].add(count);
           break;
       case 9: 
           list[9].add(count);
           break;
       }
    }
  
    public static void main(String[] args) {
        int[] arr=new int[]{80,90,40,30,20,0,100};
        redixSort(arr);
        for(int i:arr){
           System.out.print(i+" "); 
        }

    }

}
