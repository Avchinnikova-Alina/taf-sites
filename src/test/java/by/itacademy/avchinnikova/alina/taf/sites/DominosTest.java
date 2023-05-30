package by.itacademy.avchinnikova.alina.taf.sites;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class DominosTest {
    ChromeDriver driver;
    PizzatempoStep pizzatempoStep;
    Faker faker;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        pizzatempoStep = new PizzatempoStep(driver);
        faker = new Faker();
        driver.manage().window().maximize();
        driver.get("https://www.pizzatempo.by/");
    }

    @Test
    public void emptyEmailAndEmptyPassword() {
        pizzatempoStep.fillLoginFormAndSubmit("", "");
    }

    @Test
    public void incorrectEmail() {
        pizzatempoStep.fillLoginFormAndSubmit(faker.internet().emailAddress(), "");

    }

    @Test
    public void emptyEmailAndSomePassword() {
        pizzatempoStep.fillLoginFormAndSubmit("", faker.internet().password());
    }

    @Test
    public void correctEmailAndEmptyPassword() {
        pizzatempoStep.fillLoginFormAndSubmit(faker.internet().emailAddress(), "");
    }

    @Test
    public void correctEmailAndPassword() {
        pizzatempoStep.fillLoginFormAndSubmit(faker.internet().emailAddress(), faker.internet().password());
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
