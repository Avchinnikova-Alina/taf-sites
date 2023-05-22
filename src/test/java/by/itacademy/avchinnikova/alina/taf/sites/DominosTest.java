package by.itacademy.avchinnikova.alina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DominosTest {
    ChromeDriver driver = new ChromeDriver();
    DominosPage page = new DominosPage();

    @BeforeEach
    public void warmUp() {
        driver.get("https://dominos.by/");
        WebElement closePopUp = driver.findElement(By.cssSelector(page.closePopUpSelector));
        closePopUp.click();
        WebElement submitEnterButton = driver.findElement(By.xpath(page.buttonEnterXpath));
        submitEnterButton.click();
    }

    @Test
    public void incorrectEmailAndPassword() {
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("avchinnikova1012");
        WebElement inputPassword = driver.findElement(By.xpath(page.inputPasswordXpath));
        inputPassword.sendKeys("qwerty1");
        WebElement submitSignInButton = driver.findElement(By.xpath(page.buttonSignInXpath));
        submitSignInButton.click();
    }

    @Test
    public void correctEmailAndPassword() {
        WebElement inputEmail = driver.findElement(By.xpath(page.inputEmailXpath));
        inputEmail.sendKeys("avchinnikova1012@gmail.com");
        WebElement inputPassword = driver.findElement(By.xpath(page.inputPasswordXpath));
        inputPassword.sendKeys("qwerty1");
        WebElement submitSignInButton = driver.findElement(By.xpath(page.buttonSignInXpath));
        submitSignInButton.click();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }}
