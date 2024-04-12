package com.parabank.pom.testcases;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

public abstract class BaseTest {

    static Page page=null;
    protected Properties prop;


    public BaseTest() {
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void initBrowser() {
        String browserName = prop.getProperty("browserName");
        Playwright playwright;
        Browser browser = null;
        BrowserContext browserContext;
        playwright = Playwright.create();

        switch (browserName) {
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                System.out.println("Please pass the right Browser");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(prop.getProperty("baseUrl"));


    }

    @AfterMethod
    public void tearDown() {
        page.screenshot(
                new Page.ScreenshotOptions()
                        .setPath(Paths.get(System.getProperty("user.dir") + "/build/screenShots/" + System.currentTimeMillis() + ".png"))
                        .setFullPage(true)
        );
        page.context().browser().close();

    }

    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        //getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));

        byte[] buffer = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        String base64Path = Base64.getEncoder().encodeToString(buffer);

        return base64Path;
    }

//    public  Page getPage() {
//        return page;
//    }
}
