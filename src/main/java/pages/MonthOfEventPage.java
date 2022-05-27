package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class MonthOfEventPage extends BasePage{

    private final String scorePath ="/ancestor::span[@data-team-id]//span[@class='sp-c-fixture__block']/span";
    private static String team1;
    private static String team2;
    private WebElement opponent = driver.findElement(xpath(makePath(team1,team2)));
    private WebElement playedTeam = driver.findElement(xpath(makePath(team2,team1)));
    private WebElement opponentScore = driver.findElement(xpath(makePath(team1,team2)+ scorePath));
    private WebElement playedTeamScore = driver.findElement(xpath(makePath(team2,team1)+ scorePath));

    @FindBy(xpath = "//div[@class='sp-c-fixture__wrapper']")
    private List<WebElement> listOfMatches;

    public WebElement getOpponentScore() {
        return opponentScore;
    }

    public WebElement getPlayedTeamScore() {
        return playedTeamScore;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public static void setTeam1(String team1) {
        MonthOfEventPage.team1 = team1;
    }

    public static void setTeam2(String team2) {
        MonthOfEventPage.team2 = team2;
    }
    private String makePath(String team1, String team2) {
            return "//span[contains(text(),'" + team1+ "')]/ancestor::div[@class='sp-c-fixture__wrapper']//span[contains(text(),'"+ team2 +"')]";
    }

    public WebElement getPlayedTeam() {
        return playedTeam;
    }

    public WebElement getOpponent() {
        return opponent;
    }


public void clickOnFirstTeam() {
        playedTeam.click();
}
    public MonthOfEventPage(WebDriver driver) {
        super(driver);
    }
}
