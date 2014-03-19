package smartasset.tests;

import org.junit.Before;
import org.junit.Test;
import smartasset.entities.DropDownItems;
import smartasset.pages.HomePage;
import smartasset.testbaseframework.TestBase;

import static junit.framework.Assert.assertEquals;

public class HomePageDropDownTest extends TestBase {

    public HomePage homePage;

    @Before
    public void setUp() {
        homePage = new HomePage();
    }

    @Test
    public void verifyDropDownContent(){
        // Test for number of items in dropdown list
        assertEquals(10, homePage.getNumberOfItemsInDropDown());
        // Verify names of dropdown items
        homePage.assertDropDownItems(DropDownItems.DROP_DOWN_ITEMS);
        // Verify that the last item is startup economics
        homePage.verifyLastInDropDown(DropDownItems.STARTUP_ECONOMICS);
        homePage.clickOnGetStartedNowButton();
        homePage.clickOnGetStartedNowButton();
    }
}
