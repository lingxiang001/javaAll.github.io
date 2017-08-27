package Collection.hashset;

public interface iLinker<K,V> {
    /**
     * 
     * @param key
     * @param val
     */
    void put(K key,V val);
    void remove(K key);
    V getVal(K key);

}
