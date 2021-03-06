package code.character;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName Lru
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-06-04 18:12
 **/
public class Lru {
    static class LRUCache {
        private Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<Integer, Integer>(capacity, (float) 0.75, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return map.size() > capacity;
                }
            };
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.put(key, value);
        }

    }
}
