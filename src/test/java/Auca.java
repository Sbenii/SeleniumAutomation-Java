import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Auca {
    WebDriver driver;

    @BeforeTest
    public void prepare() {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void end() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 0)
    public void OpenBrowser() {
        driver.navigate().to("https://registration.auca.ac.rw/");
    }
}
