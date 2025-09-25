import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableData {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.partialLinkText("Data Tables")).click();
        WebElement table = driver.findElement(By.id("table2"));
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));
        System.out.println("The total number of rows for table 1= " + tableRows.size());
        System.out.println(tableRows.get(0).getText());
        System.out.println(tableRows.get(1).getText());
        System.out.println(tableRows.get(2).getText());
        System.out.println(tableRows.get(3).getText());
        System.out.println(tableRows.get(4).getText());

        Thread.sleep(2000);
        driver.quit();
    }
}
