package smartasset.testbaseframework;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {

    public static WebDriver browser = new FirefoxDriver();

    @Rule
    public ScreenShotRule screenShootRule = new ScreenShotRule(browser);

    @Before
    public void startUp(){
        browser.manage().deleteAllCookies();
        browser.manage().window().maximize();
        browser.get("http://www.SmartAsset.com");
    }


    @AfterClass
    public static void tearDown(){
        browser.quit();
    }
}
