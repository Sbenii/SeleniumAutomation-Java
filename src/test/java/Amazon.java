import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        emailField.clear();
        emailField.sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"continue\"]/span/input")).click();
        String pass = System.getenv("PWD");
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
        password.sendKeys(pass);
        driver.findElement(By.id("signInSubmit")).click();
        driver.navigate().back();
        driver.navigate().back();
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
        String Message = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/h1")).getText();
        System.out.println("Error message:" + Message);
        String Msg = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/p[2]")).getText();
        System.out.println("Error message:" + Msg);
        driver.findElement((By.xpath("//a[@class='a-link-normal change-claim']"))).click();
        String ExpectedMessage = "Looks like you're new to Amazon";
        Assert.assertEquals(Message, ExpectedMessage);

    }

    @Test(priority = 3)
    public void SignUp() {
        driver.findElement(By.className("a-button-input")).click();
        String name = System.getenv("Name");
        String password = System.getenv("Pwd");
        String Email = System.getenv("Mail");

        driver.findElement(By.id("ap_email")).clear();
        driver.findElement(By.id("ap_email")).sendKeys(Email);
        driver.findElement(By.id("ap_customer_name")).sendKeys(name);
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("ap_password_check")).sendKeys(password);
        driver.findElement(By.id("continue")).click();

    }

    @Test(priority = 4)
    public void NavigationToHome() {
        driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[1]/div/a/i")).click();
        //Dismiss address change
        driver.findElement(By.xpath("//*[@id=\"nav-flyout-iss-anchor\"]/div[2]/div/div[3]/span[1]/span/input")).click();
    }

    @Test(priority = 5)
    public void Search() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mac M4");
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @Test(priority = 6)
    public void ProductDetailPage() {
        driver.findElement(By.partialLinkText("2025 MacBook Air 15-inch Laptop with M4 chip, 24GB Unified Memory, 256GB SSD Storage - Midnight")).click();
        //Click to see full view
        driver.findElement(By.id("canvasCaption")).click();
        //Exit full view
        driver.findElement(By.xpath("//*[@id=\"a-popover-1\"]/div/header/button")).click();
        //Click "see more"
        driver.findElement((By.xpath("//*[@id=\"poToggleButton\"]/a/span"))).click();
    }

    @Test(priority = 7)
    public void AddToCart() {
        driver.findElement(By.id("wishListMainButton")).click();
    }


}
