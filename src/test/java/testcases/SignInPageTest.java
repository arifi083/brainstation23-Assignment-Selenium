package testcases;

import baseclass.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.SignInPage;

import java.io.IOException;

public class SignInPageTest extends BaseClass {
    public HomePage homePage;
    public SignInPage signInPage;
    public SignInPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException {
        setUp();
        signInPage=new SignInPage();
    }

    @Test
    public void loginWithValidCredentials() throws IOException, InterruptedException {
        homePage = signInPage.login(getUserName(),getPassword());
        homePage.homePageText();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
