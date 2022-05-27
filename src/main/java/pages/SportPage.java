package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SportPage extends BasePage{

@FindBy(xpath = "//div[@id='product-navigation-menu']//span[contains(text(),'Football')]")
private WebElement footballTab;

    public WebElement getFootballTab() {
        return footballTab;
    }

    public void clickFootballTab() {
        footballTab.click();
    }
    public SportPage(WebDriver driver) {
        super(driver);
    }
}
