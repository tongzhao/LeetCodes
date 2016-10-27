import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {
    private HashMap<Integer, Entry> map;
    private final int CAPACITY;
    private int size;
    private Entry head;

    private class Entry{
        private int key;
        private int value;
        private Entry prev;
        private Entry next;
        private Entry(){}
        private Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int cap) {
        CAPACITY = cap;
        map = new HashMap<Integer, Entry>();
        size = 0;
        head = new Entry();
        head.next = head;
        head.prev = head;
    }

    public int get(int key) {
        Entry entry = map.get(key);
        if (entry==null) return -1;
        detach(entry);
        addFirst(entry);
        return entry.value;
    }

    public void set(int key, int value) {
        Entry entry = map.get(key);
        if (entry==null) {
            if (size==CAPACITY) {
                removeFromLast();
                size--;
            }
            entry = new Entry(key, value);
            addFirst(entry);
            size++;
            map.put(key, entry);
        } else {
            entry.value = value;
            detach(entry);
            addFirst(entry);
        }
    }

    public void detach(Entry entry) {
        entry.prev.next = entry.next;
        entry.next.prev = entry.prev;
    }
    public void addFirst(Entry entry) {
        entry.next = head.next;
        head.next.prev = entry;
        entry.prev = head;
        head.next = entry;
    }
    public void removeFromLast() {
        Entry entry = head.prev;
        entry.prev.next = head;
        entry.next.prev = entry.prev;
        entry.next = null;
        entry.prev = null;
        map.remove(entry.key);
    }
}
