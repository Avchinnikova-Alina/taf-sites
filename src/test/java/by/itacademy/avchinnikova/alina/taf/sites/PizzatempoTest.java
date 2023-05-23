package by.itacademy.avchinnikova.alina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoTest {
    ChromeDriver driver = new ChromeDriver();
    PizzatempoPage page = new PizzatempoPage();

    @BeforeEach
    public void warmUp() {
        driver.get("https://www.pizzatempo.by/");
    }

    @Test
    public void emptyEmailAndEmptyPassword() {
        WebElement buttonSignIn = driver.findElement(By.xpath(page.buttonSignInXpath));
        buttonSignIn.click();
    }

    @Test
    public void incorrectEmail() {
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("avchinnikova1012");
        WebElement buttonSignIn = driver.findElement(By.xpath(page.buttonSignInXpath));
        buttonSignIn.click();
    }

    @Test
    public void emptyEmailAndSomePassword() {
        WebElement inputPassword = driver.findElement(By.xpath(page.inputPasswordXpath));
        inputPassword.sendKeys("qwerty1");
        WebElement buttonSignIn = driver.findElement(By.xpath(page.buttonSignInXpath));
        buttonSignIn.click();
    }

    @Test
    public void correctEmailAndEmptyPassword() {
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("avchinnikova1012@gmail.com");
        WebElement buttonSignIn = driver.findElement(By.xpath(page.buttonSignInXpath));
        buttonSignIn.click();
    }

    @Test
    public void correctEmailAndPassword() {
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("avchinnikova1012@gmail.com");
        WebElement inputPassword = driver.findElement(By.xpath(page.inputPasswordXpath));
        inputPassword.sendKeys("qwerty1");
        WebElement buttonSignIn = driver.findElement(By.xpath(page.buttonSignInXpath));
        buttonSignIn.click();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
