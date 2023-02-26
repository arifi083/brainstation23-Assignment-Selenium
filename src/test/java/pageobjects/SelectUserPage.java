package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.io.IOException;
import java.time.Duration;

public class SelectUserPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    public SelectUserPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//div[@role=\"button\"]")
    WebElement userIcon;

    @FindBy(css="li.p-dropdown-item:nth-child(2)")
    WebElement userValue;

    @FindBy(xpath = "//span[text()=\"Continue\"]")
    WebElement clickContinue;

    @FindBy(xpath = "//span[text()=\"Set up a Sharebus\"]")
    WebElement clickShareBus;

    public ShareBusPage selectUser() throws InterruptedException, IOException {
        wait.until(ExpectedConditions.elementToBeClickable(userIcon));
        userIcon.click();
        wait.until(ExpectedConditions.elementToBeClickable(userValue));
        userValue.click();
        wait.until(ExpectedConditions.elementToBeClickable(clickContinue));
        clickContinue.click();
        this.scroll1();
        wait.until(ExpectedConditions.elementToBeClickable(clickShareBus));
        clickShareBus.click();

        return new ShareBusPage();


    }


    public void scroll1() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,50)");
        Thread.sleep(2000);
    }



}
