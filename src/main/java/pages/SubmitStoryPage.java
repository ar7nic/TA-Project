package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubmitStoryPage extends BasePage{

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitButton;

    @FindBy(xpath = "//p[contains(text(),'I accept the')]")
    private WebElement acceptTermsCheckBox;

    @FindBy(xpath = "//input[@aria-label='Name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@aria-label='Email address']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement popupCloseButton;

    @FindBy(xpath = "//div[@class='input-error-message']")
    private WebElement checkboxErrorMessage;

    @FindBy(xpath = "//textarea[@class='text-input--long']")
    private WebElement textArea;

    public void clickAcceptTermsCheckBox() {
        acceptTermsCheckBox.click();
    }


    public WebElement getTextArea() {
        return textArea;
    }

    public WebElement getCheckboxErrorMessage() {
        return checkboxErrorMessage;
    }

    public WebElement getPopupCloseButton() {
        return popupCloseButton;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getAcceptTermsCheckBox() {
        return acceptTermsCheckBox;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public void checkAcceptCheckBox() {
        acceptTermsCheckBox.click();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public SubmitStoryPage(WebDriver driver) {
        super(driver);
    }
}
