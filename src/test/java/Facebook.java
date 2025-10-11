import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook {
    WebDriver driver;

    @BeforeTest
    public void Prepare() {
        driver = new SafariDriver();
    }

    @AfterTest
    public void End() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 0)
    public void OpenBrowser() {
        driver.navigate().to("https://www.facebook.com");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void InvalidSignIn() {
        String Iemail = System.getenv("Iemail");
        String Iphone = System.getenv("Iphone");
        String Ipass = System.getenv("Ipass");
        driver.findElement(By.id("email")).sendKeys(Iemail);
        driver.findElement(By.id("pass")).sendKeys(Ipass);
//        driver.findElement(By.xpath("//*[@id=\"u_0_5_08\"]")).click();
    }
}
