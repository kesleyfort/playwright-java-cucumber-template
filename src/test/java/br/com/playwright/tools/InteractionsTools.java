package br.com.playwright.tools;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.TimeoutError;

import java.util.List;

import static br.com.playwright.steps.hooks.Hooks.page;

public class InteractionsTools {
    /**
     * Retorna uma lista de elementos localizados na página com base no seletor fornecido.
     *
     * @param locator Uma string representando o seletor CSS ou XPath do elemento a ser localizado.
     * @return Uma lista de objetos Locator representando todos os elementos que correspondem ao seletor.
     * @throws TimeoutError Se o elemento não for encontrado dentro do tempo limite padrão.
     */
    public static List<Locator> getElements(String locator) {
        page.waitForSelector(locator);
        return page.locator(locator).all();
    }
    /**
     * Retorna um único elemento localizado na página com base no seletor fornecido.
     *
     * @param locator Uma string representando o seletor CSS ou XPath do elemento a ser localizado.
     * @return Um objeto Locator representando o primeiro elemento que corresponde ao seletor.
     * @throws TimeoutError Se o elemento não for encontrado dentro do tempo limite padrão.
     */
    public static Locator getElement(String locator) {
        page.waitForSelector(locator);
        return page.locator(locator);
    }
    /**
     * Realiza um clique em um elemento da página identificado pelo seletor fornecido.
     *
     * @param locator Uma string representando o seletor CSS ou XPath do elemento a ser clicado.
     * @throws TimeoutError Se o elemento não for encontrado dentro do tempo limite padrão.
     */
    public static void click(String locator) {
        getElement(locator).click();
    }
    /**
     * Preenche um elemento de entrada de texto na página com o valor fornecido.
     *
     * @param locator Uma string representando o seletor CSS ou XPath do elemento de entrada de texto.
     * @param value O texto a ser inserido no elemento.
     * @throws TimeoutError Se o elemento não for encontrado dentro do tempo limite padrão.
     */
    public static void setText(String locator, String value) {
        getElement(locator).fill(value);
    }
    /**
     * Navega para a URL especificada.
     *
     * @param url Uma string contendo a URL completa para a qual se deseja navegar.
     * @throws TimeoutError Se a navegação não for concluída dentro do tempo limite padrão.
     */
    public static void navigateTo(String url) {
        page.navigate(url);
    }
    /**
     * Simula a pressão de uma tecla em um elemento específico da página.
     *
     * @param locator Uma string representando o seletor CSS ou XPath do elemento alvo.
     * @param key Uma string representando a tecla a ser pressionada (por exemplo, "Enter", "ArrowDown", etc.).
     * @throws TimeoutError Se o elemento não for encontrado dentro do tempo limite padrão.
     */
    public static void sendKeys(String locator, String key){
        getElement(locator).press(key);
    }
    /**
     * Verifica se um elemento está presente e visível na página.
     *
     * @param locator Uma string representando o seletor CSS ou XPath do elemento a ser verificado.
     * @return true se o elemento estiver presente e visível, false caso contrário.
     * @throws TimeoutError Se o elemento não for encontrado dentro do tempo limite padrão.
     */
    public static boolean isPresent(String locator) {
        page.waitForSelector(locator);
        return page.locator(locator).isVisible();
    }
    /**
     * Verifica se todos os elementos correspondentes ao seletor estão visíveis na página.
     *
     * @param locator Uma string representando o seletor CSS ou XPath dos elementos a serem verificados.
     * @throws AssertionError Se algum dos elementos não estiver visível, com uma mensagem indicando o índice do elemento não visível.
     * @throws TimeoutError Se os elementos não forem encontrados dentro do tempo limite padrão.
     */
    public static void areVisible(String locator) {
        List<Locator> els = getElements(locator);
        for(int i = 0; i < els.size(); i++) {
            assert els.get(i).isVisible() : "Element at index " + i + " is not visible";
        }
    }
}
