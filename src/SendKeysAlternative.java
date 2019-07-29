import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SendKeysAlternative {

    public static void main(String args[]) throws IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/kikumar/Documents/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.gmail.com");
        ((JavascriptExecutor)driver).executeScript("arguments[0].value='"+ "hello" + "'", driver.findElement(By.id("identifierId")));
    }
}
