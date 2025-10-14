import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BlazeDemo {
    WebDriver driver;

    @BeforeTest
    public void prepare() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void End() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void OpenBrowser() {
        driver.navigate().to("https://blazedemo.com/");
    }
}
