package sort;

import java.util.Arrays;
import java.util.Random;

public class Sort {
  //  二分查找算法
  
    public static int binarySearch(int low,int high,int[] arr,int target){
        int mid = 0;
         while(low<=high){
            mid=(high-low)/2;
            if(arr[mid]==target){
                  return mid;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
         }
         return mid;
    }

    //冒泡排序

     public static int[] maoPao(int[] arr){
       for(int i=0;i<arr.length-1;i++){
          for(int j=0;j<arr.length-1-i;j++){
              if(arr[j]<arr[j+1]){
                 arr[j]^=arr[j+1];
                 arr[j+1]^=arr[j];
                 arr[j]^=arr[j+1];
              }
          }
       }
       return arr;
    }

    //选择排序
    public static int[] xuanZe(int[] arr){
       for(int i=0;i<arr.length;i++){
         for(int j=i;j<arr.length;j++){
             if(arr[i]<arr[j]){
                 arr[j]^=arr[i];
                 arr[i]^=arr[j];
                 arr[j]^=arr[i];
              }
         }
       } 
       return arr;
    }

    //插入排序
    public static int[] chaRu(int[] arr){
        return arr;
       
    }

    public static void main(String[] args){
      /* int[] arr={1,2,3,4,5,6,7};
        int i= binarySearch(0,arr.length-1,arr,4);
        System.out.println(i);
        int[] arr2=new int[]{1,2,5,4,1,7,8};
        arr2=maoPao(arr2);
        for(int i1:arr2){
           System.out.print(i1+" ");
        }
        arr2=xuanZe(arr2);
        for(int i2:arr2){
          System.out.print(i2+" ");
        }*/
        int[] arr=new int[1000000];
        for(int i=0;i<1000000;i++){
           arr[i]=(int)(Math.random()*100);
        }
        long start=System.currentTimeMillis();
        Arrays.sort(arr);
        long end=System.currentTimeMillis()-start;
        System.out.println(end);
    }


}
