package by.itacademy.avchinnikova.alina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class DominosTest {
    ChromeDriver driver = new ChromeDriver();
    DominosPage page = new DominosPage(driver);

    @BeforeEach
    public void warmUp() {
        driver.get("https://dominos.by/");
        page.clickClosePopUp();
        page.clickButtonEnter();
    }

    @Test
    public void incorrectEmailAndPassword() {
        page.sendKeysInputEmail(Util.generateIncorrectEmail(15));
        page.sendKeysInputPassword(Util.generatePassword(5));
        page.clickButtonSignIn();
    }

    @Test
    public void correctEmailAndPassword() {
        page.sendKeysInputEmail(Util.generateСorrectEmail(10));
        page.sendKeysInputPassword(Util.generatePassword(5));
        page.clickButtonSignIn();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
