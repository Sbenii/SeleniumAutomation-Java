import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Amazon {
    WebDriver driver;

    @BeforeTest
    public void prepare() throws InterruptedException {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void end() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test(priority = 0)
    public void OpenBrowser() {
        driver.navigate().to("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    public void ValidSignIn() {
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email_login")));
        String email = System.getenv("EMAIL");
        emailField.sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"continue\"]/span/input")).click();
        driver.navigate().refresh();
        String pass = System.getenv("PWD");

        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys(pass);
        driver.findElement(By.id("signInSubmit")).click();
    }

    @Test(priority = 1)
    public void InvalidSignIn() {
        driver.navigate().refresh();
        driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_email_login']")));
        String Email = System.getenv("Mail");
        email.sendKeys(Email);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement((By.xpath("//a[@class='a-link-normal change-claim']"))).click();
    }
}
