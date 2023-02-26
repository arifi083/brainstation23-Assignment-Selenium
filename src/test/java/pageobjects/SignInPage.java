package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class SignInPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    public SignInPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

    @FindBy(css="#app > nav > div > ul > li > button")
    WebElement navsignBtn;

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="password")
    WebElement password;

    @FindBy(xpath ="//button[@type='submit']")
    WebElement signInButton;

    public HomePage login(String mail, String pass) throws IOException, InterruptedException {
        navsignBtn.click();
        email.sendKeys(mail);
        password.sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        return new HomePage();
    }






}
