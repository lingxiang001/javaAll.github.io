package sort;

public class QuickSort {
    public static int partition(int[] arr ,int low,int high){
       
        int mid=arr[low];
       
        while(low< high){
            if(low<high && mid<=arr[high] ){
                high--;
            }
            arr[low]=arr[high];
            if(low<high && mid>=arr[low]){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[high]=mid;
        System.out.println(high+" "+arr[high]);
        
        return  high;
        
    } 
    public static void quickSort(int[] arr,int low,int high){
        
     
            if(low>=high){
                return;
            }
            int pos=partition(arr,low,high);
            quickSort(arr,low,pos-1);
            quickSort(arr,pos+1,high);
        }
  
    public static void main(String[] args) {
        int[] arr=new int[]{1,4,7,3,6,2,8};
        quickSort(arr, 0, arr.length-1);
        for(int i:arr){
            System.out.print(i);
        }

    }

}
