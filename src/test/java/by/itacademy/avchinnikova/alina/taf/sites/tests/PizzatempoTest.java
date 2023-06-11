package by.itacademy.avchinnikova.alina.taf.sites.tests;

import by.itacademy.avchinnikova.alina.taf.sites.pages.PizzatempoPage;
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
        pizzatempoPage = new PizzatempoPage(driver);
        faker = new Faker();
        util = new Util();
    }

    @Test
    public void emptyEmailAndEmptyPassword() {
        pizzatempoPage.clickButtonSignIn();
        Assertions.assertEquals("Заполните форму", pizzatempoPage.getAlert());
    }

    @Test
    public void incorrectEmail() {
        pizzatempoPage.
                sendKeysInputEmail(Util.generateIncorrectEmail(5)).
                clickButtonSignIn();
        Assertions.assertEquals("Заполните форму", pizzatempoPage.getAlert());
    }

    @Test
    public void emptyEmailAndSomePassword() {
        pizzatempoPage.
                sendKeysInputPassword(faker.internet().password()).
                clickButtonSignIn();
        Assertions.assertEquals("Заполните форму", pizzatempoPage.getAlert());
    }

    @Test
    public void correctEmailAndEmptyPassword() {
        pizzatempoPage.
                sendKeysInputEmail(faker.internet().emailAddress()).
                clickButtonSignIn();
        Assertions.assertEquals("Заполните форму", pizzatempoPage.getAlert());
    }

    @Test
    public void correctEmailAndPassword() {
        pizzatempoPage.
                sendKeysInputEmail(faker.internet().emailAddress()).
                sendKeysInputPassword(faker.internet().password()).
                clickButtonSignIn();
        Assertions.assertEquals("Неверно указано имя пользователя или пароль.\n" +
                "Ok", pizzatempoPage.getError());
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}

