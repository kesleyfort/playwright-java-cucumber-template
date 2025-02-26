package br.com.playwright.tools;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável pela leitura de dados de teste a partir de um arquivo JSON.
 */
public class TestDataReader {
    
    /**
     * Lê as capacidades (capabilities) do arquivo JSON de dados de teste.
     *
     * @return Um mapa contendo as capacidades lidas do arquivo JSON. A estrutura do mapa é:
     *         - Chave externa: String representando o nome da capacidade
     *         - Valor: Outro mapa onde:
     *           - Chave: String representando o nome da propriedade
     *           - Valor: Object representando o valor da propriedade
     *
     * @throws RuntimeException se ocorrer um erro durante a leitura ou parsing do arquivo JSON.
     *         O erro original (IOException) é impresso no console.
     */
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
