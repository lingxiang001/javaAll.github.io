package sort;

import java.util.Arrays;

public class MergeSort {
    private static int count=0;
    public static void mergeSort(int[] arr,int left,int right){
        sort(arr,left,right);
        
    }
    /*
    分成两段分别排序，然后再合并
    */
    private static void sort(int[] arr, int low, int high) {
      if (low < high) {
        int middle = (high + low) / 2;
        sort(arr, low, middle);
        sort(arr, middle + 1, high);
        merge(arr, low, high,middle);
        System.out.println(Arrays.toString(arr)+" "+count);
      }
    }
    
    public static void merge(int[] arr,int left,int right,int center){
        int[] tmpArr=new int[arr.length];//临时数组
        int mid=center+1;//右数组第一个索引
        int third=left;//记录临时数组的索引
        int tmp=left;
        while(left <=center && mid<=right){
            if(arr[left]<=arr[mid]){
                tmpArr[third++]=arr[left++];
            }else{
                tmpArr[third++]=arr[mid++];
               count=count+center-left+1;
            }
        }
        while(left<=center){
            tmpArr[third]=arr[left];
            third++;
            left++;
        } 
        while(mid<=right){
            tmpArr[third]=arr[mid];
            third++;
            mid++;
        }
        while(tmp<=right){
            arr[tmp]=tmpArr[tmp]; 
            tmp++;
        }
        
    }
    public static void main(String[] args) {
        int[] arr=new int[]{5,4,3 ,2,1};
        mergeSort(arr,0,arr.length-1);
        System.out.println("*******************************");
       System.out.println( Arrays.toString(arr));
       System.out.println(count);
    }

}
