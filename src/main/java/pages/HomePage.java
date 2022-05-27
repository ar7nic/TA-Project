package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//nav[@class='orbit-header-links international']//a[contains(@href,'news')]")
    private WebElement newsMenuButton;

    @FindBy(xpath = "//nav[@class='orbit-header-links international']//a[contains(@href,'sport')]")
    private WebElement sportMenuButton;

    @FindBy(xpath = "//a[@id='orbit-search-button']")
    private WebElement searchBar;

    public WebElement getSportMenuButton() {
        return sportMenuButton;
    }

    public void clickSportMenuButton() {
        sportMenuButton.click();
    }

    private void clickOnSearchBar() {
        searchBar.click();
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickNewsMenuButton() {
        newsMenuButton.click();
    }

    public WebElement getNewsMenuButton() {
        return newsMenuButton;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
