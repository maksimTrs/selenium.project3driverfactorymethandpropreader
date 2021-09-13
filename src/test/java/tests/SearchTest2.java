package tests;

import org.testng.annotations.Test;
import utils.PropertyReader;

public class SearchTest2 extends BaseTest {

    @Test(dataProvider = "dataProvider1")
    public void openGoogleComPageTest2(String searchText) {


        steps.executeSearchByKeyWord(searchText).verifyListResultOfFirstPageContainsText(PropertyReader.getTextValue());

        System.out.println("Test SearchTest2 openGoogleComPage() successfully  passed");
        snapshotTestFile();
    }
}
