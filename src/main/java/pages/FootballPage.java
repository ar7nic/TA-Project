package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FootballPage extends BasePage{

@FindBy(xpath = "//a[contains(text(),'Scores')]")
private WebElement scoresTab;

    public WebElement getScoresTab() {
        return scoresTab;
    }

    public void clickScoresTab() {
        scoresTab.click();
    }

    public FootballPage(WebDriver driver) {
        super(driver);
    }
}
