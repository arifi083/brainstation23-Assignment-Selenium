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
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class MyShareBusPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    public MyShareBusPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

    @FindBy(css="div > ul > li.nav-item.text-nowrap.for-desk.px-2 > button")
    WebElement navMyBus;

    @FindBy(xpath = "//span[text()=\"Enjoy journey\"]")
    WebElement verifyTripName;

    public MyShareBusPage verifyTrpDisplay() throws InterruptedException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element6 = wait.until(ExpectedConditions.elementToBeClickable(navMyBus));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element6);

        Thread.sleep(5000);
        String verifyTrip = verifyTripName.getText();
        Assert.assertTrue(verifyTrip.contains("Enjoy journey"));
        System.out.println("trip is displayed" + verifyTrip);

        return this;
    }
}
