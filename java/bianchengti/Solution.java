package bianchengti;

public class Solution {
    public boolean Find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            int[] a=array[i];
            if (binarys(a,target)!=-1){
                return true;
            }
        }
        return false;
     
    }
    public int binarys(int [] array,int data){
       int low=0;
       int high=array.length-1;
       
        while(low<=high){
            int mid=(high-low)/2;
            if(data == array[mid]){
                return mid;
            }else if(data>array[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
            
        }
        return -1;
    }
    public static void main(String[] args){
        int [][] array={
                        {1,2,3,4,5,6},
                        {3,4,5,6,7,8},
                        {4,5,6,7,8,9}
            
                       };
        
        Solution so=new Solution();
        System.out.println(so.Find(9, array));
            
    }
        

}
