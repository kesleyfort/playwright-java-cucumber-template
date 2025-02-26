package br.com.playwright.interactions;

import br.com.playwright.pages.ExamplePage;
import com.microsoft.playwright.Locator;
import org.junit.Assert;

import java.util.regex.Pattern;

import static br.com.playwright.steps.hooks.Hooks.page;
import static br.com.playwright.tools.LoadProperties.getURL;
import static br.com.playwright.tools.InteractionsTools.getElements;
import static br.com.playwright.tools.InteractionsTools.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * Classe que contém as interações com a página de exemplo.
 * Esta classe estende ExamplePage e implementa os métodos de interação com os elementos da página.
 */
public class ExampleInteractions extends ExamplePage {
    /** Nome do produto selecionado. */
    static String productName;
    /** Preço do produto selecionado. */
    static String productPrice;

    /**
     * Acessa o site especificado.
     * @param site URL do site a ser acessado.
     */
    public void acessoSite(String site) {
        navigateTo(site);
    }

    /**
     * Realiza uma pesquisa no site.
     * @param string Termo a ser pesquisado.
     */
    public void pesquisarPor(String string) {
        click(searchButton);
        setText(searchInput, string);
        sendKeys(searchInput, "Enter");
    }

    /**
     * Valida os resultados da pesquisa.
     * Verifica se a lista de resultados está presente e visível, e se há cards de produtos visíveis.
     */
    public void validarResultados() {
        Assert.assertTrue("Nenhum resultado encontrado.", isPresent(resultsList));
        assertThat(getElement(resultsList)).isVisible();
        Assert.assertFalse("Nenhum card de produto está visível.", getElements(productCardsList).isEmpty());
        areVisible(productCardsList);
    }

    /**
     * Clica no resultado que contém o texto especificado.
     * @param texto Texto a ser procurado nos resultados.
     */
    public void clicarResultadoComTexto(String texto) {
        Locator resultado = page.locator(productCardsList).filter(new Locator.FilterOptions().setHasText(texto)).first();
        productName = resultado.locator("h2").innerText();
        productPrice = resultado.locator("product-card-price").getAttribute("price").replace("R$ ", "");
        resultado.click();
    }

    /**
     * Valida a página do produto.
     * Verifica se o título e o preço do produto correspondem aos dados salvos anteriormente.
     */
    public void validarPaginaDoProduto() {
        Locator titulo = getElement(productTitlePdp);
        assertThat(titulo).hasText(productName);
        Locator preco = getElement(productPricePdp);
        assertThat(preco).hasText("R$ " + String.valueOf(productPrice).replace(".", ","));
    }

    /**
     * Clica no resultado na posição especificada.
     * @param posicao Posição do resultado a ser clicado.
     */
    public void clicarResultadoPosicao(int posicao) {
        Locator resultado = page.locator(productCardsList).nth(posicao);
        resultado.click();
    }

    /**
     * Valida se o site atual é o site que deve ser acessado.
     * Verifica a URL, o título da página, a visibilidade do campo de pesquisa e do logo.
     */
    public void validarSite() {
        Pattern titulo = Pattern.compile(".*(Camicado).*");
        assertThat(page).hasURL(getURL());
        assertThat(page).hasTitle(titulo);
        assertThat(getElement(searchInput)).isVisible();
        assertThat(page.getByAltText("Logo da Camicado")).isVisible();
    }
}
