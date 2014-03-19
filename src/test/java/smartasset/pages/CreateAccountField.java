package smartasset.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import smartasset.entities.User;

import static smartasset.testbaseframework.HelperClass.*;

public class CreateAccountField {

   public void enterEmailAddress(String email) {
        WebElement emailCreateField = waitFindElement(By.cssSelector("div.content>div#inputs-container div#login-form>div#create-login>div>input#emailcreate-field"));
        emailCreateField.click();
        emailCreateField.clear();
        emailCreateField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordCreateField = waitFindElement(By.cssSelector("div.content>div#inputs-container div#login-form>div#create-login>div>input#passwordcreate-field"));
        passwordCreateField.clear();
        passwordCreateField.sendKeys(password);
    }

    public void clickCreateAccountButton(){
        WebElement createAccountButton = getCreateAccountButton();
        createAccountButton.click();
    }

    private WebElement getCreateAccountButton() {
        WebElement button = waitFindElement(By.cssSelector("div.content>div#inputs-container div#login-form>div#create-login>div>button"));
        return button;
    }
    public String getEmailCreateErrorMessage(){
        WebElement errorMessage = waitFindElement(By.cssSelector("div.content>div#inputs-container div#login-form>div#create-login>div>div#emailcreate-validation"));
        String errorMsg = errorMessage.getText();
        return errorMsg;
    }

    public void enterUserNameAndPassword(User user) {
        WebElement emailCreateField = waitFindElement(By.cssSelector("div.content>div#inputs-container div#login-form>div#create-login>div>input#emailcreate-field"));
        emailCreateField.clear();
        emailCreateField.sendKeys(user.getUserName());

        WebElement passwordCreateField = waitFindElement(By.cssSelector("div.content>div#inputs-container div#login-form>div#create-login>div>input#passwordcreate-field"));
        passwordCreateField.clear();
        passwordCreateField.sendKeys(user.getPassword());
    }
    public String getAlreadyRegisteredErrorMessage(){
        WebElement error = waitFindElement(By.cssSelector("#overlay-inputs-login > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(2)"));
        waitForVisible(error, true);
        String errorMsg = error.getText();
        return errorMsg;
    }
}
