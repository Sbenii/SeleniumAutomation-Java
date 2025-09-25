import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserActions {
    WebDriver driver;

    @Test
    public void firstTest() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        navigation("https:www.amazon.com");
        navigateBack();
        navigateForward();
        refresh();
    }

    public void navigation(String url) {
        driver.navigate().to(url);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void refresh() {
        driver.navigate().refresh();
    }
}
