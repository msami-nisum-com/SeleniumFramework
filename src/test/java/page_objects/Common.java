package page_objects;
import Config.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Common extends WebDrivers {
    private String profileName = ".profile-name";

    //Verifying profile name after login
    public void verifyProfileNameAfterLogin(WebDriver driver, String profileName)
    {
        Assert.assertEquals(driver.findElement(By.cssSelector(this.profileName)).getText(),profileName);
    }
}
