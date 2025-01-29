package br.com.playwright.tools;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.util.Base64;

public class ScreenshotUtils {

    public static byte[] captureScreenshot(Page page) {
        return page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshot.png"))
                .setFullPage(true));
    }

    public static String captureScreenshotAsBase64(Page page) {
        byte[] screenshot = captureScreenshot(page);
        return Base64.getEncoder().encodeToString(screenshot);
    }
}