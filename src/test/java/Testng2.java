import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng2 {
    WebDriver driver;

    @BeforeTest
    public void Prepare() throws InterruptedException {
        driver = new ChromeDriver();
        Thread.sleep(2000);

    }

    @AfterTest
    public void Quit() {
        driver.quit();
    }

    @Test
    public void OpenBrowser() {
        driver.get("https:www.google.com");
    }

    @Test
    public void SignUp() {

    }

    @Test
    public void SignIn() {

    }

    @Test
    public void AddToCart() {

    }

    @Test
    public void LogOut() {

    }

    @Test
    public void CloseBrowser() {

    }
}
