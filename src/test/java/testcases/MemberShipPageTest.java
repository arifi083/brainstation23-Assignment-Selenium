package testcases;

import baseclass.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;

public class MemberShipPageTest extends BaseClass {
    public HomePage homePage;
    public SignInPage signInPage;
    public SelectUserPage selectUserPage;
    public ShareBusPage shareBusPage;
    public MemberShipPage memberShipPage;
    public PersonalGoalPage personalGoalPage;
    public MemberShipPageTest() throws IOException {
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
    public void setCreateTeam() throws IOException, InterruptedException {
        shareBusPage = selectUserPage.selectUser();
        memberShipPage = shareBusPage.fillTripDetails();
        personalGoalPage = memberShipPage.createTeam();


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
