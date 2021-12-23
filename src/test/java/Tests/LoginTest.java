package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    //Selenium functioneaza pe doua concepte interactiune cu browsere pe care trebuie sa le cream
    //Webdriver= variabila care ne ajuta sa interactionam cu site-ul si elementele din site
    //punctul inaintea cautarii  este echivalentul cautarii dupa clasa
    // pentru butonul de search apasam ctrl f

   public WebDriver driver;

   @Test
    public void TestAutomat(){
    //Specificam unde se afla Driverul pentru browser
       System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");

    //Deschidem un browser
       driver = new ChromeDriver();

    //Introducem o adresa
      driver.get("http://demo.automationtesting.in/Index.html");

    //Schimbam rezolutia la mare, tot timpul alegem maximize, la full screen nu avem butonul de X si punere in bara
      driver.manage().window().maximize();

    //Identificam elementul sign in
      WebElement SignInElement = driver.findElement(By.id("btn1"));

    //Facem un click
      SignInElement.click();

    //identificare element dupa locaters, id, class, name, link, css, xpath

    WebElement EmailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
    String EmailValue = "boros.madalina95@yahoo.com";
    EmailElement.sendKeys(EmailValue);

    WebElement ParolaElement = driver.findElement(By.xpath("//input[@placeholder='Password']"));
    String ParolaValue = "parolaculiteremici";
    ParolaElement.sendKeys(ParolaValue);
    WebElement EnterElement = driver.findElement(By.id("enterbtn"));
    EnterElement.click();

    //css to xpath => input[placeholder='E mail'] => //input[@placeholder='E mail']
    WebElement EroareElement = driver.findElement(By.id("errormsg"));
    String ExpectedError = " Invalid User Name or PassWord";
    String ActualError = EroareElement.getText();
    Assert.assertEquals("MESAJUL DE PE PAGINA NU ESTE CORECT",ExpectedError, ActualError);



   }


}
