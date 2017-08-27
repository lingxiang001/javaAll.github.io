package Collection.hashset;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class LinkNode <K,V>{
    private LinkNode next;
    private LinkNode pre;
    private V val;
    private K key;
    public LinkNode() {
        super();
    }
    public LinkNode(LinkNode pre,LinkNode next, K key, V val) {
        super();
        this.pre=pre;
        this.next = next;
        this.val = val;
        this.key = key;
    }
    
    public LinkNode(K key2, V val2) {
       this.key=key2;
       this.val=val2;
    }
    public LinkNode getPre() {
        return pre;
    }
    public void setPre(LinkNode pre) {
        this.pre = pre;
    }
    public LinkNode getNext() {
        return next;
    }
    public void setNext(LinkNode next) {
        this.next = next;
    }
    public V getVal() {
        return val;
    }
    public void setVal(V val) {
        this.val = val;
    }
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    @Override
    public String toString() {
        return "LinkNode [val=" + val + ", key=" + key + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getVal());
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry))
            return false;
        Map.Entry e = (Map.Entry)obj;
        Object k1 = getKey();
        Object k2 = e.getKey();
        if (k1 == k2 || (k1 != null && k1.equals(k2))) {
            Object v1 = getVal();
            Object v2 = e.getValue();
            if (v1 == v2 || (v1 != null && v1.equals(v2)))
                return true;
        }
        return false;
    }
    
    
    
    

}
