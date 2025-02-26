package br.com.playwright.tools;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.util.Base64;

/**
 * Classe utilitária para capturar e manipular screenshots usando o Playwright.
 * <p>
 * Esta classe fornece métodos estáticos para capturar screenshots de páginas web
 * e convertê-los em diferentes formatos.
 * </p>
 */
public class ScreenshotUtils {

    /**
     * Captura um screenshot da página inteira.
     *
     * @param page A instância da Page do Playwright da qual o screenshot será capturado.
     * @return Um array de bytes contendo os dados do screenshot.
     */
    public static byte[] captureScreenshot(Page page) {
        return page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshot.png"))
                .setFullPage(true));
    }

    /**
     * Captura um screenshot da página inteira e o converte para uma string Base64.
     *
     * @param page A instância da Page do Playwright da qual o screenshot será capturado.
     * @return Uma string contendo o screenshot codificado em Base64.
     */
    public static String captureScreenshotAsBase64(Page page) {
        byte[] screenshot = captureScreenshot(page);
        return Base64.getEncoder().encodeToString(screenshot);
    }
}
