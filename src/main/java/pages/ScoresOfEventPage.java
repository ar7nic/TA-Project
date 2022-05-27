package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ScoresOfEventPage extends BasePage{

    @FindBy(xpath = "//li[contains(@class,'sp-c-date-picker-timeline__item')]//span[text()='2022']//preceding-sibling::span[contains(@class,'gel-long-primer-bold')]")
    private List<WebElement> listOfMonths;

    public List<WebElement> getListOfMonths() {
        return listOfMonths;
    }

    public void chooseMonth(String month) throws InterruptedException {
        int monthIndex=0;
        for (int i = 0; i < listOfMonths.size()-1; i++) {
                if (listOfMonths.get(i).getText().contains(month)) {
                    monthIndex=i;
                    break;
                }
            }
        listOfMonths.get(monthIndex).click();
        Thread.sleep(2000);
        }

    public ScoresOfEventPage(WebDriver driver) {
        super(driver);
    }
}
