package BinarySearchTree;

import java.util.Map;
import java.util.Objects;

public class TreeNode<K,V> {
    private K key;
    private V value;
    private TreeNode<K,V> childL;
    private TreeNode<K,V> childR;
     TreeNode<K,V> parent;
    private int hash;
    boolean isLeftNode=false;
    public TreeNode(K key, V value) {
        super();
        this.key = key;
        this.value = value;
    }
    public TreeNode() {
        super();
    }
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public TreeNode<K, V> getChildL() {
        return childL;
    }
    public void setChildL(TreeNode<K, V> childL) {
        this.childL = childL;
    }
    public TreeNode<K, V> getChildR() {
        return childR;
    }
    public void setChildR(TreeNode<K, V> childR) {
        this.childR = childR;
    }
    public int getHash() {
        return hash;
    }
    public void setHash(int hash) {
        this.hash = hash;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry))
            return false;
        Map.Entry e = (Map.Entry)obj;
        Object k1 = getKey();
        Object k2 = e.getKey();
        if (k1 == k2 || (k1 != null && k1.equals(k2))) {
            Object v1 = getValue();
            Object v2 = e.getValue();
            if (v1 == v2 || (v1 != null && v1.equals(v2)))
                return true;
        }
        return false;
    }
    @Override
    public String toString() {
        
        return this.getKey()+":"+this.getValue();
    }
    
    
    

}
