package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement login;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void enterCredentials(String name, String pass) {
        userName.sendKeys(name);
        password.sendKeys(pass);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login.click();
    }

}
