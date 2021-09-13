package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import steps.SearchSteps;
import utils.DriverFactory;
import utils.PropertyReader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public abstract class BaseTest {

    private static WebDriver driver;
    SearchSteps steps;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        boolean testMode = false;
        if (testMode) {
            driver = DriverFactory.getDriver(PropertyReader.getBrowserValue());
            // driver = DriverFactory.getDriver(Browser.FIREFOX);
            driver.manage().window().maximize();
        } else {
            driver = DriverFactory.getDriverForHeadlessMode(PropertyReader.getBrowserValue());
            // driver = DriverFactory.getDriverForHeadlessMode(Browser.FIREFOX);
        }
        driver.get(PropertyReader.getUrl());  // https://www.google.com/
        steps = new SearchSteps();
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().back();
    }

    @DataProvider(name = "dataProvider1") // parallel = true
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"Selenium"}, {"Selenium Java"}};
    }


    public void snapshotTestFile() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Saratov"));
        String fileName = dateFormat.format(currentDate) + ".png";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("D:\\SelenTestFiles\\" + fileName));
            System.out.println("Screenshot was saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
