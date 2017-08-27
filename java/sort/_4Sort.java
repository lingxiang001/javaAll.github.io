package sort;

import java.util.ArrayList;

public class _4Sort {
    private static ArrayList<Person>[] personList=new ArrayList[10];
    static {
        for(int i=0;i<personList.length;i++){
            personList[i]=new ArrayList<Person>();
        }
    }
    public static void bucketSort(Person[] person){
        for(int i=0;i<person.length;i++){
            input(person[i]);
        }
       
    }
    
    private static void input(Person person) {
        
        switch(person.getAge()){
         
        }
        
    }

    public static void main(String[] args) {
        

    }

}
