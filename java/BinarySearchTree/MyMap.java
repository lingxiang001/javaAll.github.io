package BinarySearchTree;

public interface MyMap<K,V> {
    /**
     * 插入数据
     * @param key
     * @param val
     */
    void put(K key,V val);
    /**
     * 得到数据
     * @param key
     * @return
     */
    V getValue(K key);
    /**
     * 删除数据
     * @param key
     */
    void remove(K key);

}
