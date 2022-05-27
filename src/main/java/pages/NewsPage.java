package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class,'nw-c-top-stories-primary__story')]//div[contains(@class,'gs-u-display-inline-block@m')]//h3[contains(@class,'gs-c-promo-heading__title')]")
    private WebElement headlineNewsTitle;

    @FindBy(xpath = "//h3[contains(@class,'gs-c-promo-heading__title')]")
    private List<WebElement> listOfNewsArticles;

    @FindBy(xpath = "//a[@id='orbit-search-button']")
    private WebElement searchBar;

    @FindBy(xpath = "//div[contains(@class,'nw-c-top-stories-primary__story')]//div[contains(@class,'gs-u-display-inline-block@m')]//a/span")
    private WebElement categoryLink;

    @FindBy(xpath = "//div[contains(@class,'nw-o-news-wide-navigation')]//nav[@aria-label='news']//span[text()='Coronavirus']")
    private WebElement coronavirusTab;

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement popupCloseButton;

    public WebElement getCoronavirusTab() {
        return coronavirusTab;
    }

    public WebElement getPopupCloseButton() {
        return popupCloseButton;
    }

    public void clickOnCoronavirusTab() {
        coronavirusTab.click();
    }

    public WebElement getCategoryLink() {
        return categoryLink;
    }

    private String categoryLinkText;

    public String[] getKeywords() {
       return categoryLinkText.split("&");
    }

    public void clickOnSearchBar() {
        searchBar.click();
    }

    public void setCategoryLinkText(String categoryLinkText) {
        this.categoryLinkText = categoryLinkText;
    }
//
    public String getCategoryLinkText() {
        return categoryLinkText;
    }

    public boolean checkIfNewsAreOnSite(String title) {
        for (WebElement newsOnSite: listOfNewsArticles) {
            if (title.equals(newsOnSite.getText())) return true;
        }
        return false;
    }

    public List<WebElement> getListOfNewsArticles() {
        return listOfNewsArticles;
    }

    public WebElement getHeadlineNewsTitle() {
        return headlineNewsTitle;
    }

    public NewsPage(WebDriver driver) {
        super(driver);
    }
}
