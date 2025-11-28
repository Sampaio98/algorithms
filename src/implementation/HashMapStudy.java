package implementation;

public class HashMapStudy<K, V> {
    private static final int INITIAL_CAPACITY = 10;

    private final Tuple<K, V>[] buckets;
    private int size;

    public HashMapStudy() {
        this.buckets = new Tuple[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void put(K key, V value) {
        var index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new Tuple<>(key, value);
            size++;
        } else {
            var curr = buckets[index];
            if (curr.key.equals(key)) {
                curr.value = value;
            } else {
                buckets[index] = new Tuple<>(key, value);
                size++;
            }
        }
    }

    public V get(K key) {
        var index = hash(key);
        var bucket = buckets[index];
        if (bucket != null && bucket.key.equals(key)) {
            return bucket.value;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int hash(K key) {
        if (key == null) return 0;
        return key.hashCode() % buckets.length;
    }

    static class Tuple<K, V> {
        K key;
        V value;

        Tuple(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}
