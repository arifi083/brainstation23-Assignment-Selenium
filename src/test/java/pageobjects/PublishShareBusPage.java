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

public class PublishShareBusPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    public PublishShareBusPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

    @FindBy(css="form > div.col-sm-12.col-md-6.my-4 > div > input")
    WebElement tripName;

    @FindBy(css="#sport0 > p")
    WebElement categoryName;

    @FindBy(css="form > div.w-100.text-end.mt-2.ship-gray > button")
    WebElement previewPublishBtn;

    @FindBy(css="div.modal-footer.border-top-0.pb-4 > button.btn.sb-btn-primary")
    WebElement publishModalBtn;

    public MyShareBusPage createShareBus() throws IOException, InterruptedException {
        tripName.sendKeys("Enjoy journey");
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(categoryName));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element5);
        System.out.println("arif arif");

        Thread.sleep(3000);
        this.scroll4();
        wait.until(ExpectedConditions.elementToBeClickable(previewPublishBtn));
        previewPublishBtn.click();
        Thread.sleep(3000);

        wait.until(ExpectedConditions.elementToBeClickable(publishModalBtn));
        publishModalBtn.click();
        Thread.sleep(3000);
        return new MyShareBusPage();

    }

    public void scroll4() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,600)");
        Thread.sleep(2000);
    }


}
