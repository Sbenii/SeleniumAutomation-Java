import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook {
    WebDriver driver;

    @BeforeTest
    public void Prepare() {
        driver = new ChromeDriver();
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
//        driver.findElement(By.id("email")).sendKeys(Iemail);
        driver.findElement(By.id("email")).sendKeys(Iphone);
        driver.findElement(By.id("pass")).sendKeys(Ipass);
        driver.findElement(By.name("login")).click();
        String ActualResults = driver.findElement(By.className("_9ay7")).getText();
        String ExpectedResults = "The email or mobile number you entered isn’t connected to an account. Find your account and log in.";
        Assert.assertEquals(ActualResults, ExpectedResults);
    }
}
