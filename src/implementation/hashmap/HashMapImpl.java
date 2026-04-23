package implementation.hashmap;

import java.util.Arrays;
import java.util.Objects;

public class HashMapImpl<K, V> {

    private static final int INITIAL_CAPACITY = 10;
    private static final float LOAD_FACTOR = 0.75f;

    private Tuple<K, V>[] buckets;
    private int size;

    public HashMapImpl() {
        this.buckets = new Tuple[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void put(K key, V val) {
        var index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new Tuple<>(key, val);
        } else {
            var curr = buckets[index];
            var prev = curr;
            while (curr != null) {
                if (Objects.equals(curr.key, key)) {
                    curr.val = val;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
            prev.next = new Tuple<>(key, val);
        }
        size++;
        if (size >= buckets.length * LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        var index = hash(key);
        var curr = buckets[index];
        while (curr != null) {
            if (Objects.equals(curr.key, key)) {
                return curr.val;
            }
            curr = curr.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        var index = hash(key);
        var curr = buckets[index];
        while (curr != null) {
            if (Objects.equals(curr.key, key)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public boolean containsValue(V val) {
        for (Tuple<K, V> bucket : buckets) {
            var curr = bucket;
            while (curr != null) {
                if (Objects.equals(curr.val, val)) {
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }

    //TODO
    public V remove(K key) {
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }

    private void resize() {
        var oldBuckets = buckets;
        this.buckets = new Tuple[oldBuckets.length * 2];
        this.size = 0;
        for (Tuple<K, V> oldBucket : oldBuckets) {
            var curr = oldBucket;
            while (curr != null) {
                put(curr.key, curr.val);
                curr = curr.next;
            }
        }
    }

    private int hash(K key) {
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
