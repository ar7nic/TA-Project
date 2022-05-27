package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPage extends BasePage{

    @FindBy(xpath = "//div[@id='services-bar']//span[contains(text(),'Contact')]")
    private WebElement contactBbcButton;

    public WebElement getContactBbcButton() {
        return contactBbcButton;
    }

    public void clickContactBBCButton() {
        contactBbcButton.click();
    }

    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }
}
