package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//input[@name='q'][@type='text']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@name='btnK']") //  //descendant-or-self::input[@name='btnK'][2]
    private WebElement searchButton;

    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @FindBy(xpath = "//div[@role='button'][@jscontroller='unV4T']")
    private WebElement searchByVoiceButton;


    public SearchPage() {
        super();
    }

    public void fillSearchField(String searchText) {
        searchField.click();
        searchField.sendKeys(searchText);
    }

    public void pressEnter() {
        searchField.sendKeys(Keys.ENTER);
    }

    public void clickSearchButtonOrEnter() {
        if (isElementFound(By.xpath("//input[@name='btnK']"), 3)) {
            driverWait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchButton.click();
            System.out.println("Was used Click Button");
        } else {
            pressEnter();
            System.out.println("Was used ENTER Button");
        }
    }

    public void moveToSearchVoiceButton() {
        action.moveToElement(searchByVoiceButton).build().perform();
    }

    public void checkMoveToSearchVoiceButtonText(String text) {
        assertThat(pageBody.findElements(By.xpath("//*[contains(text(),'" + text + "')]")).size())
                .as("Wrong tooltip " + text + ".").isNotZero();
        System.out.println("Tooltip was checked");
    }
}
