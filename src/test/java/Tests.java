import io.restassured.response.Response;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Homepage;
import pages.LoginPage;
import pages.RoomCreationPage;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Tests {

    ChromeDriver driver;
    Response response = RoomCreationPage.getRoomBookingPage();

    @Before
    public void setup(){
        driver = new ChromeDriver();
        Homepage home = new Homepage(driver);
        home.clickOnHackButton();
        home.clickOnAdminLinkButton();
    }

    //Assert that admin login link is functional and opens the admin login page
    @Test
    public void adminLinkReturnsAdminPage(){
        LoginPage loginpage = new LoginPage(driver);

        Assert.assertTrue(loginpage.isPageOpened());
    }

    //Assert that admin login is successful and opens the room creation page
    @Test
    public void loginAsAdmin(){
        LoginPage loginpage = new LoginPage(driver);
        loginpage.set_username("admin");
        loginpage.set_password("password");
        loginpage.clickOnLoginButton();
        RoomCreationPage roomcreationpage = new RoomCreationPage(driver);

        Assert.assertTrue(roomcreationpage.isRoomCreationPageOpened());
    }
    //Assert that a booking can be created and returns 200 status code
    @Test
    public void createBookingReturns201(){
        LoginPage loginpage = new LoginPage(driver);
        loginpage.set_username("admin");
        loginpage.set_password("password");
        loginpage.clickOnLoginButton();
        RoomCreationPage roomcreationpage = new RoomCreationPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roomNumber")));
        roomcreationpage.set_RoomNumber("100");
        roomcreationpage.set_RoomType("Twin");
        roomcreationpage.set_Accessibility("true");
        roomcreationpage.set_RoomPrice("200");
        roomcreationpage.selectWifi();
        roomcreationpage.selectTV();
        roomcreationpage.selectViews();
        roomcreationpage.clickOnCreateRoomButton();

        assertThat(response.getStatusCode(), equalTo(200));
    }

    @After
    public void close(){
        driver.close();
    }
}
