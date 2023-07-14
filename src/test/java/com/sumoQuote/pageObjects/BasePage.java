package com.sumoQuote.pageObjects;

import com.sumoQuote.utilities.BrowserFactory;
import com.sumoQuote.utilities.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "accountName")
    private WebElement accountName;
    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "emailAddress")
    private WebElement emailAddress;
    @FindBy(id = "phoneNumber")
    private WebElement phoneNumber;
    @FindBy(id = "Password")
    private WebElement password;
    @FindBy(id = "repeatPassword")
    private WebElement repeatPassword;
    @FindBy(className = "v-select__slot")
    private WebElement list;
    @FindBy(xpath = "//input[@id='disclaimerAgree']")
    private WebElement disclaimerAgree;
    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement saveButton;
    @FindBy(xpath = "//a[contains(text(),'LOG')]")
    private WebElement logIn;
    @FindBy(xpath = "//div[contains(text(),'Google')]")
    private WebElement option;


    public void enterOrgName(String s) {
        accountName.sendKeys(s);
    }

    public void enterFirstName(String s) {
        firstName.sendKeys(s);
    }

    public void enterLastName(String s) {
        lastName.sendKeys(s);
    }

    public void enterEmail(String s) {
        emailAddress.sendKeys(s);
    }

    public void enterPhoneNumber(String s) {
        phoneNumber.sendKeys(s);
    }

    public void enterPass(String s) {
        password.sendKeys(s);
    }

    public void enterConfirmPass(String s) {
        repeatPassword.sendKeys(s);
    }


    public void hitEnter() {
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void hitTab() {
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_TAB);
            r.keyRelease(KeyEvent.VK_TAB);
            CommonUtils.waitDefininte(1);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
    public void pageScrool() {
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_PAGE_DOWN);
            r.keyRelease(KeyEvent.VK_PAGE_DOWN);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void hitSpace() {
        CommonUtils.waitDefininte(1);
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_SPACE);
            r.keyRelease(KeyEvent.VK_SPACE);
            CommonUtils.waitDefininte(1);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectOption(String opted) {
        list.click();
        option.click();
    }

    //input[@id='disclaimerAgree']  disclaimerAgree
    public void clickTermsAndSave() {
        WebElement disclaimerAgree = driver.findElement(By.xpath("//input[@id='disclaimerAgree']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", disclaimerAgree);
//        hitTab();
//        hitTab();
//        hitSpace();
    }

    public void clickSave() {
        saveButton.click();
    }
    public void clickLogin() {
        logIn.click();
    }


}
