package Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDrivers extends Environments{
    public WebDriver driver()
    {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
    public WebDriverWait  wait(WebDriver driver, Integer time)
    {
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait;
    }
}
