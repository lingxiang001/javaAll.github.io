package sort;

public class _2Sort {
    public static int minNumberInRotateArray(int [] array) {
        if(array == null){
            return -1;
        }
        if(array.length == 0){
            return 0;
        }
        int low=0;
        int high=array.length-1;
        int middle=-1;;
        while(array[low]>=array[high]){
            if(high-low == 1){
                middle = high;
                break;
            }
            middle=(low+high)>>1;
            if(array[middle]>=array[low]){
                low=middle;
            }
            if(array[middle]<= array[high]){
                high=middle;
            }
        }
        return array[middle];
    
    
    }
    public static void main(String[] args) {
        int[] arr=new int[]{3,4,0,1,2};
        int a=minNumberInRotateArray(arr);
        System.out.println(a);
    }

}
