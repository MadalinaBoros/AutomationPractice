package Tests;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AlertTest {

    public WebDriver driver;

    @Test
    public void TestAutomat() {

        //un drop down il recunoastem dupa primul cuvant (care tot timpul este select)
        //un site responsive este un site care pe laptop se vede intr-un fel si pe telefon este altfel compusa pagina

        // //a[contains(text(),
        //la css punem spatii in cod daca vrem sa adaugam mai multi pasi
        //la xpath adaugam //
        //Specificam unde se afla Driverul pentru browser
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");

        //Deschidem un browser
        driver = new ChromeDriver();

        //Introducem o adresa
        driver.get("http://demo.automationtesting.in/Index.html");

        //Schimbam rezolutia la mare, tot timpul alegem maximize, la full screen nu avem butonul de X si punere in bara
        driver.manage().window().maximize();

        //Skip sign in element si click
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        //interactionam cu switch to
        WebElement switchToElement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        Actions action = new Actions (driver);
        action.moveToElement(switchToElement).perform();

        //identificam alerts
        WebElement alertsElement = driver.findElement(By.xpath("//a[contains(text(),'Alerts')]"));
        alertsElement.click();
        String url = "http://demo.automationtesting.in/Alerts.html";
        driver.navigate().to(url);


        // ul[class='nav nav-tabs nav-stacked'] li a

        //Alert button
        List<WebElement>  alertOptions = driver.findElements(By.cssSelector("ul[class='nav nav-tabs nav-stacked'] li a"));
        alertOptions.get(0).click();

        //Casuta ok button
        alertOptions.get(1).click();
        WebElement casutaOkButtonElement = driver.findElement(By.cssSelector("#OKTab button "));
        casutaOkButtonElement.click();
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();

        //Casuta ok-cancel button
        alertOptions.get(2).click();
        WebElement casutaOkCancelButtonElement = driver.findElement(By.cssSelector("#CancelTab button"));
        casutaOkCancelButtonElement.click();
        Alert alertOkCancel = driver.switchTo().alert();
        alertOkCancel.dismiss();

        //Casuta alert with text
        alertOptions.get(3).click();
        WebElement casutaAlertWithText = driver.findElement(By.cssSelector("#"));
        casutaAlertWithText.click();
        Alert alertWithText = driver.switchTo().alert();
        alertWithText.accept();

    }

}
