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
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    //Sign in for valid user!!
    public void OpenBrowser() {
        driver.navigate().to("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.findElement(By.id("nav-link-accountList")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email_login")));
        String email = System.getenv("EMAIL");
        emailField.sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"continue\"]/span/input")).click();
        String pass = System.getenv("PWD");
        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys(pass);
        driver.findElement(By.id("signInSubmit")).click();


    }
}
