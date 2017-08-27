package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序的主体思想：
 *先求出最值，将（max-min）/arr.length+1,得出桶的个数；
 *再为每个桶加一个list
 *为每个list添加数据，根据arr[i]-min/arr.length找出桶的索引
 *最后为每个桶排序，并合并即最后的排序结果
 * @author lingxiang
 *
 */
public class BucketSort {
    public static String  bucketSort(int[] arr,int n){
        int min=arr[0];
        int max=arr[0];
        //得出最小最大值
        for(int i=0;i<arr.length;i++){
            max=Math.max(arr[i], max);
            min=Math.min(arr[i], min);
        }
        //分配桶 
        ArrayList<ArrayList<Integer>> bucketArr=new ArrayList<>((max-min)/arr.length+1);
        for(int i=0;i<(max-min)/arr.length+1;i++){
            ArrayList<Integer> list=new ArrayList<Integer>();
           bucketArr.add(list);
        }
        //将元素放入桶中
        for(int i=0;i<arr.length;i++){
            int num=(arr[i]-min)/arr.length;
            bucketArr.get(num).add(arr[i]);
        }
        for(int i=0;i<bucketArr.size();i++){
            Collections.sort(bucketArr.get(i));
        }
        return bucketArr.toString();
        
    }
    public static void main(String[] args){
        int[] arr=new int[]{1,4,2,6,4,9,7};
        String str=bucketSort(arr, arr.length);
        System.out.println(str);
    }
    

}
