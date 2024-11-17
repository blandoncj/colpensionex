package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class CSVHandler<T> {

    private String filePath;
    private List<Map<String, Object>> cache;

    public CSVHandler(String filePath) {
        this.filePath = filePath;
        this.cache = new LinkedList<>();
        loadCache();
    }

    public List<T> readRows() {
        List<T> entities = new LinkedList<>();
        for (Map<String, Object> row : cache) {
            entities.add(mapToEntity(row));
        }
        return entities;
    }

    public void writeRow(T element) {
        Map<String, Object> row = entityToMap(element);
        cache.add(row);
        saveToFile();
    }

    private void loadCache() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String[] headers = br.readLine().split(",");
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    row.put(headers[i], values[i]);
                }
                cache.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            if (!cache.isEmpty()) {
                String headers = String.join(",", cache.get(0).keySet());
                bw.write(headers);
                bw.newLine();

                for (Map<String, Object> row : cache) {
                    String line = String.join(",", row.values().toString());
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract Map<String, Object> entityToMap(T entity);
    protected abstract T mapToEntity(Map<String, Object> row);

}
