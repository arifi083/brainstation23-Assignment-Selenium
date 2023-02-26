package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class ShareBusPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    public ShareBusPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

    @FindBy(id="startPoint")
    WebElement startPoint;

    @FindBy(id="destination")
    WebElement destination;

    @FindBy(css="div.row.my-3 > div:nth-child(1) > div > div.pv-datepicker > span > input")
    WebElement departureDatePickerClick;

    @FindBy(css="table > tbody > tr:nth-child(2) > td:nth-child(6)")
    WebElement departureDate;
    @FindBy(css="div.row.my-3 > div:nth-child(1) > div > div.pv-timepicker > span > input")
    WebElement departureTime;

    @FindBy(css="div.row.my-4 > div.col-sm-12.col-md-6 > div > div.pv-datepicker > span > input")
    WebElement returnDatePickerClick;

    @FindBy(css="div.p-datepicker-calendar-container > table > tbody > tr:nth-child(4) > td:nth-child(2)")
    WebElement returnDate;

    @FindBy(css="div.row.my-4 > div:nth-child(1) > div > div.pv-timepicker > span > input")
    WebElement returnTime;

    @FindBy(css="button[type='submit']")
    WebElement continueBtn;


    public boolean setupShareBus(){
        return true;
    }

    public MemberShipPage fillTripDetails() throws IOException, InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(startPoint));
        startPoint.click();
        startPoint.sendKeys("Oslo");
        Thread.sleep(3000);
        startPoint.sendKeys(Keys.ARROW_DOWN);
        startPoint.sendKeys(Keys.ENTER);
        this.scroll2();

        wait.until(ExpectedConditions.elementToBeClickable(destination));
        destination.click();
        destination.sendKeys("Kolbotn");
        Thread.sleep(3000);
        destination.sendKeys(Keys.ARROW_DOWN);
        destination.sendKeys(Keys.ENTER);
        this.scroll3();

        wait.until(ExpectedConditions.elementToBeClickable(departureDatePickerClick));
        departureDatePickerClick.click();
        wait.until(ExpectedConditions.elementToBeClickable(departureDate));
        departureDate.click();
        wait.until(ExpectedConditions.elementToBeClickable(departureTime));
        departureTime.click();
        this.scroll4();

        wait.until(ExpectedConditions.elementToBeClickable(returnDatePickerClick));
        returnDatePickerClick.click();
        wait.until(ExpectedConditions.elementToBeClickable(returnDate));
        returnDate.click();
        wait.until(ExpectedConditions.elementToBeClickable(returnTime));
        returnTime.click();

        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        continueBtn.click();
        Thread.sleep(5000);

        return new MemberShipPage();

    }


    public void scroll2() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,450)");
        Thread.sleep(2000);
    }
    public void scroll3() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,530)");
        Thread.sleep(2000);
    }
    public void scroll4() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,600)");
        Thread.sleep(2000);
    }
}
