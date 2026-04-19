package implementation.hashmap;

public class HashMapImpl<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Tuple<K, V>[] buckets;
    private int size;

    public HashMapImpl() {
        this.size = 0;
        this.buckets = new Tuple[INITIAL_CAPACITY];
    }

    public void put(K key, V val) {
        int index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new Tuple<>(key, val);
        } else {
            Tuple<K, V> curr = buckets[index];
            Tuple<K, V> before = curr;
            while (curr != null) {
                if (curr.key.equals(key)) {
                    curr.val = val;
                    return;
                }
                before = curr;
                curr = curr.next;
            }
            before.next = new Tuple<>(key, val);
        }
        size++;
        if (size >= buckets.length * LOAD_FACTOR) resize();
    }

    public V get(K key) {
        int index = hash(key);
        Tuple<K, V> bucket = buckets[index];
        while (bucket != null) {
            if (bucket.key.equals(key)) {
                return bucket.val;
            }
            bucket = bucket.next;
        }
        return null;
    }

    //TODO
    public V remove(K key) {
        int index = hash(key);
        return null;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        var curr = buckets[index];
        while (curr != null) {
            if (curr.key.equals(key)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    private void resize() {
        var oldBuckets = buckets;
        this.buckets = new Tuple[oldBuckets.length * 2];
        for (Tuple<K, V> bucket : oldBuckets) {
            while (bucket != null) {
                var next = bucket.next;
                int index = hash(bucket.key);
                bucket.next = buckets[index];
                buckets[index] = bucket;

                bucket = next;
            }
        }
    }

    private int hash(K key) {
        if (key == null) return 0;
        return Math.floorMod(key.hashCode(), buckets.length);
    }

    static class Tuple<K, V> {
        K key;
        V val;
        Tuple<K, V> next;

        public Tuple(K key, V val) {
            this.key = key;
            this.val = val;
            next = null;
        }
    }
}
