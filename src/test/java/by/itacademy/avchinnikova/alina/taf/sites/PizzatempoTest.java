package by.itacademy.avchinnikova.alina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoTest {
    ChromeDriver driver;
    PizzatempoStep pizzatempoStep;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        pizzatempoStep = new PizzatempoStep(driver);
        driver.manage().window().maximize();
        driver.get("https://www.pizzatempo.by/");
    }

    @Test
    public void emptyEmailAndEmptyPassword() {
        pizzatempoStep.fillLoginFormAndSubmit("", "");
    }

    @Test
    public void incorrectEmail() {
        pizzatempoStep.fillLoginFormAndSubmit(Util.generateIncorrectEmail(5), "");

    }

    @Test
    public void emptyEmailAndSomePassword() {
        pizzatempoStep.fillLoginFormAndSubmit("", Util.generatePassword(5));
    }

    @Test
    public void correctEmailAndEmptyPassword() {
        pizzatempoStep.fillLoginFormAndSubmit(Util.generateСorrectEmail(5), "");
    }

    @Test
    public void correctEmailAndPassword() {
        pizzatempoStep.fillLoginFormAndSubmit(Util.generateСorrectEmail(5), Util.generatePassword(5));
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}

