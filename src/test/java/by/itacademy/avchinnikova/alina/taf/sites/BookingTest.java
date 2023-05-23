package by.itacademy.avchinnikova.alina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BookingTest {
    ChromeDriver driver;
    BookingPage page = new BookingPage();

    @BeforeEach
    public void warmUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        driver = new ChromeDriver(options);
        driver.get("https://www.booking.com/");
        Thread.sleep(1500);
        WebElement closePopUp = driver.findElement(By.cssSelector(page.buttonLoginXpath));
        closePopUp.click();
    }

    @Test
    public void emptyEmail() throws InterruptedException {
        Thread.sleep(2000);
        WebElement buttonContinue = driver.findElement(By.xpath(page.buttonContinueXpath));
        buttonContinue.click();
    }

    @Test
    public void incorrectEmail() throws InterruptedException {
        Thread.sleep(2000);
        WebElement buttonEnter = driver.findElement(By.xpath(page.buttonEnterXpath));
        buttonEnter.click();
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("avchinnikova1012");
        WebElement buttonContinue = driver.findElement(By.xpath(page.buttonContinueXpath));
        buttonContinue.click();
    }

    @Test
    public void correctEmail() throws InterruptedException {
        Thread.sleep(2000);
        WebElement buttonEnter = driver.findElement(By.xpath(page.buttonEnterXpath));
        buttonEnter.click();
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("avchinnikova1012@gmail.com");
        WebElement buttonContinue = driver.findElement(By.xpath(page.buttonContinueXpath));
        buttonContinue.click();
    }

    @Test
    public void correctEmailAndEmptyPassword() throws InterruptedException {
        Thread.sleep(2000);
        WebElement buttonEnter = driver.findElement(By.xpath(page.buttonEnterXpath));
        buttonEnter.click();
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("test@gmail.com");
        WebElement buttonContinue = driver.findElement(By.xpath(page.buttonContinueXpath));
        buttonContinue.click();
        Thread.sleep(2000);
        WebElement buttonLogin = driver.findElement(By.xpath(page.buttonLoginXpath));
        buttonLogin.click();
    }

    @Test
    public void correctEmailAndCorrectPassword() throws InterruptedException {
        Thread.sleep(2000);
        WebElement buttonEnter = driver.findElement(By.xpath(page.buttonEnterXpath));
        buttonEnter.click();
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("avchinnikova1012@gmail.com");
        WebElement buttonContinue = driver.findElement(By.xpath(page.buttonContinueXpath));
        buttonContinue.click();
        Thread.sleep(1500);
        WebElement inputPassword = driver.findElement(By.xpath(page.inputPasswordXpath));
        inputPassword.sendKeys("qwerty1");
        WebElement buttonLogin = driver.findElement(By.xpath(page.buttonLoginXpath));
        buttonLogin.click();
    }

    @AfterEach
    public void tearsDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}

