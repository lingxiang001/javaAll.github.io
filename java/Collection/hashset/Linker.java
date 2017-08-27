package Collection.hashset;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Linker implements iLinker{
   
   LinkNode head=null;
   LinkNode lastNode=null;
   int size;
   public boolean isEmpty() {
       return size==0;
   }
   
    public LinkNode getHead() {
    return head;
}

public void setHead(LinkNode head) {
    if(this.head==null){
        this.head = head;
        lastNode=head;
       
        size++;
    }
   
}

    @Override
    public void put(Object key, Object val) {
        LinkNode newNode=new LinkNode(null,null,key,val);
        
        if(isEmpty()){
            head=newNode;
            lastNode=head;
            
            size++;
        }else{
         
            LinkNode preNode=lastNode;
            preNode.setNext(newNode);
            newNode.setPre(preNode);
            lastNode=newNode;
            size++;
            }
           
        }
     
        
    
   
    @Override
    public void remove(Object key) {
           if(!contains(key) || isEmpty()){
              return;
           }
           LinkNode remNode=getNode(key);
           removeNode(remNode);
      
    }
    public LinkNode remove(int index) throws IllegalAccessException{
        if(index<0 || index >= size){
            throw new IllegalAccessException();
        }
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int i=0;
        LinkNode current=head;
        while(i != index){
           current=current.getNext();
            i++;
        }
        removeNode(current);
        return current;
    }
    

    private void removeNode(LinkNode remNode) {
        if(remNode == head){
            head=remNode.getNext();
            
        }else if(remNode==lastNode){
            lastNode=remNode.getPre();
            remNode.getPre().setNext(null);
        }else{
            remNode.getNext().setPre(remNode.getPre());
            remNode.getPre().setNext(remNode.getNext());
        }
        remNode=null;
         size--;
        
    }

    @Override
    public Object getVal(Object key) {
       return getNode(key)==null?null:getNode(key).getVal();
    }
    /**
     * 根据key值找出节点
     * @param key
     * @return
     */
    private boolean contains(Object key){
        if(getNode(key) != null){
            return true;
        }
       return false;
    }
    public LinkNode getNode(Object key) {
        if(isEmpty() ){
            return null;
        }
        LinkNode current=head;
        while(current !=null){
            if( key != null && key.equals(current.getKey())){
                
                return current;
            }
            current=current.getNext();
        }
        return null;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
    public Iterator iterator(){
        return new Iterator(){
           
            LinkNode current=head;
            LinkNode pre=null;
            @Override
            public boolean hasNext() {
                if(current == null){
                    return false;
                }
                pre=current;
                current=current.getNext();
                return true;
            }

            @Override
            public Object next() {
                 return pre.getVal();
            }

            @Override
            public void remove() {
               
            }
            
        };
        
    }

}
