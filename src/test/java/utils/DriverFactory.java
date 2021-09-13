package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(Browser browser) {

        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

    public static WebDriver getDriverForHeadlessMode(Browser browser) {

        switch (browser) {
            case CHROME:
                ChromeOptions options = new ChromeOptions(); // ставим режим запуска тестов без браузера (фоновый режим) через setHeadless(true)
                options.setHeadless(true);
                options.addArguments("window-size=1920,1080");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                FirefoxOptions ffOptions = new FirefoxOptions();
                // ffOptions.setProfile(new FirefoxProfile());
                ffOptions.setHeadless(true);
                ffOptions.addArguments("window-size=1920,1080");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(ffOptions);
                break;
        }
        return driver;
    }
}
