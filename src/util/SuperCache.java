package util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SuperCache {
    
    private Map<String, List<Map<String, Object>>> cache;

    public SuperCache() {
        this.cache = new HashMap<>();
    }

    public void addCache(String filename, List<Map<String, Object>> data) {
        cache.put(filename, data);
    }

    public List<Map<String, Object>> getCache(String filename) {
        return cache.getOrDefault(filename, new LinkedList<>());
    }

    public void clearCache(String filename) {
        cache.remove(filename);
    }

}
