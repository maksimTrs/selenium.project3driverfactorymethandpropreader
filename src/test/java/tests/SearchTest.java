package tests;

import org.testng.annotations.Test;
import utils.PropertyReader;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataProvider1")
    public void openGoogleComPage(String searchText) {
        steps.executeSearchByKeyWord(searchText)
                .verifyTopResultContainsCorrectText(searchText)
                .verifyTopResultContainsProperAttrText(PropertyReader.getAttrValue());
        System.out.println("Test SearchTest openGoogleComPage() successfully  passed");
        snapshotTestFile();
    }

    @Test
    public void testVoiceSearcher() {
        steps.openToolTip().checkToolTip(PropertyReader.getToolTipValue());  //"Голосовой поиск"
        System.out.println("Test SearchTest testVoiceSearcher() successfully  passed");
        snapshotTestFile();
    }
}
