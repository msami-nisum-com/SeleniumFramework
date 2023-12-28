package test_cases.Login;
import Config.TestData;
import Config.WebDrivers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Login;


public class TC001 {
    private Login login = new Login();
    private TestData data =  new TestData();
    private WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new WebDrivers().driver();
    }
    @Test(priority = 1)
    public void validLogin(){
        login.verifyLoginPageIsLoaded(driver);

        //Entering Valid Email, Password  and clicking on login
        login.enterLoginCredentials(driver,data.credentials("coordinatorEmail"),data.credentials("devPassword"));
        login.clickLoginButton(driver);

        //Verifying after login profile name
        login.verifyProfileNameAfterLogin(driver,data.profileNames("coordinator"));
    }

    @Test(priority = 2)
    public void invalidLogin(){
        login.verifyLoginPageIsLoaded(driver);

        //Entering Invalid Email, Password and clicking on login
        login.enterLoginCredentials(driver,data.credentials("invalidEmail"),data.credentials("invalidPassword"));
        login.clickLoginButton(driver);

        //Verifying error message
        login.verifyInvalidLoginErrorMessage(driver);
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }




}
