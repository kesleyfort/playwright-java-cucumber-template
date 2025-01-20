package br.com.playwright.steps.hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.*;

import java.util.List;

import static br.com.playwright.tools.LoadProperties.*;

public class Hooks {
    static Browser browser;
    static BrowserContext context;
    public static Page page;

    @Before
    public void setup() {
        loadProperties();
        if(getBrowser().equalsIgnoreCase("chrome")){
            List<String> argumentsList = List.of("--disable-notifications", "--start-maximized" );
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(argumentsList));
        } else if(getBrowser().equalsIgnoreCase("firefox")){
            browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        } else if(getBrowser().equalsIgnoreCase("perfecto")){
        }
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null));
        page = context.newPage();
        page.navigate(getURL());
    }

    @After
    public void closeBrowser() {
        context.close();
        browser.close();
    }
}
