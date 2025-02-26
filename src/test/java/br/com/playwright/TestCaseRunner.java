package br.com.playwright;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Classe responsável por executar os testes de aceitação usando Cucumber e JUnit.
 * Esta classe configura e inicia a execução dos cenários de teste definidos nas features.
 * <p>
 * A anotação @RunWith(Cucumber.class) indica que esta classe será executada pelo JUnit usando o runner do Cucumber.
 * <p>
 * A anotação @CucumberOptions configura como o Cucumber deve executar os testes:
 * <p>
 * - features: Define o diretório onde estão localizados os arquivos de feature do Cucumber.
 *             Neste caso, "src/test/java/br/com/playwright/features".
 * <p>
 *
 * - glue: Define o pacote onde estão localizadas as classes de definição de passos (step definitions).
 *         Neste caso, "br.com.playwright.steps".
 * <p>
 *
 * - plugin: Configura os plugins do Cucumber para geração de relatórios e informações adicionais.
 *           - "pretty": Gera uma saída formatada no console.
 *           - "html:target/cucumber-reports.html": Gera um relatório HTML na pasta target.
 *           - "br.com.playwright.tools.StepInfoPlugin": Plugin personalizado para informações adicionais dos passos.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/br/com/playwright/features",
        glue = {"br.com.playwright.steps"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "br.com.playwright.tools.StepInfoPlugin"})
public class TestCaseRunner {
    // Esta classe não precisa de nenhum método, pois serve apenas como ponto de entrada para o Cucumber.
}
