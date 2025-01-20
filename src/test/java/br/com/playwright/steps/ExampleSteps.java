package br.com.playwright.steps;

import br.com.playwright.interactions.ExampleInteractions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class ExampleSteps {
    ExampleInteractions exampleInteractions = new ExampleInteractions();

    @Quando("eu acesso o site {string}")
    public void eu_acesso_o_site(String string) {
        exampleInteractions.acessoSite(string);
    }
    @Quando("pesquiso por {string}")
    public void pesquiso_por(String string) {
        exampleInteractions.pesquisarPor(string);
    }
    @Entao("vejo a lista de resultados")
    public void vejo_a_lista_de_resultados_contendo_e() {
       exampleInteractions.validarResultados();
    }

    @Quando("clico no resultado com texto {string}")
    public void clicoNoResultadoComTexto(String texto) {
        exampleInteractions.clicarResultadoComTexto(texto);
    }

    @Então("vejo a página do produto")
    public void vejoAPaginaDoProduto() {
        exampleInteractions.validarPaginaDoProduto();
    }

    @Dado("que eu estou no site camicado")
    public void queEuEstouNoSiteCamicado() {
        exampleInteractions.validarSite();
    }
}