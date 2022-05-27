package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactHelpPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(),'send us a story')]")
    private WebElement sendAStoryLink;

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement popupCloseButton;

    public WebElement getPopupCloseButton() {
        return popupCloseButton;
    }

    public WebElement getSendAStoryLink() {
        return sendAStoryLink;
    }

    public void clickOnSendAStoryLink() {
        sendAStoryLink.click();
    }

    public ContactHelpPage(WebDriver driver) {
        super(driver);
    }
}
