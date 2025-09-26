import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng {
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

    @Test(priority = 0)
    public void OpenBrowser() {
        driver.get("https:www.google.com");
    }

    @Test(priority = 1)
    public void SignUp() {
        System.out.println("Sign Up!!!");
    }

    @Test(priority = 2)
    public void SignIn() {
        System.out.println("Sign in!!");
    }

    @Test(priority = 3)
    public void AddToCart() {
        System.out.println("Add to cart!!");
    }

    @Test(priority = 4)
    public void LogOut() {
        System.out.println("LogOut!!");
    }
}

