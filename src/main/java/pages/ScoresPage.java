package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScoresPage extends BasePage{

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInput;

    public void enterTextToSearchInput(final String competition) {
        searchInput.sendKeys(competition, Keys.ENTER,Keys.ARROW_DOWN,Keys.ENTER);

    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public ScoresPage(WebDriver driver) {
        super(driver);
    }

}

