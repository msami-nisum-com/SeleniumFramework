package test_cases.Login;
import Config.Report;
import Config.TestData;
import Config.WebDrivers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import page_objects.Login;


public class TC001 {
    private Login login = new Login();
    private TestData data =  new TestData();
    private WebDriver driver;
    static Report reportSetup = new Report();
    static ExtentReports report;
    static ExtentTest test;
    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(reportSetup.getReportPath());
        test = report.startTest("Login Scenarios");
    }
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
        test.log(LogStatus.PASS, "Verified user is able to Login");
    }

    @Test(priority = 2)
    public void invalidLogin(){
        login.verifyLoginPageIsLoaded(driver);

        //Entering Invalid Email, Password and clicking on login
        login.enterLoginCredentials(driver,data.credentials("invalidEmail"),data.credentials("invalidPassword"));
        login.clickLoginButton(driver);

        //Verifying error message
        login.verifyInvalidLoginErrorMessage(driver);
        test.log(LogStatus.PASS, "Verified user is not able to login with invalid credentials");
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }




}
