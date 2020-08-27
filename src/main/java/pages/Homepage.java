package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    private ChromeDriver driver;

    private static String homepageUrl = "https://automationintesting.online/#/";

    @FindBy(how = How.CSS, using = "button.btn.btn-primary")
    private WebElement LetMeHackButton;

    @FindBy(how = How.LINK_TEXT, using = "Admin panel")
    private WebElement AdminLinkButton;

    public Homepage(ChromeDriver driver) {
        this.driver = driver;
        driver.get(homepageUrl);
        PageFactory.initElements(driver, this);
    }

    public void clickOnHackButton(){
        LetMeHackButton.click();
    }

    public void clickOnAdminLinkButton(){
        AdminLinkButton.click();
    }
}
