package cn.datacharm.collectionandmap;


import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * description:
 * 自定义一个HashMap!
 * @author Herb
 * @date 2019/09/2019-09-17
 */
public class MyHashMap<K,V> implements Map {
    static final int DEFAULT_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int MAX_CAPACITY = 1 << 30;

    static class Node<K,V> implements Map.Entry<K,V>{

        final int hash;
        final private K key;
        private V value;
        private Node<K,V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getHash() {
            return hash;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }


    private Node<K,V>[] table;
    private int size;
    private int threshold;
    private float loadFactor;


    public MyHashMap(){
        System.out.println("无参MyHashMap");
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public MyHashMap(int capacity){
        this(capacity,DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int capacity,float loadFactor){
        if (capacity < 0 || loadFactor <= 0) {
            throw new IllegalArgumentException("初始化大小只能为正数！");
        } else if(capacity > MAX_CAPACITY){
            capacity = MAX_CAPACITY;
        }
        //此处threshold需要赋值为2次幂 通过tableSizeFor
        this.threshold = capacity;
        this.loadFactor = loadFactor;
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        Node<K,V> node;
        return (node = getNode(hash(key),key)) == null?null : node.getValue();
    }

    public Node<K,V> getNode(int hash,Object key){
        Node<K,V> tab[];
        return ((tab = table) == null ? null : tab[(tab.length - 1) & hash]);
    }

    @Override
    public Object put(Object key, Object value) {
        return putVal(hash(key), key, value);
    }

    private Object putVal(int hash,Object key, Object value) {//实际还有onlyIfAbsent evict参数
        Node<K,V>[] tab;Node p;int cap,i;
        //当底层数组尚未初始化
        if ((tab = table) == null || (cap = tab.length) == 0) {
            cap = (tab = resize()).length;
            System.out.println("空数组初始化大小: " + cap);
        }
        //当数组首个节点为空，直接插入
        if ((p = tab[i = (cap - 1) & hash]) == null ){
            tab[i] = new Node(hash, key, value,null);
        }else {
            //TODO 处理冲突
        }
        size ++;
        return null;
    }

    private  Node[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap = 0, newThr = 0;
        if (oldCap > 0) {
            if (oldCap > MAX_CAPACITY) {
                newThr = MAX_CAPACITY;
            } else if ((newCap = oldCap<<1)<=MAX_CAPACITY && oldCap >= DEFAULT_CAPACITY) {
                newThr = oldThr << 1;
            }
        } else if (oldThr > 0) {
            newCap = oldThr;
        } else {
            newCap = DEFAULT_CAPACITY;
            newThr = (int)(DEFAULT_CAPACITY * DEFAULT_LOAD_FACTOR);
        }

        threshold = newThr;
        Node[] newTab =  new Node[newCap];
        table = newTab;
        //TODO rehash！
        return newTab;
    }

    private int hash(Object key){
        int h = 0;
        return key == null ? 0 : (h = key.hashCode() ^ (h>>> 16));
    }
    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    public static void main(String[] args) {
        Map<String, String> map = new MyHashMap();
        System.out.println(map.size());
        map.put("t1", "test");
        System.out.println(map.size());
        System.out.println(map.get("t1"));
    }
}
