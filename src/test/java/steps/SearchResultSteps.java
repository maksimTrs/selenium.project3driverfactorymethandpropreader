package steps;

import pages.SearchResultPage;

public class SearchResultSteps {

    private SearchResultPage searchResultPage = new SearchResultPage();


    public SearchResultSteps verifyTopResultContainsCorrectText(String keyWord) {
        searchResultPage.checkExpectedConditionH3Result();
        searchResultPage.assertTopResultHasCorrectText(keyWord.toLowerCase());
        return this;
    }

    public SearchResultSteps verifyTopResultContainsProperAttrText(String keyWord) {
        searchResultPage.checkExpectedConditionH3Result();
        searchResultPage.assertTopResultHasProperAttrText(keyWord);
        return this;
    }

    public SearchResultSteps verifyListResultOfFirstPageContainsText(String keyWord) {
        //searchResultPage.checkExpectedConditionH3Result();
        searchResultPage.checkExpectedListOf1stResultPage(keyWord);
        return this;
    }

}
