package com.sumoQuote.pageObjects;

import com.sumoQuote.utilities.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrandingPage extends TitleContentPage {
    private WebDriver driver;
    String window;

    public BrandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    //(//span[normalize-space()='Confirm']/..)[1]
    ///html/body/div/div/div/div/main/div/div/div/div/div[3]/div/div[2]/div/div/div[4]/div/button
    @FindBy(xpath = "(//span[normalize-space()='Confirm']/..)[1]")
    private WebElement confirmButton;
    @FindBy(xpath = "(//img[@class='templateImg'])[1]")
    private WebElement secondImage;

    @FindBy(xpath = "//div[@class='textLayer']")
    private WebElement iframe;

    public void selectImage() {
        secondImage.click();
        CommonUtils.waitDefininte(3);
    }

    public void clickConfirm() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", confirmButton);
    }
}
