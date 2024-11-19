package util;

import java.util.*;

public class SuperCache {
    private Map<String, List<Map<String, Object>>> cache;

    public SuperCache() {
        this.cache = new HashMap<>();
    }

    public void addCache(String archivo, List<Map<String, Object>> datos) {
        cache.put(archivo, datos);
    }

    public List<Map<String, Object>> getCache(String archivo) {
        return cache.getOrDefault(archivo, new LinkedList<>());
    }

    public void cleanCache(String archivo) {
        cache.remove(archivo);
    }

    public boolean fileExistsInCache(String archivo) {
        return cache.containsKey(archivo);
    }

    public Set<String> getCachedFiles() {
        return cache.keySet();
    }
}