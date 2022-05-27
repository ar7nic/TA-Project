package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{

    @FindBy(id = "search-input")
    private WebElement searchInput;

    @FindBy(xpath = "//ul[@role='list']//p[contains(@class,'PromoHeadline')]/span")
    private List<WebElement> listOfSearchResultedTitles;

    public String getTitleOfFirstArticle() {
      return   listOfSearchResultedTitles.get(0).getText();
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public List<WebElement> getListOfSearchResultedTitles() {
        return listOfSearchResultedTitles;
    }

    public void findTextThroughSearchInput(final String text) {
        searchInput.sendKeys(text, Keys.ENTER);
    }

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
}
