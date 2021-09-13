package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static tests.BaseTest.getDriver;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait driverWait;
    Actions action;

    public BasePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
        driverWait = new WebDriverWait(driver, 10);
        action = new Actions(driver);
    }

    boolean isElementFound(By by, int timeout) {
        List<WebElement> listWebElements = driver.findElements(by);
        for (int i = 0; (i < timeout) && (listWebElements.size() == 0); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listWebElements = driver.findElements(by);
        }
        return listWebElements.size() > 0;
    }
}
