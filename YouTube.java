package Selenium.Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YouTube {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.youtube.com/");

        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("Rick Astley - Never Gonna Give You Up (Official Music Video)");

        WebElement searchIcon = driver.findElement(By.id("search-icon-legacy"));
        searchIcon.click();

        //Thread.sleep(2000);
         wdwait.until(ExpectedConditions.elementToBeClickable(By.linkText("Rick Astley - Never Gonna Give You Up (Official Music Video)")));

        WebElement song = driver.findElement(By.linkText("Rick Astley - Never Gonna Give You Up (Official Music Video)"));
        song.click();


        //driver.close();

    }


}
