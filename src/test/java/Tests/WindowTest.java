package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest {

    public WebDriver driver;

    @Test
    public void TestAutomat() {

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

        //identificam "Window"
        WebElement windowsElement = driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
        windowsElement.click();
        String url = "http://demo.automationtesting.in/Windows.html";
        driver.navigate().to(url);

        //Driver.navigate().refresh(;
        List<WebElement> windowsOptions = driver.findElements(By.cssSelector("ul[class=nav nav-tabs"));
        windowsOptions.get(0).click();
        WebElement clickButtonElement = driver.findElement(By.cssSelector("#Tabbed a button"));
        clickButtonElement.click();

        System.out.println("Titulul paginii" + driver.getTitle());

        //Cum interactionam cu taburile nou deschise
        //Salvam taburile

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println("Titulul paginii" + driver.getTitle());
        driver.close();

        // inchidem browserul cu toate taburile deschise => driver.quit();
        //inchidem un tab cu => driver.close();

        driver.switchTo().window(tabs.get(0));

        windowsOptions.get(1).click();
        WebElement clickWindowElement = driver.findElement(By.cssSelector("#Seperate button"));
        clickWindowElement.click();
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        System.out.println("Titulul paginii" + driver.getTitle());
        driver.close();
        driver.switchTo().window(windows.get(0));


        windowsOptions.get(2).click();
        WebElement clickTabsElement = driver.findElement(By.cssSelector("#Multiple button"));
        clickTabsElement.click();
        List<String> multipleTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(multipleTabs.get(2));
        driver.close();
        driver.switchTo().window(multipleTabs.get(1));
        driver.close();
        driver.switchTo().window(multipleTabs.get(0));
        driver.quit();
    }
}
