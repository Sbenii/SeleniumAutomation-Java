import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @Test(priority = 0)
    public void OpenBrowser() throws InterruptedException {
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement facebookLink = driver.findElement(By.xpath("//i[@class='fa fa-facebook fa-fw fa-3x']"));
        js.executeScript("arguments[0].scrollIntoView(true)", facebookLink);
        Thread.sleep(500);
        facebookLink.click();
        WebElement twitterLink = driver.findElement(By.xpath("//i[@class='fa fa-twitter fa-fw fa-3x']"));
        js.executeScript("arguments[0].scrollIntoView(true)", twitterLink);
        Thread.sleep(500);
        twitterLink.click();
    }

    @Test(priority = 1)
    public void HamburgerMenu() throws InterruptedException {
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(1500);
        //Return to home
        driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
        driver.findElement(By.id("menu-toggle")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        
    }
}
