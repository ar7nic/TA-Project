package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DetailedMatchInfoPage extends BasePage{

@FindBy(xpath = "//section[contains(@class,'sp-c-fixture--live-session-header')]//div[@class='sp-c-fixture__wrapper']//span[contains(@class,'qa-full-team-name')]")
private List<WebElement> teams;

@FindBy(xpath = "//section[contains(@class,'sp-c-fixture--live-session-header')]//div[@class='sp-c-fixture__wrapper']//span[contains(@class,'sp-c-fixture__number')]")
private List<WebElement> scores;

    public String getFirstTeamName() {
        return teams.get(0).getText();
    }

    public String getSecondTeamName() {
        return teams.get(1).getText();
    }

    public String getFirstTeamScore() {
        return scores.get(0).getText();
    }

    public String getSecondTeamScore() {
        return scores.get(1).getText();
    }

    public List<WebElement> getTeams() {
        return teams;
    }

    public DetailedMatchInfoPage(WebDriver driver) {
        super(driver);
    }
}
