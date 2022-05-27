package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 30;

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    NewsPage newsPage;
    SearchResultPage searchResultPage;
    ContactHelpPage contactHelpPage;
    CoronavirusPage coronavirusPage;
    SubmitStoryPage submitStoryPage;
    SportPage sportPage;
    FootballPage footballPage;
    DetailedMatchInfoPage detailedMatchInfoPage;
    ScoresPage scoresPage;
    ScoresOfEventPage scoresOfEventPage;
    MonthOfEventPage monthOfEventPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User opens {string} page")
    public void userOpensHomePagePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User clicks 'News' menu")
    public void userClicksNewsMenu() {
        homePage.clickNewsMenuButton();
    }

    @And("User checks the name of the headline article contains {string}")
    public void userChecksTheNameOfTheHeadlineArticleContainsArticleName(final String articleTitle) {
        newsPage = pageFactoryManager.getNewsPage();
        Assert.assertEquals(newsPage.getHeadlineNewsTitle().getText(),articleTitle);
    }

    @And("User checks the name of the secondary articles contains list of article`s titles")
    public void userChecksTheNameOfTheSecondaryArticlesContainsListOfArticlesTitles(List<String> allNews) {
        newsPage= pageFactoryManager.getNewsPage();
        for (String newsTitle: allNews) {
         Assert.assertTrue(newsPage.checkIfNewsAreOnSite(newsTitle));
        }
    }

    @And("User copy the Category link of the headline article")
    public void userCopyTheCategoryLinkOfTheHeadlineArticle() {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.setCategoryLinkText(newsPage.getCategoryLink().getText());
    }

    @And("User enter Category link to the Search bar")
    public void userEnterCategoryLinkToTheSearchBar() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.findTextThroughSearchInput(newsPage.getCategoryLinkText());
    }

    @And("User checks the name of the first article contains Category link")
    public void userChecksTheNameOfTheFirstArticleContainsCategoryLink() {
        Assert.assertTrue(searchResultPage.getTitleOfFirstArticle().contains(newsPage.getKeywords()[0]) || searchResultPage.getTitleOfFirstArticle().contains(newsPage.getKeywords()[1]));
    }

    @And("User click on Search bar")
    public void userClickOnSearchBar() {
        newsPage.clickOnSearchBar();
    }

    @And("User click on 'Coronavirus' tab")
    public void userClickOnTab() {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,newsPage.getCoronavirusTab());
        newsPage.clickOnCoronavirusTab();
    }

    @And("User click on Contact BBC News link")
    public void userClickOnContactBBCNewsLink() {
        coronavirusPage = pageFactoryManager.getCoronavirusPage();
        coronavirusPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,coronavirusPage.getContactBbcButton());
        coronavirusPage.clickContactBBCButton();
    }
    @And("User click on 'send us a story' link")
    public void userClickOnSendUsAStoryLink() {
        contactHelpPage = pageFactoryManager.getContactHelpPage();
        contactHelpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,contactHelpPage.getSendAStoryLink());
        contactHelpPage.clickOnSendAStoryLink();
    }

    @And("User fill the submit form with {string} and {string} and {string}")
    public void userFillTheSubmitFormWithDontTCheckedAcceptTermsCheckbox(final String userName, final String email, final String story) {
        submitStoryPage = pageFactoryManager.getSubmitStoryPage();
        submitStoryPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,submitStoryPage.getSubmitButton());
        submitStoryPage.getNameInput().sendKeys(userName);
        submitStoryPage.getEmailInput().sendKeys(email);
        submitStoryPage.getTextArea().sendKeys(story);
        submitStoryPage.clickOnSubmitButton();
    }

    @And("User checks the error message {string} present")
    public void userChecksIfSubmitFormHasWarning(final String errorMessage) {
        submitStoryPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,submitStoryPage.getCheckboxErrorMessage());
        Assert.assertTrue(submitStoryPage.getCheckboxErrorMessage().getText().contains(errorMessage));
    }

    @And("User check accept the terms checkbox")
    public void userCheckAcceptTheTermsCheckbox() {
        submitStoryPage = pageFactoryManager.getSubmitStoryPage();
        submitStoryPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,submitStoryPage.getAcceptTermsCheckBox());
        submitStoryPage.clickAcceptTermsCheckBox();
    }

    @And("User clicks 'Sport' menu tab")
    public void userClicksSportMenuTab() {
        homePage.clickSportMenuButton();
    }

    @And("User click on 'Football' tab")
    public void userClickOnFootballTab() {
        sportPage = pageFactoryManager.getSportPage();
        sportPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,sportPage.getFootballTab());
        sportPage.clickFootballTab();
    }

    @And("User click on 'Scores and Fixtures' link")
    public void userClickOnScoresAndFixturesLink() {
        footballPage = pageFactoryManager.getFootballPage();
        footballPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,footballPage.getScoresTab());
        footballPage.clickScoresTab();
    }


    @When("User enter {string} in input field")
    public void userEnterCompetitionInInputField(final String competition) {
        scoresPage = pageFactoryManager.getScoresPage();
        scoresPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,scoresPage.getSearchInput());
        scoresPage.enterTextToSearchInput(competition);
    }

    @And("User choose the {string}")
    public void userChooseTheMonth(final String month) throws InterruptedException {
        scoresOfEventPage = pageFactoryManager.grtScoresOfEventPage();
        scoresOfEventPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,scoresOfEventPage.getListOfMonths().get(0));
        scoresOfEventPage.chooseMonth(month);
    }


    @And("User check that {string} and {string} played with the score {string}:{string}")
    public void userCheckThatTeam1AndTeam2PlayedWithTheScore1Score2
            (final String team1, final String team2, final String score1, final String score2) {
        MonthOfEventPage.setTeam1(team1);
        MonthOfEventPage.setTeam2(team2);
        monthOfEventPage = pageFactoryManager.getMonthOfEventPage();
        Assert.assertEquals(monthOfEventPage.getPlayedTeam().getText(),team1);
        Assert.assertEquals(monthOfEventPage.getOpponent().getText(),team2);
        Assert.assertEquals(monthOfEventPage.getPlayedTeamScore().getText(),score1);
        Assert.assertEquals(monthOfEventPage.getOpponentScore().getText(),score2);
    }

    @And("User click on 'team1' name")
    public void userClickOnTeamName() {
        monthOfEventPage.clickOnFirstTeam();
    }

    @And("User check that on match page {string} and {string} played with the score {string}:{string}")
    public void userCheckThatOnMatchPageTeam1AndTeam2PlayedWithTheScore1Score2
            (final String team1, final String team2, final String score1, final String score2) {
        detailedMatchInfoPage=pageFactoryManager.getDetailedMatchInfoPage();
        detailedMatchInfoPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,detailedMatchInfoPage.getTeams().get(0));
        Assert.assertEquals(detailedMatchInfoPage.getFirstTeamName(),team1);
        Assert.assertEquals(detailedMatchInfoPage.getSecondTeamName(),team2);
        Assert.assertEquals(detailedMatchInfoPage.getFirstTeamScore(),score1);
        Assert.assertEquals(detailedMatchInfoPage.getSecondTeamScore(),score2);
    }
}
