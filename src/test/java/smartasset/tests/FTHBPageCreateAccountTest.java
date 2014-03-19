package smartasset.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import smartasset.entities.DropDownItems;
import smartasset.entities.User;
import smartasset.pages.CreateAccountField;
import smartasset.pages.FirstTimeHomeBuyerPage;
import smartasset.pages.HomePage;
import smartasset.testbaseframework.TestBase;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class FTHBPageCreateAccountTest extends TestBase {

    public HomePage homePage;
    public FirstTimeHomeBuyerPage firstTimeHomeBuyerPage;
    public CreateAccountField createAccountField;

    @Before
    public void setUp() {
        homePage = new HomePage();
        firstTimeHomeBuyerPage = new FirstTimeHomeBuyerPage();
        createAccountField = new CreateAccountField();
    }

    @Test
    public void invalidUserCreateAccountError() {
        // Test using invalid user credentials
        User invalidUser = new User("invalid_username","password");
        homePage.selectFromDropDown(DropDownItems.HOME_BUYING);
        assertTrue(homePage.isGetStartedNowButtonDisplayed());
        homePage.clickOnGetStartedNowButton();
        createAccountField.enterUserNameAndPassword(invalidUser);
        firstTimeHomeBuyerPage.clickCreateAccountButton();
        assertEquals("That seems to be an invalid email.", createAccountField.getEmailCreateErrorMessage());
    }

    @Test
    public void createAccountWithExistingUsername(){
        // Test using valid user credentials
        User validUser = new User("imtiazhossain@msn.com", "password");
        homePage.selectFromDropDown(DropDownItems.HOME_BUYING);
        assertTrue(homePage.isGetStartedNowButtonDisplayed());
        homePage.clickOnGetStartedNowButton();
        createAccountField.enterUserNameAndPassword(validUser);
        firstTimeHomeBuyerPage.clickCreateAccountButton();
        assertEquals("Email imtiazhossain@msn.com is already registered. Please log in.", createAccountField.getAlreadyRegisteredErrorMessage());

    }
}
