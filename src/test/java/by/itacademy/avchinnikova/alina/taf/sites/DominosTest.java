package by.itacademy.avchinnikova.alina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class DominosTest {
    ChromeDriver driver;
    DominosStep dominosStep;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        dominosStep = new DominosStep(driver);
        driver.get("https://dominos.by/");
    }

    @Test
    public void incorrectEmailAndPassword() {
        dominosStep.fillLoginFormAndSubmit(Util.generateIncorrectEmail(5), Util.generatePassword(5));
    }

    @Test
    public void correctEmailAndPassword() {
        dominosStep.fillLoginFormAndSubmit(Util.generateСorrectEmail(5), Util.generatePassword(5));
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
