package smartasset.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static smartasset.testbaseframework.HelperClass.waitFindElement;
import static smartasset.testbaseframework.HelperClass.waitFindElements;

public class HomePage {

    private int numberOfItemsInDropDown;
    private Select dropDown;
    private String textOfThing;

    public WebElement getGetStartedButton(){
        return waitFindElement(By.cssSelector("#sectionbutton"));
    }

    public boolean isGetStartedNowButtonDisplayed(){
        WebElement button = getGetStartedButton();
        return button.isDisplayed();
    }
    public void clickOnGetStartedNowButton(){
        WebElement button = getGetStartedButton();
        button.click();
    }

    public void selectFromDropDown(String item) {
        Select dropDown = getDropDown();
        dropDown.selectByVisibleText(item);
    }

    public int getNumberOfItemsInDropDown() {
      List<WebElement> dropdown = waitFindElements(By.cssSelector("select>option"));
        return dropdown.size();
    }

    public Select getDropDown() {
        Select dropDown = new Select(waitFindElement(By.cssSelector("#sectionselector")));
        return dropDown;
    }

    public List<String> getDropDownItems(){
        List<WebElement> items = waitFindElements(By.cssSelector("select>option"));
        List<String> itemText = new ArrayList<String>();

        for (WebElement item : items) {
            itemText.add(item.getText());
        }
        return itemText;
    }

    public void assertDropDownItems(List<String> expectedItems){
        List<String> actualItems = getDropDownItems();
        for(int i =0; i < actualItems.size(); i++){
            assertTrue(actualItems.contains(expectedItems.get(i)));
        }
    }

    public void verifyLastInDropDown(String item) {
        List<String> listOfDropDownItems = getDropDownItems();
        int last = listOfDropDownItems.size() - 1;
        assertEquals(item, listOfDropDownItems.get(last));
        }
    }