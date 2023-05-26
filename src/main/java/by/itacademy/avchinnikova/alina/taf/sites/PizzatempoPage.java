package by.itacademy.avchinnikova.alina.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoPage {
    private ChromeDriver driver;
    private String inputEmailName = "astroauth_login";
    private String inputPasswordName = "astroauth_pass";
    private String buttonSignInName = "astroauth_submit";

    public PizzatempoPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void sendKeysInputEmail(String email) {
        WebElement inputEmail = driver.findElement(By.name(inputEmailName));
        inputEmail.sendKeys(email);
    }

    public void sendKeysInputPassword(String password) {
        WebElement inputPassword = driver.findElement(By.name(inputPasswordName));
        inputPassword.sendKeys(password);
    }

    public void clickButtonSignIn() {
        WebElement buttonSignIn = driver.findElement(By.name(buttonSignInName));
        buttonSignIn.click();
    }
}

