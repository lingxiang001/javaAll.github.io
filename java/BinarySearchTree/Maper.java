package BinarySearchTree;



public class Maper<K,V> implements MyMap<K, V> {
    private int size1;
    TreeNode[] table=new TreeNode[10];
    BinarySearchTreeImpl tree=new BinarySearchTreeImpl();
    private TreeNode root;
    public Maper() {
        super();
    }

    public int getSize() {
        return size1;
    }

    public void setSize(int size) {
        this.size1 = size;
    }

    @Override
    public void put(K key, V val) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        TreeNode newNode=new TreeNode(key,val);
        TreeNode current=table[i];
        if(getValue(key) == null){
            if(current == null){
                table[i]=newNode;
                size1++;
            }else{
                root=current;
                tree.insert(key, val);
                size1++;
            }
        }else{
            change(key,val);
        }
    }

   

    private void change(K key, V val) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
       TreeNode<K,V> current=table[i];
        if(current==null){
            System.out.println("无节点");
        }
        if(current.getKey().equals(key)||current.getKey()==key){
            current.setValue(val);
            
        }
        
    }

    @Override
    public V getValue(K key) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        TreeNode<K,V> current=table[i];
        if(current==null){
            return null;
        }
        if(current.getKey().equals(key)||current.getKey()==key){
            return current.getValue();
        }
        root=current;
        return (V) tree.lookupValue(key);
    }

    @Override
    public void remove(K key) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        TreeNode<K,V> current=table[i];
        if(current !=null){
            if(current.getKey().equals(key)||current.getKey()==key){
                table[i]=null;
                
            }else{
                root=current;
                tree.remove(key);
            }
            size1--;
        }
            
        
        
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
