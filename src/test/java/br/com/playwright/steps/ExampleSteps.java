package br.com.playwright.steps;

import br.com.playwright.interactions.ExampleInteractions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

/**
 * Classe que contém os passos de teste para uma determinada funcionalidade.
 * Esta classe implementa os métodos correspondentes aos passos definidos nos arquivos de feature do Cucumber.
 */
public class ExampleSteps {
    ExampleInteractions exampleInteractions = new ExampleInteractions();

    /**
     * Método que acessa um site específico.
     * @param string URL do site a ser acessado.
     */
    @Quando("eu acesso o site {string}")
    public void eu_acesso_o_site(String string) {
        exampleInteractions.acessoSite(string);
    }

    /**
     * Método que realiza uma pesquisa no site.
     * @param string Termo a ser pesquisado.
     */
    @Quando("pesquiso por {string}")
    public void pesquiso_por(String string) {
        exampleInteractions.pesquisarPor(string);
    }

    /**
     * Método que valida se a lista de resultados da pesquisa é exibida.
     */
    @Entao("vejo a lista de resultados")
    public void vejo_a_lista_de_resultados_contendo_e() {
       exampleInteractions.validarResultados();
    }

    /**
     * Método que clica em um resultado específico da pesquisa.
     * @param texto Texto do resultado a ser clicado.
     */
    @Quando("clico no resultado com texto {string}")
    public void clicoNoResultadoComTexto(String texto) {
        exampleInteractions.clicarResultadoComTexto(texto);
    }

    /**
     * Método que valida se a página do produto é exibida.
     */
    @Entao("vejo a página do produto")
    public void vejoAPaginaDoProduto() {
        exampleInteractions.validarPaginaDoProduto();
    }

    /**
     * Método que valida se o usuário está no site Camicado.
     */
    @Dado("que eu estou no site camicado")
    public void queEuEstouNoSiteCamicado() {
        exampleInteractions.validarSite();
    }
}
