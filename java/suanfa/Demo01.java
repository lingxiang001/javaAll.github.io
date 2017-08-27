package suanfa;

import java.util.Arrays;

/**
 * 求百万个正整数中取最小可用id
 * @author lingxiang
 *
 */
public class Demo01 {
    public static int  f(int[] arr){
        Arrays.sort(arr);
        if(arr[0]!=0){
            return 0;
        }else{
           for(int i=0;i<arr.length;i++){
               if(i+1<arr.length){
                   if(arr[i]+1 != arr[i+1]){
                       return arr[i]+1;
                   }
               }else{
                   return arr[i]+1;
               }
           }
          
          
        }
        return -1;
        
    }
    
    public static int f2(int[] arr,int low,int high){
        Arrays.sort(arr);
        int n=arr.length;
        if(arr[0]!=0){
            return 0;
        }
        int mid = 0;
        while (low<high) {
            mid=(high+low)>>1;
            if ( arr[mid] ==mid) {
                low = mid + 1;
            } else if ( arr[mid] >mid) {
                high = mid - 1;
            } 
        }
        System.out.println(mid);
        System.out.println(high+1);
        if(arr[mid]==mid && mid==arr.length-1){
            return mid+1;
        }else {
            if(low>0 && high<arr.length){
                for(int i=low-1;i<=high;i++){
                    if(arr[i]+1!=arr[i+1]){
                        return arr[i]+1;
                    }
                }
            }else{
                for(int i=low;i<=high;i++){
                    if(arr[i]+1!=arr[i+1]){
                        return arr[i]+1;
                    }
            }
            }
        }
        return -1;
            
        
      
        
       
      
    }
  

    public static void main(String[] args){
        int[] array=new int[]{0,3,1,2,4,5}; 
                                 //    023457
        System.out.println(f2(array,0,array.length));
    }

}
