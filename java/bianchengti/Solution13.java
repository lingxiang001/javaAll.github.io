package bianchengti;

public class Solution13 {
 public int[] reOrderArray(int [] array) {
        int [] arr=new int[array.length];
        int [] arr2=new int[array.length];
        int count=0;
        int count2=0;
        for(int i:array){
            if(i % 2 !=0){
                arr[count]=i;
               count++;
            }else{
              arr2[count2]=i;
              count2++;
            }
        }
        for(int i:arr){
            System.out.println( i );
        }
        for(int i:arr2){
            System.out.println( i );
        }
        for(int i=0;i<count2;i++){
            arr[count]=arr2[i];
            count++;
            System.out.println(arr2[count2]);
        }
        array=arr;
      return array;
    }
 public static void main(String[] args){
     Solution13 s13=new Solution13();
     int[] array={1,2,3,4,5,6};
     array=s13.reOrderArray(array);
     for(int i:array){
         System.out.println( i );
     }
    
    
 }

}
