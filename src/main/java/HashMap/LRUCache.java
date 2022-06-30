package HashMap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    Integer capacity;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            value = map.remove(key);
            map.put(key,value);
        }
        return value;
    }

    public void put(int key, int value) {
        if (this.capacity == map.size()){
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            Map.Entry<Integer, Integer> tail = null;
            while (iterator.hasNext()) {
                tail = iterator.next();
            }
            map.remove(tail);
        }
        map.put(key,value);
    }
}
