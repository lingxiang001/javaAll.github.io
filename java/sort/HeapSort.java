package sort;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort( int[] arr){
        //构建最值
        int n = arr.length;
        if (n == 1)
          return;
        for (int i = n / 2 - 1; i >= 0; i--) {//n/2~n的节点是叶子，已经是合法的最小堆
            minHeapFixDown( arr, i, n );
        }
        //调整堆结构，交换堆顶元素和末位元素
        for(int i=arr.length-1;i>=1;i--){
            swap(arr,0,i);
            minHeapFixDown(arr,0,i);
            System.out.println(Arrays.toString(arr));
            
        }
       
    }
    private static void swap(int[] arr, int i, int i2) {
        arr[i]^=arr[i2];
        arr[i2]^=arr[i];
        arr[i]^=arr[i2];
        
    }
    private static void minHeapFixDown(int[] arr, int index, int length) {
        int j = 2 * index + 1;  // 左孩子
        int temp = arr[index];
        while (j < length) {
          if (j + 1 < length && arr[j + 1] < arr[j]) {  // 左右孩子比较，在左右孩子中找最小的
            j++;  // 小孩子
          }
          if (arr[j] < temp) {  // 小孩子比自己还小，则小孩子上浮
            arr[index] = arr[j];
            index = j;// 站到小孩子的位置，大孩子那边可以不管了（没有变动）
            j = 2 * index + 1;// 指向小孩子的左孩子
          } else { // 小孩子不比自己小
            break;
          }
        }
        // 循环走完，index的位置就是temp应该放置的位置
        arr[index] = temp;
      }

    public static void main(String[] args) {
        int[] arr= new int[]{1,4,3,7,9};
        heapSort(arr);
        System.out.println("********************************");
        for(int i:arr){
            System.out.print(i+" ");
        }

    }

}
