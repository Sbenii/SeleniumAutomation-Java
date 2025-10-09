import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon {
    WebDriver driver;

    @BeforeTest
    public void prepare() throws InterruptedException {
        driver = new ChromeDriver();
        Thread.sleep(5000);
    }
    @AfterTest
    public void end(){
        driver.quit();
    }
    @Test
    public void OpenBrowser()
}
