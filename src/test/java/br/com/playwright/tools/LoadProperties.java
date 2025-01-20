package br.com.playwright.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por carregar e fornecer acesso às propriedades de configuração do sistema.
 */
public class LoadProperties {
    static Properties properties = new Properties();

    /**
     * Retorna o ambiente de execução configurado.
     *
     * @return Uma String representando o ambiente de execução (por exemplo, "PRD" para produção ou "HML" para homologação).
     */
    public static String getEnvironment() {
        return properties.getProperty("AMBIENTE");
    }

    /**
     * Retorna o navegador configurado para os testes.
     *
     * @return Uma String representando o navegador a ser utilizado.
     */
    public static String getBrowser() {
        return properties.getProperty("NAVEGADOR");
    }

    /**
     * Retorna a URL do ambiente de teste com base no ambiente configurado.
     *
     * @return A URL do ambiente de teste.
     * @throws IllegalArgumentException Se o ambiente configurado for inválido.
     */
    public static String getURL() {
        if(getEnvironment().equalsIgnoreCase("PRD"))
            return properties.getProperty("URL_PRD");
        else if(getEnvironment().equalsIgnoreCase("HML"))
            return properties.getProperty("URL_HML");
        else
            throw new IllegalArgumentException("Ambiente inválido");
    }

    /**
     * Retorna o token de autenticação para a plataforma Perfecto.
     *
     * @return Uma String contendo o token de autenticação do Perfecto.
     */
    public static String getTokenPerfecto() {
        return properties.getProperty("TOKEN_PERFECTO");
    }

    /**
     * Retorna a URL da plataforma Perfecto.
     *
     * @return Uma String contendo a URL do Perfecto.
     */
    public static String getURLPerfecto() {
        return properties.getProperty("URL_PERFECTO");
    }

    /**
     * Carrega as propriedades do arquivo de configuração.
     * Este método deve ser chamado antes de utilizar qualquer outro método desta classe.
     *
     * @throws RuntimeException Se ocorrer um erro ao ler o arquivo de configuração.
     */
    public static void loadProperties() {
        try (InputStream input = LoadProperties.class.getClassLoader().getResourceAsStream("testconfigs.properties")) {
            if (input == null) {
                Logger.getLogger(LoadProperties.class.getName()).log(Level.SEVERE, "Não foi possível encontrar config.properties");
                return;
            }
            
            properties.load(input);
        } catch (IOException ex) {
            Logger.getLogger(LoadProperties.class.getName()).log(Level.SEVERE, "Erro ao carregar as propriedades", ex);
            throw new RuntimeException(ex);
        }
    }
}
