package br.com.playwright.steps.hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.*;

import java.util.List;

import static br.com.playwright.tools.LoadProperties.*;

/**
 * Classe responsável por gerenciar os hooks do Cucumber para configuração e limpeza do ambiente de teste.
 */
public class Hooks {
    /** Instância do navegador utilizada nos testes. */
    static Browser browser;
    /** Contexto do navegador para os testes. */
    static BrowserContext context;
    /** Página atual do navegador. */
    public static Page page;

    /**
     * Configura o ambiente de teste antes da execução de cada cenário.
     * Este método é executado antes de cada cenário de teste.
     *
     * @throws IllegalArgumentException se o navegador especificado não for suportado.
     */
    @Before
    public void setup() {
        loadProperties();
        if(getBrowser().equalsIgnoreCase("chrome")){
            List<String> argumentsList = List.of("--disable-notifications", "--start-maximized" );
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(argumentsList));
        } else if(getBrowser().equalsIgnoreCase("firefox")){
            browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        } else throw new IllegalArgumentException("Navegador inválido");
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null));
        page = context.newPage();
        page.navigate(getURL());
    }

    /**
     * Limpa o ambiente de teste após a execução de cada cenário.
     * Este método é executado após cada cenário de teste, fechando o contexto e o navegador.
     */
    @After
    public void closeBrowser() {
        context.close();
        browser.close();
    }
}
