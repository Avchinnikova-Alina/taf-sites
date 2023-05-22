package by.itacademy.avchinnikova.alina.taf.sites;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TripadvisorTest {
    ChromeDriver driver = new ChromeDriver();
    TripadvisorPage page = new TripadvisorPage();

    @BeforeEach
    public void warmUp(){
        driver.get("https://www.tripadvisor.com/");
    }

    @Test
    public void emptyEmailAndPassword() throws InterruptedException {
        WebElement submitSignInButton = driver.findElement(By.xpath(page.buttonRegisterXpath));
        submitSignInButton.click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='regcontroller']")));
        WebElement submitContinueWithEmailButton = driver.findElement(By.xpath(page.buttonContinueXpath));
        submitContinueWithEmailButton.click();
        WebElement submitFinalSignInButton = driver.findElement(By.xpath(page.buttonSignInXpath));
        submitFinalSignInButton.click();
    }

    @Test
    public void incorrectEmail() throws InterruptedException {
        WebElement submitSignInButton = driver.findElement(By.xpath(page.buttonRegisterXpath));
        submitSignInButton.click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='regcontroller']")));
        WebElement submitContinueWithEmailButton = driver.findElement(By.xpath(page.buttonContinueXpath));
        submitContinueWithEmailButton.click();
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("avchinnikova1012");
        WebElement submitFinalSignInButton = driver.findElement(By.xpath(page.buttonSignInXpath));
        submitFinalSignInButton.click();
    }

    @Test
    public void correctEmailAndEmptyPassword() throws InterruptedException {
        WebElement submitSignInButton = driver.findElement(By.xpath(page.buttonRegisterXpath));
        submitSignInButton.click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='regcontroller']")));
        WebElement submitContinueWithEmailButton = driver.findElement(By.xpath(page.buttonContinueXpath));
        submitContinueWithEmailButton.click();
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("avchinnikova1012@gmail.com");
        WebElement submitFinalSignInButton = driver.findElement(By.xpath(page.buttonSignInXpath));
        submitFinalSignInButton.click();
    }

    @Test
    public void correctEmailAndPassword() throws InterruptedException {
        WebElement submitSignInButton = driver.findElement(By.xpath(page.buttonRegisterXpath));
        submitSignInButton.click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='regcontroller']")));
        WebElement submitContinueWithEmailButton = driver.findElement(By.xpath(page.buttonContinueXpath));
        submitContinueWithEmailButton.click();
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("avchinnikova1012@gmail.com");
        WebElement inputPassword = driver.findElement(By.xpath(page.inputPasswordXpath));
        inputPassword.sendKeys("qwerty1");
        WebElement submitFinalSignInButton = driver.findElement(By.xpath(page.buttonSignInXpath));
        submitFinalSignInButton.click();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}