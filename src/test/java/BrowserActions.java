import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserActions {
    WebDriver driver;

    @Test
    public void firstTest() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        navigation("https:www.amazon.com");
        maximize();
//        navigateBack();
//        navigateForward();
        refresh();
//        minimize();
//        setPosition();
//        fullscreen();
//        IpadDimension();
//        IphoneDimension();
        getUrl();
        getTitle();
//        getPageSource();
        getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        getWindowHandle();
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

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void fullscreen() {
        driver.manage().window().fullscreen();
    }

    public void minimize() {
        driver.manage().window().minimize();
    }

    public void setPosition() {
        Point point = new Point(10, 100);
        driver.manage().window().setPosition(point);
    }

    public void IpadDimension() {
        Dimension dimension = new Dimension(1024, 1366);
        driver.manage().window().setSize(dimension);
    }

    public void IphoneDimension() {
        Dimension dimension = new Dimension(390, 844);
        driver.manage().window().setSize(dimension);
    }

    public void getUrl() {
        String url = driver.getCurrentUrl();
        System.out.println("Current url: " + url);
    }

    public void getTitle() {
        String title = driver.getTitle();
        System.out.println("The title: " + title);
    }

    public void getPageSource() {
        String source = driver.getPageSource();
        System.out.println("Page source: " + source);
    }

    public void getWindowHandle() {
        String windowHandle = driver.getWindowHandle();
        System.out.println("The window handle: " + windowHandle);
    }
}
