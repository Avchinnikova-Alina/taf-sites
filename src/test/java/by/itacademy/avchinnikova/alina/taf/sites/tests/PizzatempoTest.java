package by.itacademy.avchinnikova.alina.taf.sites.tests;

import by.itacademy.avchinnikova.alina.taf.sites.pages.PizzatempoPage;
import by.itacademy.avchinnikova.alina.taf.sites.steps.PizzatempoStep;
import by.itacademy.avchinnikova.alina.taf.sites.utils.Util;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PizzatempoTest {
    ChromeDriver driver;
    PizzatempoStep pizzatempoStep;
    PizzatempoPage pizzatempoPage;
    Faker faker;
    Util util;

    @BeforeEach
    public void warmUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.pizzatempo.by/");
        pizzatempoStep = new PizzatempoStep(driver);
        pizzatempoPage = new PizzatempoPage(driver);
        faker = new Faker();
        util = new Util();
    }

    @Test
    public void emptyEmailAndEmptyPassword() {
        pizzatempoStep.fillLoginFormAndSubmit("", "");
        Assertions.assertEquals("Заполните форму", pizzatempoPage.getAlert());
    }

    @Test
    public void incorrectEmail() {
        pizzatempoStep.fillLoginFormAndSubmit(Util.generateIncorrectEmail(5), "");
        Assertions.assertEquals("Заполните форму", pizzatempoPage.getAlert());
    }

    @Test
    public void emptyEmailAndSomePassword() {
        pizzatempoStep.fillLoginFormAndSubmit("", faker.internet().password());
        Assertions.assertEquals("Заполните форму", pizzatempoPage.getAlert());
    }

    @Test
    public void correctEmailAndEmptyPassword() {
        pizzatempoStep.fillLoginFormAndSubmit(faker.internet().emailAddress(), "");
        Assertions.assertEquals("Заполните форму", pizzatempoPage.getAlert());
    }

    @Test
    public void correctEmailAndPassword() {
        pizzatempoStep.fillLoginFormAndSubmit(faker.internet().emailAddress(), faker.internet().password());
        Assertions.assertEquals("Неверно указано имя пользователя или пароль.\n" +
                "Ok", pizzatempoPage.getError());
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}

