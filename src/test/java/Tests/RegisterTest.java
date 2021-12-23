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
        String ActualRegister = driver.getTitle();
        Assert.assertEquals("Register", ActualRegister);


        //First name
        WebElement FirstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String FirstNameElementValue = "Madalina";
        FirstNameElement.sendKeys(FirstNameElementValue);

        //Last name
        WebElement LastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String LastNameValue = "Boros";
        LastNameElement.sendKeys(LastNameValue);

        //Adresa
        WebElement AdresaElement = driver.findElement(By.cssSelector("textarea[ng-model='Adress']"));
        String AdresaElementValoare = "Cluj nr 36";
        AdresaElement.sendKeys(AdresaElementValoare);

        //Email address
        WebElement EmailAddressElement = driver.findElement(By.cssSelector("input[type='email']"));
        String EmailAddressValue = "boros.madalina95@yahoo.com";
        EmailAddressElement.sendKeys(EmailAddressValue);

        //Nr de telefon
        WebElement PhoneNumberElement = driver.findElement(By.cssSelector("input[ng-model=\"Phone\"]"));
        String PhoneNumberValue = "0729666666";
        PhoneNumberElement.sendKeys(PhoneNumberValue);

        //Genul
        WebElement GenderElement = driver.findElement(By.cssSelector("input[value='FeMale']"));
        GenderElement.click();

        //Hobby
        WebElement HobbyElement = driver.findElement(By.id("checkbox3"));
        HobbyElement.click();

        //Day
        WebElement DayElement = driver.findElement(By.id("daybox"));
        Select DaySelect = new Select(DayElement);
        DaySelect.selectByValue("12");

        //Language
        WebElement LanguageElement = driver.findElement(By.id("msdd"));
        LanguageElement.click();
        List<WebElement> LanguageElements = driver.findElements(By.xpath("//li[@class='ng-scope']/a"));
        for (Integer i = 0; i < LanguageElements.size(); i++){
            if (LanguageElements.get(i).getText().equals("Bulgarian")){
                LanguageElements.get(i).click();
                break;
            }
        }
        GenderElement.click();

        //Skills
        WebElement SkillsElement = driver.findElement(By.id("Skills"));
        Select SkillsSelect = new Select(SkillsElement);
        SkillsSelect.selectByVisibleText("Android");

        //Country
        WebElement CountryElement = driver.findElement(By.id("countries"));
        CountryElement.click();

        //Select country nu functioneaza

        //Year
        WebElement YearElement = driver.findElement(By.id("yearbox"));
        Select YearSelect = new Select(YearElement);
        YearSelect.selectByValue("1999");

        //Month
        WebElement MonthElement = driver.findElement(By.cssSelector("select[placeholder='Month']"));
        Select MonthSelect = new Select(MonthElement);
        MonthSelect.selectByValue("March");

        //Parola
        WebElement PasswordElement = driver.findElement(By.id("firstpassword"));
        String PasswordElementValue = "parolaculiteremici";
        PasswordElement.sendKeys(PasswordElementValue);

        //Confirmare parola
        WebElement ConfirmPasswordElement = driver.findElement(By.id("secondpassword"));
        String ConfirmPasswordElementValue = "parolaculiteremici";
        ConfirmPasswordElement.sendKeys(ConfirmPasswordElementValue);

        //Submit button
        WebElement SubmitElement = driver.findElement(By.id("submitbtn"));
        SubmitElement.click();

        //Photo
        WebElement PhotoElement = driver.findElement(By.id("imagesrc"));
        PhotoElement.sendKeys("C:\\Users\\UltraBook\\Desktop\\download.jpg");

        //Refresh button
        WebElement RefreshElement = driver.findElement(By.id("Button1"));
        RefreshElement.click();


    }


}
