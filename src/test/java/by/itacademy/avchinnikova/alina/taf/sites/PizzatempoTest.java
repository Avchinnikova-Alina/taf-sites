package by.itacademy.avchinnikova.alina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoTest {
    ChromeDriver driver = new ChromeDriver();
    PizzatempoPage page = new PizzatempoPage(driver);

    @BeforeEach
    public void warmUp() {
        driver.get("https://www.pizzatempo.by/");
    }

    @Test
    public void emptyEmailAndEmptyPassword() {
        page.clickButtonSignIn();
    }

    @Test
    public void incorrectEmail() {
        page.sendKeysInputEmail(Util.generateIncorrectEmail(5));
        page.clickButtonSignIn();
    }

    @Test
    public void emptyEmailAndSomePassword() {
        page.sendKeysInputPassword(Util.generatePassword(5));
        page.clickButtonSignIn();
    }

    @Test
    public void correctEmailAndEmptyPassword() {
        page.sendKeysInputEmail(Util.generateСorrectEmail(5));
        page.clickButtonSignIn();
    }

    @Test
    public void correctEmailAndPassword() {
        page.sendKeysInputEmail(Util.generateСorrectEmail(5));
        page.sendKeysInputPassword(Util.generatePassword(5));
        page.clickButtonSignIn();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
