package testcases;

import baseclass.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.SelectUserPage;
import pageobjects.ShareBusPage;
import pageobjects.SignInPage;

import java.io.IOException;

public class SelectUserPageTeset extends BaseClass {
    public HomePage homePage;
    public SignInPage signInPage;
    public SelectUserPage selectUserPage;
    public ShareBusPage shareBusPage;
    public SelectUserPageTeset() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException, InterruptedException {
        setUp();
        homePage=new SignInPage()
                .login(getUserName(),getPassword());
        selectUserPage = new SelectUserPage();
    }

    @Test
    public void selectUserValue() throws IOException, InterruptedException {
        shareBusPage = selectUserPage.selectUser();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
