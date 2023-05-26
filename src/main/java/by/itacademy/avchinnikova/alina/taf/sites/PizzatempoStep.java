package by.itacademy.avchinnikova.alina.taf.sites;

import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoStep {
    PizzatempoPage page;

    public PizzatempoStep(ChromeDriver driver) {
        page = new PizzatempoPage(driver);
    }

    public void fillLoginFormAndSubmit(String email, String password) {
        page.sendKeysInputEmail(email);
        page.sendKeysInputPassword(password);
        page.clickButtonSignIn();
    }
}
