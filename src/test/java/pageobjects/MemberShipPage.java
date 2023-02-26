package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class MemberShipPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    public MemberShipPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }


    @FindBy(css="div > div:nth-child(1) > div.text-start> button:nth-child(1)")
    WebElement memberShipYes;

    @FindBy(css="div.club-chooser-dropdown > div.chooser > i")
    WebElement teamIcon;

    @FindBy(css="div.results > ul > li:nth-child(4)")
    WebElement teamValue;

    @FindBy(xpath = "//span[text()=\"Continue\"]")
    WebElement continueBtn;


    public PersonalGoalPage createTeam() throws InterruptedException, IOException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(memberShipYes));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        this.scroll5();

        Thread.sleep(3000);
        teamIcon.click();
        Thread.sleep(3000);
        teamValue.click();
        Thread.sleep(3000);
        continueBtn.click();
        Thread.sleep(3000);
        return new PersonalGoalPage();
    }


    public void scroll5() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,280)");
        Thread.sleep(2000);
    }


}
