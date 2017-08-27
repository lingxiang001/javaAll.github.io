package sort;

import java.util.Arrays;

/**
   希尔排序的总体思想：
 * 将带排序数组分步长while（increactement>0） increactement/=2;
 * 再以i=
 * 步长的位置开始比较交换数据；
 * @author lingxiang
 *
 */
public class ShellSort {
    public static int[] shellSort(int[] arr){
        int increatment=arr.length/2;
        while(increatment>=1){
            for(int i=increatment;i<arr.length;i++){
                if(arr[i]<arr[i-increatment]){
                    arr[i]^=arr[i-increatment];
                    arr[i-increatment]^=arr[i];
                    arr[i]^=arr[i-increatment];
                }
                System.out.println(Arrays.toString(arr));
            }
            increatment/=2; 
        }
        return arr;
        
    }
    public static void main(String[] args) {
       int[] arr=new int[]{1,9,3,7,5,8};
       arr=shellSort(arr);
       for(int i:arr){
           System.out.print(i+" ");
       }

    }

}
