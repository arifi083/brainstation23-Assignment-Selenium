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

public class PersonalGoalPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    public PersonalGoalPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

   @FindBy(css="div > div.col-md-7.col-lg-7.col-xl-8 > div:nth-child(2) > div>button:nth-child(2)")
   WebElement ticketYourself;

    @FindBy(css = "div.discount-ticket-wrapper.p-4.light-gray-bg.mb-2.mt-2 > div>button:nth-child(2)")
    WebElement ticketDiscount;

    @FindBy(css="button[type='submit")
    WebElement createShareBustBtn;

    @FindBy(css="div > div.publish-sb > button")
    WebElement publishBtn;

    public PublishShareBusPage createPersonalGoal() throws InterruptedException, IOException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(ticketYourself));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);

        Thread.sleep(3000);
        this.scroll6();

        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(ticketDiscount));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element2);

        this.scroll6();
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(createShareBustBtn));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element3);

        Thread.sleep(4000);
        this.scroll7();
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(publishBtn));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element4);
        Thread.sleep(4000);
        return new PublishShareBusPage();

    }


    public void scroll6() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,315)");
        Thread.sleep(2000);
    }

    public void scroll7() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,350)");
        Thread.sleep(2000);
    }




}
