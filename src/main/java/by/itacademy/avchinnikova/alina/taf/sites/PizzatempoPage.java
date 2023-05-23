package by.itacademy.avchinnikova.alina.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoPage {
    private ChromeDriver driver;
    private String inputEmailXpath = "/html/body/div/div[1]/form/p[1]/input";
    private String inputPasswordXpath = "/html/body/div/div[1]/form/p[2]/input[1]";
    private String buttonSignInXpath = "/html/body/div/div[1]/form/p[2]/input[2]";

    public PizzatempoPage(ChromeDriver newDriver) {
        driver = newDriver;
    }

    public void clickButtonSignIn() {
        WebElement buttonSignIn = driver.findElement(By.xpath(buttonSignInXpath));
        buttonSignIn.click();
    }

    public void sendKeysInputEmail(String email) {
        WebElement inputEmail = driver.findElement(By.xpath(inputEmailXpath));
        inputEmail.sendKeys(Util.generateСorrectEmail(5));
        inputEmail.sendKeys(Util.generateIncorrectEmail(5));
    }

    public void sendKeysInputPassword(String password) {
        WebElement inputPassword = driver.findElement(By.xpath(inputPasswordXpath));
        inputPassword.sendKeys(Util.generatePassword(15));
    }
}

