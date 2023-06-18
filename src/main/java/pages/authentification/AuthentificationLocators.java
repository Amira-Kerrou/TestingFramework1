package pages.authentification;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import base.BaseSetup;


public class AuthentificationLocators extends BaseSetup {

    public AuthentificationLocators() {
    }

    @FindBy(xpath = "//input[@formcontrolname='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@formcontrolname='Password']")
    public WebElement password;

    @FindBy(xpath = "//button[@class='login100-form-btn' and normalize-space()='Login']")
    public WebElement loginButton;

    public void login() {
        email.sendKeys("akerrou@spark-it.fr");
        password.sendKeys("Azerty123**");
        loginButton.click();
    }
}



