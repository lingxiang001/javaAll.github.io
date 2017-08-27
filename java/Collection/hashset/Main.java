package Collection.hashset;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
  /*  Linker link=new Linker();
        link.put("1","a");
        link.put("2", "b");
        link.put("3", "c");
        link.put("4", "d");
        System.out.println(link.getSize());
       Object v= link.getVal("2");
       Iterator it=link.iterator();
      while(it.hasNext()){
          System.out.println(it.next());
      }
   System.out.println(link.getVal("7"));*/
   /* link.remove("3");
      System.out.println("*****************");
      Iterator it2=link.iterator();
      while(it2.hasNext()){
          System.out.println(it2.next());
      }*/
      
//      System.out.println(link.getVal("1"));//
     
        MyMap<String,String> map=new MyMap<String,String>();
        /*System.out.println(map.size);
        map.put("1", "a");
        map.put("2", "b");
        map.put("2", "dlx");
        String v=map.getValue("1");
        String v2=map.getValue("2");
        map.remove("1");
         v=map.getValue("1");
        System.out.println(map.size);
        System.out.println(v);
        System.out.println(v2);*/
       
      for(int i=0;i<12;i++){
          
          map.put(i+"",i+"");
      }
   /* for(int i=0;i<10;i++){
         
         if(map.table[i] == null){
             continue;
         }
         Iterator it3=map.table[i].iterator();
         while(it3.hasNext()){
             System.out.println(it3.next());
         }
     }*/
     System.out.println("*********************");
      Iterator it=map.iterator();
     
    /*  while(it.hasNext()){
          System.out.println(it.next());
        // map.put("11", "abd");
         it.remove();
      }*/
      Map<String,String> map2=new HashMap<String,String>();
      map2.put("12", "assd");
      map2.put("23", "errty");
      Iterator it3=map2.entrySet().iterator();
      while(it3.hasNext()){
          System.out.println(it3.next());
          it3.remove();
         return;
      }
      Iterator it4=map2.entrySet().iterator();
      while(it4.hasNext()){
          System.out.println(it4.next());
         
      }
  
     }

}
