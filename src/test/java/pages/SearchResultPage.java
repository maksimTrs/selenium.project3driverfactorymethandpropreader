package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage extends BasePage {

    @FindBy(css = "div>input[name='q']")
    WebElement resultRow;

    @FindBy(xpath = "//div[@class='g']//h3")
    WebElement resultFirstH3Header;

    @FindBy(xpath = "//div[@class='g']//following-sibling::div[not(contains(@class, 'ULSxyf'))]//a/h3")
    List<WebElement> searhResultInFirstPageH3;

    //private By resultRow = By.cssSelector("div>input[name='q']");
    // //div[@class='tF2Cxc']//div[@class='IsZvec']//span[contains (em, 'Selenium') or contains (em, 'selenium')]

    public SearchResultPage() {
        super();
    }

    public void assertTopResultHasCorrectText(String expectedText) {
        String searchResultPrint = resultRow.getAttribute("value");
        assertThat(resultRow.isDisplayed()).as("Search Field isn't visible!").isTrue();
        assertThat(searchResultPrint.toLowerCase()).as("Search text doesn't contain \"Selenium\" word!").contains(expectedText);
    }


    public void assertTopResultHasProperAttrText(String expectedText) {
        String searchResultAttrClass = resultRow.getAttribute("class");
        assertThat(searchResultAttrClass).as("Search attribute class doesn't have current value!").contains(expectedText);
    }

    public void checkExpectedConditionH3Result() {
        //new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(resultFirstH3Header));
        driverWait.until(ExpectedConditions.elementToBeClickable(resultFirstH3Header));
    }

    public void checkExpectedListOf1stResultPage(String expectedText) {
        List<WebElement> searhResultInFirstPage = searhResultInFirstPageH3; //driver.findElements(searhResultInFirstPageH3);
        driverWait.until(ExpectedConditions.visibilityOfAllElements(searhResultInFirstPageH3));

        int searchCount = 1;
        for (WebElement eachPageElement : searhResultInFirstPage) {
            String h3Text = eachPageElement.getText();
            System.out.println("H3 result № " + searchCount + " = " + h3Text);
            searchCount++;
        }
        assertThat(searhResultInFirstPage)
                .as("h3 header doesn't have \"Selenium\" word in the text")
                .allMatch(s -> s.getText().toLowerCase().contains(expectedText));
    }
}
