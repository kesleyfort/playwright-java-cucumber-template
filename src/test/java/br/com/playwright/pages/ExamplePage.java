package br.com.playwright.pages;

/**
 * Esta classe é utilizada para armazenar os localizadores dos elementos da interface do usuário
 * que serão utilizados nos testes automatizados.
 */
public class ExamplePage {
    /** Seletor para o campo de entrada de pesquisa. */
    public String searchInput = "#automation-search-icon-template-input-id";

    /** Seletor para o botão de pesquisa. */
    public String searchButton = "#automation-search-icon-template-input-id";

    /** Seletor para a lista de resultados da pesquisa. */
    public String resultsList = "#js-productCardContainer";

    /** Seletor para a lista de cards de produtos. */
    public String productCardsList = "product-card-square-listing";

    /** Seletor para o título do produto na página de detalhes do produto (PDP). */
    public String productTitlePdp = "div.desktop-layout div.product-name h1";

    /** Seletor para o preço do produto na página de detalhes do produto (PDP). */
    public String productPricePdp = "div.desktop-layout text-label.price div.label";
}
