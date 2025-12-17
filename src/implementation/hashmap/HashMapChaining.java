package implementation.hashmap;

public class HashMapChaining<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Integer size;
    private Entry<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public HashMapChaining() {
        this.size = 0;
        this.buckets = new Entry[INITIAL_CAPACITY];
    }

    private int hash(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode() % buckets.length);
    }

    public void put(K key, V value) {
        int index = hash(key);
        var newEntry = new Entry<>(key, value);

        if (buckets[index] == null) {
            buckets[index] = newEntry;
            size++;
        } else {
            Entry<K, V> before = null;
            Entry<K, V> actual = buckets[index];

            while (actual != null) {
                if (actual.key.equals(key)) {
                    actual.value = value;
                    return;
                }
                before = actual;
                actual = actual.next;
            }
            before.next = newEntry;
            size++;
        }

        if (size > buckets.length * LOAD_FACTOR) {
            resize();
        }

    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> actual = buckets[index];
        while (actual != null) {
            if (actual.key.equals(key)) {
                return actual.value;
            }
            actual = actual.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        Entry<K, V> actual = buckets[index];
        Entry<K, V> before = null;

        while (actual != null) {
            if (actual.key.equals(key)) {
                if (before == null) {
                    buckets[index] = actual.next;
                } else {
                    before.next = actual.next;
                }
                size--;
                return actual.value;
            }
            before = actual;
            actual = actual.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        var oldBucket = buckets;
        buckets = new Entry[buckets.length * 2];
        size = 0;

        for (Entry<K, V> bucket : oldBucket) {
            while (bucket != null) {
                put(bucket.key, bucket.value);
                bucket = bucket.next;
            }
        }
    }

    public void show() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                Entry<K, V> actual = buckets[i];
                System.out.print("Index " + i + ": ");
                while (actual != null) {
                    System.out.print("[" + actual.key + "=" + actual.value + "] ");
                    actual = actual.next;
                }
                System.out.println();
            }
        }
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
