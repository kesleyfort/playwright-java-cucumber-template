package br.com.playwright.tools;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TestDataReader {
    public static Map<String, Map<String, Object>> readCapabilities() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/test/resources/testData.json")) {
            Type type = new TypeToken<Map<String, Map<String, Object>>>(){}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}
