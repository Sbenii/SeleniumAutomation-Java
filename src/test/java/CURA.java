import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CURA {
    WebDriver driver;

    @BeforeTest
    public void Prepare() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void End() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void OpenBrowser() {
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

    }
}
