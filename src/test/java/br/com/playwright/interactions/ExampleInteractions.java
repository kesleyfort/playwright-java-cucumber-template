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

public class ExampleInteractions extends ExamplePage {
    static String productName;
    static String productPrice;

    public void acessoSite(String site) {
        navigateTo(site);
    }

    public void pesquisarPor(String string) {
        click(searchButton);
        setText(searchInput, string);
        sendKeys(searchInput, "Enter");
    }

    public void validarResultados() {
        Assert.assertTrue("Nenhum resultado encontrado.", isPresent(resultsList));
        assertThat(getElement(resultsList)).isVisible();
        Assert.assertFalse("Nenhum card de produto está visível.", getElements(productCardsList).isEmpty());
        areVisible(productCardsList);


    }

    public void clicarResultadoComTexto(String texto) {
        Locator resultado = page.locator(productCardsList).filter(new Locator.FilterOptions().setHasText(texto)).first();
        productName = resultado.locator("h2").innerText();
        productPrice = resultado.locator("product-card-price").getAttribute("price").replace("R$ ", "");
        resultado.click();
    }

    public void validarPaginaDoProduto() {
        Locator titulo = getElement(productTitlePdp);
        assertThat(titulo).hasText(productName);
        Locator preco = getElement(productPricePdp);
        assertThat(preco).hasText("R$ " + String.valueOf(productPrice).replace(".", ","));
    }

    public void clicarResultadoPosicao(int posicao) {
        Locator resultado = page.locator(productCardsList).nth(posicao);
        resultado.click();
    }

    public void validarSite() {
        Pattern titulo = Pattern.compile(".*(Camicado).*");
        assertThat(page).hasURL(getURL());
       assertThat(page).hasTitle(titulo);
       assertThat(getElement(searchInput)).isVisible();
       assertThat(page.getByAltText("Logo da Camicado")).isVisible();
    }
}
