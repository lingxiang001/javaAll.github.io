package digui;

import java.util.Stack;

public class _0HanoTower {
    
    public static void sort(int n,String source,String helper,String target){
        if(n==1){
            System.out.println(n +"from "+source +"to"+target);
            return;
        }
        sort(n-1,source,target,helper);
        System.out.println(n +"from "+source +"to"+target);
        sort(n-1,helper,source,target);
        
    }
    public static void main(String[] args){
        sort(3, "A", "B", "C");
    }
}
