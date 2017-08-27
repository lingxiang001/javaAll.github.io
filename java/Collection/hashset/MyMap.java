package Collection.hashset;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import BinarySearchTree.TreeNode;

public class MyMap<K,V> implements MyHashMap<K, V> {
    int modcount=0;
    int size=0;
    Linker[] table=new Linker[10];
    LinkNode head;
    @Override
    public void put(K key, V val) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        LinkNode newNode=new LinkNode(key,val);
        
        if(table[i]==null){
            table[i]=new Linker();
            table[i].put(key, val);
            
            size++;
        }else{
            if(table[i].getVal(key) == null){
                table[i].put(key, val);
               
                size++;
            }else{
                change(key,val,table[i]);
            }
            
        }
      modcount++;//源码中的modcount只有在改变元素结构时才会增1；若是替换原来元素则不会。
                         // 现在我改的是在覆盖时都会改变其值，所以在iterator遍历时会抛出异常。
        
    }

    private void change(K key, V val,Linker tableson) {
        
       LinkNode<K,V> current=tableson.getNode(key);
       current.setVal(val);
     }

    @Override
    public V getValue(K key) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        LinkNode<K,V> current=table[i].getNode(key);
        if(current==null){
            return null;
        }
         return current.getVal();
      
    }

    @Override
    public void remove(K key) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        LinkNode<K,V> current=table[i].getNode(key);
        if(current !=null){
                table[i].remove(key);
                modcount++;
                size--;
            }
        
    }
   
    
    public Iterator  iterator(){
        return new Iterator(){
           int precount=modcount;
           int temp=size;
           int lastNum=-1;
           ArrayList<Iterator> list=null;
           ArrayList<Linker> list2=new ArrayList();;
           int i=0;
           {
               list=ite();
               System.out.println(list);
           }
            @Override
            public boolean hasNext() { 
               
                boolean bool= list.get(i).hasNext();
                if( ! bool){
                    lastNum=-1;
                    i++; 
                    if(i>=list.size()){
                        return false;
                    }
                    bool= list.get(i).hasNext();
                }
                
                return temp>0;
            }

            @Override
            public Object next() {
                check();
                temp--;
                lastNum++;
                return list.get(i).next();
            }
            public ArrayList<Iterator> ite(){
                ArrayList<Linker> list2=new ArrayList();
                ArrayList<Iterator> list=new ArrayList();
                for(int i=0;i<table.length;i++){
                    if(table[i] == null || table[i].iterator() == null){
                        continue;
                    }
                    list2.add(table[i]);
                    list.add(table[i].iterator());
                }
                return list;
               
            }
            @Override
            public void remove() {
                
                check();
                try {
                    list2.get(i).remove(lastNum);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            public void check(){
                if(precount != modcount){
                    throw new ConcurrentModificationException();
                }
            }
            
        };
    }
 //以下代码照搬源码
    
    final int hash(Object k) {
        int h =0;
        if (0 != h && k instanceof String) {
            return sun.misc.Hashing.stringHash32((String) k);
        }

        h ^= k.hashCode();

        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * Returns index for hash code h.
     */
    static int indexFor(int h, int length) {
        // assert Integer.bitCount(length) == 1 : "length must be a non-zero power of 2";
        return h & (length-1);
    }

}
