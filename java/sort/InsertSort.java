package sort;
/**
 * 插入排序
 * @author lingxiang
 *
 */
public class InsertSort {
    public static void insert(int[]arr){
        for(int i=1;i<arr.length;i++){
            int j=i;
            int target=arr[i];
            while(j>0 && arr[j-1]>target){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=target;
        }
    }
    public static void main(String[] args){
        int [] arr=new int[]{11,3,6,5,3,6,8};
        insert(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

}
