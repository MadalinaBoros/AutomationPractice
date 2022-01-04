package Tests;

import org.junit.Assert;
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
        //un site responsive este un site care pe laptop se vede intr-un fel si pe telefon este altfel compusa pagina




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

        //Validam pagina de register
        String actualRegister = driver.getTitle();
        Assert.assertEquals("Register", actualRegister);


        //First name
        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameElementValue = "Madalina";
        firstNameElement.sendKeys(firstNameElementValue);

        //Last name
        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameValue = "Boros";
        lastNameElement.sendKeys(lastNameValue);

        //Adresa
        WebElement adresaElement = driver.findElement(By.cssSelector("textarea[ng-model='Adress']"));
        String AdresaElementValoare = "Cluj nr 36";
        adresaElement.sendKeys(AdresaElementValoare);

        //Email address
        WebElement emailAddressElement = driver.findElement(By.cssSelector("input[type='email']"));
        String emailAddressValue = "boros.madalina95@yahoo.com";
        emailAddressElement.sendKeys(emailAddressValue);

        //Nr de telefon
        WebElement phoneNumberElement = driver.findElement(By.cssSelector("input[ng-model=\"Phone\"]"));
        String phoneNumberValue = "0729666666";
        phoneNumberElement.sendKeys(phoneNumberValue);

        //Genul
        WebElement genderElement = driver.findElement(By.cssSelector("input[value='FeMale']"));
        genderElement.click();

        //Hobby
        WebElement hobbyElement = driver.findElement(By.id("checkbox3"));
        hobbyElement.click();

        //Day
        WebElement dayElement = driver.findElement(By.id("daybox"));
        Select daySelect = new Select(dayElement);
        daySelect.selectByValue("12");

        //Language
        WebElement languageElement = driver.findElement(By.id("msdd"));
        languageElement.click();
        List<WebElement> languageElements = driver.findElements(By.xpath("//li[@class='ng-scope']/a"));
        for (Integer i = 0; i < languageElements.size(); i++){
            if (languageElements.get(i).getText().equals("Bulgarian")){
                languageElements.get(i).click();
                break;
            }
        }
        genderElement.click();

        //Skills
        WebElement skillsElement = driver.findElement(By.id("Skills"));
        Select skillsSelect = new Select(skillsElement);
        skillsSelect.selectByVisibleText("Android");

        //Country
        WebElement countryElement = driver.findElement(By.id("countries"));
        countryElement.click();

        //Select country nu functioneaza

        //Year
        WebElement yearElement = driver.findElement(By.id("yearbox"));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByValue("1999");

        //Month
        WebElement monthElement = driver.findElement(By.cssSelector("select[placeholder='Month']"));
        Select monthSelect = new Select(monthElement);
        monthSelect.selectByValue("March");

        //Parola
        WebElement passwordElement = driver.findElement(By.id("firstpassword"));
        String passwordElementValue = "parolaculiteremici";
        passwordElement.sendKeys(passwordElementValue);

        //Confirmare parola
        WebElement confirmPasswordElement = driver.findElement(By.id("secondpassword"));
        String confirmPasswordElementValue = "parolaculiteremici";
        confirmPasswordElement.sendKeys(confirmPasswordElementValue);

        //Submit button
        WebElement submitElement = driver.findElement(By.id("submitbtn"));
        submitElement.click();

        //Photo
        WebElement photoElement = driver.findElement(By.id("imagesrc"));
        photoElement.sendKeys("C:\\Users\\UltraBook\\Desktop\\download.jpg");

        //Refresh button
        WebElement refreshElement = driver.findElement(By.id("Button1"));
        refreshElement.click();

        //un comentariu


    }


}
