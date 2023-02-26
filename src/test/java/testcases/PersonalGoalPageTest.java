package testcases;

import baseclass.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;

public class PersonalGoalPageTest extends BaseClass {
    public HomePage homePage;
    public SignInPage signInPage;
    public SelectUserPage selectUserPage;
    public ShareBusPage shareBusPage;
    public MemberShipPage memberShipPage;
    public PersonalGoalPage personalGoalPage;
    public PublishShareBusPage publishShareBusPage;
    public PersonalGoalPageTest() throws IOException {
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
    public void setPersonalGoalPage() throws IOException, InterruptedException {
        shareBusPage = selectUserPage.selectUser();
        memberShipPage = shareBusPage.fillTripDetails();
        personalGoalPage = memberShipPage.createTeam();
        publishShareBusPage = personalGoalPage.createPersonalGoal();


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
