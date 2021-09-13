package steps;

import pages.SearchPage;

public class SearchSteps {

    private SearchPage searchPage = new SearchPage();

    public SearchResultSteps executeSearchByKeyWord(String keyWord) {
        searchPage.fillSearchField(keyWord);
        // searchPage.pressEnter();
        searchPage.clickSearchButtonOrEnter();
        return new SearchResultSteps();
    }

    public SearchSteps openToolTip() {
        searchPage.moveToSearchVoiceButton();
        return this;
    }

    public SearchSteps checkToolTip(String text) {
        searchPage.checkMoveToSearchVoiceButtonText(text);
        return this;
    }
}
