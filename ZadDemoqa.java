package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ZadDemoqa {
    public static void main(String[] args) throws InterruptedException {

       /* Napomena: Ne mora se poceti od ovog URL-a koji sam poslao, radi vezbe mozete krenuti odatle i kliktati dalje.
        Potrebno je manuelno da se registrujete, manuelno da se ulogujete i tako potrazite koji vam cookie treba.
        Posle toga program treba da klikne na log out i da asertujete da li se korisnik izlogovao.*/


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/login");


        Cookie kolacicUser = new Cookie("userName","Charly22");
        driver.manage().addCookie(kolacicUser);
        driver.navigate().refresh();

        Cookie kolacicId = new Cookie("userID","d582cba1-93b2-4cf5-9758-17d2b0ae81e1");
        driver.manage().addCookie(kolacicId);
        driver.navigate().refresh();

        Cookie kolacicToken = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkNoYXJseTIyIiwicGFzc3dvcmQiOiJDaGFybHkhMjIwMiIsImlhdCI6MTY0MjM0NTI4Nn0.0hHM4uYIdYA6hdc6Nt-w0Wv4JBaXy1WcE3-DhQ17Dfg");
        driver.manage().addCookie(kolacicToken);
        driver.navigate().refresh();

        Cookie kolacicExp = new Cookie("expires","2022-01-23T14%3A56%3A08.750Z");
        driver.manage().addCookie(kolacicExp);
        driver.navigate().refresh();

        WebElement logOut= driver.findElement(By.id("submit"));
        logOut.click();

         WebElement loginButton = driver.findElement(By.id("login"));

        Assert.assertTrue(loginButton.isDisplayed());
       // Assert.assertFalse(loginButton.isDisplayed());

        driver.close();




    }
}
