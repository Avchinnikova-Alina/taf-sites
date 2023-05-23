package by.itacademy.avchinnikova.alina.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DominosPage {
    private ChromeDriver driver;
    private String closePopUpSelector = "body > div.custom-modal.custom-modal--size-content.custom-modal--padding-none.custom-modal--bg-transparent > div.custom-modal__content-holder > button > span > span.custom-button__content-children > svg";
    private String buttonEnterXpath = "//*[@id='app-root']/div/div[1]/div[1]/div/div[4]/div/div/div[3]/button";
    private String inputEmailXpath = "/html/body/div[4]/div[2]/div/div/div/div[2]/div[2]/div/form/div/div[1]/input";
    private String inputPasswordXpath = "/html/body/div[4]/div[2]/div/div/div/div[2]/div[2]/div/form/div/div[2]/input";
    private String buttonSignInXpath = "/html/body/div[4]/div[2]/div/div/div/div[2]/div[2]/div/form/div/button";

    public DominosPage(ChromeDriver newDriver) {
        driver = newDriver;
    }

    public void clickClosePopUp() {
        WebElement closePopUp = driver.findElement(By.cssSelector(closePopUpSelector));
        closePopUp.click();
    }

    public void clickButtonEnter() {
        WebElement buttonEnter = driver.findElement(By.xpath(buttonEnterXpath));
        buttonEnter.click();
    }

    public void clickButtonSignIn() {
        WebElement buttonSignIn = driver.findElement(By.xpath(buttonSignInXpath));
        buttonSignIn.click();
    }

    public void sendKeysInputEmail(String email) {
        WebElement inputEmail = driver.findElement(By.xpath(inputEmailXpath));
        inputEmail.sendKeys(Util.generateIncorrectEmail(15));
        inputEmail.sendKeys(Util.generateСorrectEmail(10));
    }
    public void sendKeysInputPassword(String password){
        WebElement inputPassword = driver.findElement(By.xpath(inputPasswordXpath));
        inputPassword.sendKeys(Util.generatePassword(15));
    }
}
