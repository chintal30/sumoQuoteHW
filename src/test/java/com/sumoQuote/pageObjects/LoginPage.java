package com.sumoQuote.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement loginId;
    @FindBy(xpath = "//input[@name='password']")
    WebElement loginPass;
    @FindBy(xpath = "//span[contains(text(),'Log')]")
    private WebElement logInSpan;

    public void enterCredentialsAndLogin(String s1, String s2) {
        loginId.sendKeys(s1);
        loginPass.sendKeys(s2);
        logInSpan.click();
    }

}
