package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends BaseClass {
    public HomePage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }



    public boolean homePageText(){
        return  true;
    }
}
