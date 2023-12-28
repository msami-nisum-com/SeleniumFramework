package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Login extends Common {

    private String username = ".input[data-i=\'login-email-input-element\']";
    private String password = ".input[data-i='login-password-input-element']";
    private String  loginBtn = "button.login-button";
    private String loginFormHeader  = ".welcome-logo-container > div > div";
    private String invalidLogin = ".control-error-desc > span";
    private String invalidLoginErrorMessage  = "We can’t find that email and password. You can reset your password or try again.";

    //Verifying after URL hit on browser login page is loaded
    public void verifyLoginPageIsLoaded(WebDriver driver)
    {
        Assert.assertEquals(driver.findElement(By.cssSelector(this.loginFormHeader)).getText(),"Log in to your account");
    }

    //Performing steps for a valid login
    public void enterLoginCredentials(WebDriver driver, String email, String password)
    {
        driver.findElement(By.cssSelector(this.username)).sendKeys(email);
        driver.findElement(By.cssSelector(this.password)).sendKeys(password);
    }
    public void verifyInvalidLoginErrorMessage(WebDriver driver)
    {
        Assert.assertEquals(driver.findElement(By.cssSelector(this.invalidLogin)).getText(),this.invalidLoginErrorMessage);
    }
    public void clickLoginButton(WebDriver driver)
    {
        driver.findElement(By.cssSelector(this.loginBtn)).click();
    }







}
