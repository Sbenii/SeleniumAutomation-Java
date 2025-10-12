import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        driver.navigate().to("https://registration.auca.ac.rw/Login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void InvalidSignIn() {
        driver.findElement(By.id("txtUsername")).sendKeys("");
        driver.findElement(By.id("txtPassword")).sendKeys("");
        driver.findElement(By.id("btnLogin")).click();

    }

    @Test(priority = 2)
    public void ValidSignIn() {
        String ID = System.getenv("ID");
        String pass = System.getenv("Pass");
        driver.findElement(By.id("txtUsername")).sendKeys(ID);
        driver.findElement(By.id("txtPassword")).sendKeys(pass);
        driver.findElement(By.id("btnLogin")).click();

    }

    @Test(priority = 3)
    public void Home() {
        driver.findElement(By.id("Home"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
}
