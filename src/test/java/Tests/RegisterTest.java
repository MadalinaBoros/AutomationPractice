package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest {

    public WebDriver driver;

    @Test
    public void TestAutomat(){

        //un drop down il recunoastem dupa primul cuvant (care tot timpul este select)

        //Specificam unde se afla Driverul pentru browser
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");

        //Deschidem un browser
        driver = new ChromeDriver();

        //Introducem o adresa
        driver.get("http://demo.automationtesting.in/Index.html");

        //Schimbam rezolutia la mare, tot timpul alegem maximize, la full screen nu avem butonul de X si punere in bara
        driver.manage().window().maximize();

        //Skip sign in element si click
        WebElement SkipSignInElement = driver.findElement(By.id("btn2"));
        SkipSignInElement.click();

        //First name
        WebElement FirstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String FirstNameElementValoare = "Kevin";
        FirstNameElement.sendKeys(FirstNameElementValoare);

        //Last name


        //Genul
        WebElement GenderElement = driver.findElement(By.cssSelector("input[value='Male']"));
        GenderElement.click();

        //Hobby
        WebElement HobbyElement = driver.findElement(By.id("checkbox3"));
        HobbyElement.click();

        //Skills
        WebElement SkillsElement = driver.findElement(By.id("Skills"));
        Select SkillsSelect = new Select(SkillsElement);
        SkillsSelect.selectByVisibleText("Android");

        //Anul
        WebElement YearElement = driver.findElement(By.id("yearbox"));
        Select YearSelect = new Select(YearElement);
        YearSelect.selectByValue("1990");

        //Language
        WebElement LanguageElement = driver.findElement(By.id("msdd"));
        LanguageElement.click();

        List<WebElement> LanguageElements = driver.findElements(By.xpath("//li[@class='ng-scope']/a"));
        for (Integer i = 0; i < LanguageElements.size(); i++){
            if (LanguageElements.get(i).getText().equals("Bulgarian")){
                LanguageElements.get(i).click();
            }
        }
        GenderElement.click();
    }

        //Adresa
        WebElement AdresaElement = driver.findElement(By.cssSelector("textarea[ng-model='Adress']"));
        String AdresaElementValoare = "Cluj nr 36";
        AdresaElement.sendKeys(AdresaElementValoare)


}
