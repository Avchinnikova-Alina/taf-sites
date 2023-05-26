package by.itacademy.avchinnikova.alina.taf.sites;

import org.openqa.selenium.chrome.ChromeDriver;

public class DominosStep {
    DominosPage page;

    public DominosStep(ChromeDriver driver){
        page = new DominosPage(driver);
    }

    public void fillLoginFormAndSubmit(String email, String password) {
        page.clickClosePopUp();
        page.clickButtonEnter();
        page.sendKeysInputEmail(email);
        page.sendKeysInputPassword(password);
        page.clickButtonSignIn();
    }
}
