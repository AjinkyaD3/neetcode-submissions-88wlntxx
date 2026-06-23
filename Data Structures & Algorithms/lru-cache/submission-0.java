class LRUCache {
    LRUCachee<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LRUCachee<>(capacity);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}

class LRUCachee<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCachee(int cap) {
        super(cap, 0.75f, true);
        this.capacity = cap;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}