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
    public void testBookingWithEmptyEmail() throws InterruptedException {
        Thread.sleep(1000);
        WebElement submitButtonEnter = driver.findElement(By.xpath(page.buttonEnterXpath));
        submitButtonEnter.click();
        WebElement submitEmailButton = driver.findElement(By.xpath(page.buttonContinueXpath));
        submitEmailButton.click();
    }

    @Test
    public void testBookingWithIncorrectEmail() throws InterruptedException {
        Thread.sleep(1000);
        WebElement submitButtonEnter = driver.findElement(By.xpath(page.buttonEnterXpath));
        submitButtonEnter.click();
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("email");
        WebElement submitEmailButton = driver.findElement(By.xpath(page.buttonContinueXpath));
        submitEmailButton.click();
    }

    @Test
    public void testBookingWithCorrectEmail() throws InterruptedException {
        Thread.sleep(1000);
        WebElement submitButtonEnter = driver.findElement(By.xpath(page.buttonEnterXpath));
        submitButtonEnter.click();
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("test@gmail.com");
        WebElement submitEmailButton = driver.findElement(By.xpath(page.buttonContinueXpath));
        submitEmailButton.click();
    }

    @Test
    public void testBookingWithCorrectEmailAndEmptyPassword() throws InterruptedException {
        Thread.sleep(1000);
        WebElement submitButtonEnter = driver.findElement(By.xpath(page.buttonEnterXpath));
        submitButtonEnter.click();
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("test@gmail.com");
        WebElement submitEmailButton = driver.findElement(By.xpath(page.buttonContinueXpath));
        submitEmailButton.click();
        Thread.sleep(1500);
        WebElement submitPasswordButton = driver.findElement(By.xpath(page.buttonPasswordXpath));
        submitPasswordButton.click();
    }

    @Test
    public void testBookingWithCorrectEmailAndCorrectPassword() throws InterruptedException {
        Thread.sleep(1000);
        WebElement submitButtonEnter = driver.findElement(By.xpath(page.buttonEnterXpath));
        submitButtonEnter.click();
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("test@gmail.com");
        WebElement submitEmailButton = driver.findElement(By.xpath(page.buttonContinueXpath));
        submitEmailButton.click();
        Thread.sleep(1500);
        WebElement inputPassword = driver.findElement(By.xpath(page.inputPasswordXpath));
        inputPassword.sendKeys("qwerty1");
        WebElement submitPasswordButton = driver.findElement(By.xpath(page.buttonPasswordXpath));
        submitPasswordButton.click();
    }

    @AfterEach
    public void tearsDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
        Thread.sleep(1000);
    }
}

