package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private ChromeDriver driver;

    @FindBy(how = How.TAG_NAME, using = "h2")
    private WebElement heading;

    @FindBy(how = How.ID, using = "username")
    private WebElement inputUsername;

    @FindBy(how = How.ID, using = "password")
    private WebElement inputPassword;

    @FindBy(how = How.ID, using = "doLogin")
    private WebElement loginButton;

    public LoginPage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void set_username(String username){
        inputUsername.sendKeys(username);
    }

    public void set_password(String password){
        inputPassword.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public boolean isPageOpened(){
        return heading.getText().toString().contains("Log into your account");
    }
}
