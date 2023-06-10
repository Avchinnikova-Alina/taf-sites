package by.itacademy.avchinnikova.alina.taf.sites.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoPage {
    private ChromeDriver driver;
    private String inputEmailName = "astroauth_login";
    private String inputPasswordName = "astroauth_pass";
    private String buttonSignInName = "astroauth_submit";
    private String errortextXpath = "//*[@id='alert']/div[2]/div[2]";

    public PizzatempoPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public PizzatempoPage sendKeysInputEmail(String email) {
        WebElement inputEmail = driver.findElement(By.name(inputEmailName));
        inputEmail.sendKeys(email);
        return this;
    }

    public PizzatempoPage sendKeysInputPassword(String password) {
        WebElement inputPassword = driver.findElement(By.name(inputPasswordName));
        inputPassword.sendKeys(password);
        return this;
    }

    public PizzatempoPage clickButtonSignIn() {
        WebElement buttonSignIn = driver.findElement(By.name(buttonSignInName));
        buttonSignIn.click();
        return this;
    }

    public String getAlert() {

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        return alertMessage;
    }

    public String getError() {

        WebElement actError = driver.findElement(By.xpath(errortextXpath));
        String actErrorMessage = actError.getText();
        return actErrorMessage;
    }
}

