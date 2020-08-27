package pages;

import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static io.restassured.RestAssured.given;

public class RoomCreationPage {
    private static final String roomBookingPageUrl = "https://automationintesting.online/#/admin";
    private ChromeDriver driver;

    @FindBy(how = How.LINK_TEXT, using = "B&B Booking Management")
    private WebElement roomBookingHeading;

    @FindBy(how = How.ID, using = "roomNumber")
    private WebElement inputRoomNumber;

    @FindBy(how = How.ID, using = "type")
    private WebElement selectRoomType;

    @FindBy(how = How.ID, using = "accessible")
    private WebElement selectAccessibility;

    @FindBy(how = How.ID, using = "roomPrice")
    private WebElement inputRoomPrice;

    @FindBy(how = How.ID, using = "wifiCheckbox")
    private WebElement wifiCheckbox;

    @FindBy(how = How.ID, using = "refreshCheckbox")
    private WebElement refreshCheckbox;

    @FindBy(how = How.ID, using = "tvCheckbox")
    private WebElement tvCheckbox;

    @FindBy(how = How.ID, using = "safeCheckbox")
    private WebElement safeCheckbox;

    @FindBy(how = How.ID, using = "radioCheckbox")
    private WebElement radioCheckbox;

    @FindBy(how = How.ID, using = "viewsCheckbox")
    private WebElement viewsCheckbox;

    @FindBy(how = How.ID, using = "createRoom")
    private WebElement createRoom;

    public RoomCreationPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isRoomCreationPageOpened() {
        return roomBookingHeading.getText().toString().contains("B&B Booking Management");
    }

    public void set_RoomNumber(String roomNumber) {
        inputRoomNumber.sendKeys(roomNumber);
    }

    public void set_RoomType(String inputRoomType) {
        Select dropdown = new Select(selectRoomType);
        dropdown.selectByVisibleText(inputRoomType);
    }

    public void set_Accessibility(String accessibility) {
        Select dropdown = new Select(selectAccessibility);
        dropdown.selectByVisibleText(accessibility);
    }

    public void set_RoomPrice(String roomPrice) {
        inputRoomPrice.sendKeys(roomPrice);
    }

    public void selectWifi() {
        wifiCheckbox.click();
    }

    public void selectRefreshments() {
        refreshCheckbox.click();
    }

    public void selectTV() {
        tvCheckbox.click();
    }

    public void selectSafe() {
        safeCheckbox.click();
    }

    public void selectRadio() {
        radioCheckbox.click();
    }

    public void selectViews() {
        viewsCheckbox.click();
    }

    public void clickOnCreateRoomButton() {
        createRoom.click();
    }

    public static Response getRoomBookingPage() {
        return given().get(roomBookingPageUrl);
    }
}