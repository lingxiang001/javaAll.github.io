package sort;
/**
 * 计数排序主体思想是：
 * 如：1，4，3，8，5，7
 *   先找出无序数组的最大值和最小值：8，1
 *   创建一个辅助数组help来记录每个数的下标和出现次数 ，长度是最值相减+1；
 *   得出：help的值：help[arr[i]-min]++;1 0 1 1 1 0 1 1
 *   最后根据辅助数组得出排序后的数组：
 *    while（help[i]--〉0） sort[index++]=i+min： 1 3 4 5 7 8
 * @author lingxiang
 *
 */
public class CountingSort {
    public static int[] countingSort(int[] arr,int n){
        int max=arr[0];
        int min=arr[0];
        if(arr == null || n<2){
            return arr;
        }
        //最大值和最小 值 
        for(int i=0;i<n;i++){
            max=Math.max(arr[i],max);
            min=Math.min(arr[i],min);
        }
        //辅助数组
        int[] help=new int[max-min+1];
        for(int i=0;i<n;i++){
            help[arr[i]-min]++;
        }
        System.out.println("**********************");
        for(int i:help){
            System.out.print(i+" "); 
         }
        System.out.println("**********************");
        //排序数组
        int[] sort= new int[arr.length];
        int index=0;
        for(int i=0;i<help.length;i++){
            while(help[i]-->0){
                sort[index++]=i+min;
            }
        }
        
        
        return sort;
        
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,1,6,3,2,7};
        arr=countingSort(arr,arr.length);
        for(int i:arr){
           System.out.print(i+" "); 
        }

    }

}
