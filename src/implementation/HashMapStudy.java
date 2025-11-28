package implementation;

public class HashMapStudy<K, V> {
    private static final int INITIAL_CAPACITY = 1;

    private Tuple<K, V>[] buckets;
    private int size;

    public HashMapStudy() {
        this.buckets = new Tuple[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void put(K key, V value) {
        var index = hash(key);

        if (size >= buckets.length) {
            resize();
        }

        if (buckets[index] == null) {
            buckets[index] = new Tuple<>(key, value);
            size++;
        } else {
            var bucket = buckets[index];
            if (bucket.key.equals(key)) {
                bucket.value = value;
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

    private void resize() {
        var oldBuckets = buckets;
        this.buckets = new Tuple[buckets.length * 2];
        this.size = 0;

        for (Tuple<K, V> oldBucket : oldBuckets) {
            int index = hash(oldBucket.key);
            buckets[index] = new Tuple<>(oldBucket.key, oldBucket.value);
        }
    }

    private int hash(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode() % buckets.length);
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (Tuple<K, V> bucket : buckets) {
            if (bucket != null) {
                sb.append("[ Key: ").append(bucket.key).append(", Value: ").append(bucket.value).append(" ]");
            } else {
                sb.append("null");
            }
        }
        return sb.toString();
    }


    static class Tuple<K, V> {
        K key;
        V value;

        Tuple(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

}
