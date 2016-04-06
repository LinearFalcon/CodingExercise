package edu.nyu.liangfang.codefactory;

/**
 * Implementation of HashMap using array
 *
 * @param <K>
 * @param <V>
 */
public class hashMapImpl<K, V> {
    // usually initial size of hash map is power of 2
    private static final int SIZE = 16;
    private Entry[] table = new Entry[SIZE];

    class Entry<K, V> {
        final K key;
        V value;
        Entry next;

        Entry(K k, V v) {
            key = k;
            value = v;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }
    }

    /**
     * Returns the entry associated with the specified key in the
     * HashMap.  Returns null if the HashMap contains no mapping
     * for the key.
     */
    public V get(K k) {
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];

        // if bucket is found then traverse through the linked list and
        // see if element is present
        while (e != null) {
            if (e.key.equals(k)) {
                return (V) e.value;
            }
            e = e.next;
        }
        return null;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     */
    public void put(K k, V v) {
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];
        if (e != null) {
            // it means we are trying to insert duplicate
            // key-value pair, hence overwrite the current
            // pair with the old pair
            if (e.key.equals(k)) {
                e.value = v;
            } else {
                // traverse to the end of the list and insert new element 
                // in the same bucket
                while (e.next != null) {
                    e = e.next;
                }
                Entry newEntry = new Entry(k, v);
                e.next = newEntry;
            }
        } else {
            // new element in the map, hence creating new bucket
            Entry newEntry = new Entry(k, v);
            table[hash] = newEntry;
        }
    }
}

