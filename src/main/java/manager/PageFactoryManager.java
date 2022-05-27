package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public NewsPage getNewsPage() {
        return new NewsPage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public CoronavirusPage getCoronavirusPage() {
        return new CoronavirusPage(driver);
    }

    public ContactHelpPage getContactHelpPage() {
        return new ContactHelpPage(driver);
    }

    public SubmitStoryPage getSubmitStoryPage() {
        return new SubmitStoryPage(driver);
    }
    public SportPage getSportPage() {
        return new SportPage(driver);
    }
    public FootballPage getFootballPage() {
        return new FootballPage(driver);
    }
    public DetailedMatchInfoPage getDetailedMatchInfoPage() {
        return new DetailedMatchInfoPage(driver);
    }

    public ScoresPage getScoresPage() {
        return new ScoresPage(driver);
    }

    public ScoresOfEventPage grtScoresOfEventPage() {
        return new ScoresOfEventPage(driver);
    }

    public MonthOfEventPage getMonthOfEventPage() {
        return new MonthOfEventPage(driver);
    }

}
