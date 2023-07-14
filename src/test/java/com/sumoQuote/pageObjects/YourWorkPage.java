package com.sumoQuote.pageObjects;

import com.sumoQuote.utilities.CommonUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourWorkPage extends BrandingPage {
    WebDriver driver;

    public YourWorkPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Residential Roofing')]")
    private WebElement resRoofing;
    @FindBy(xpath = "//div[contains(text(),'Atlas')]")
    private WebElement atlas;
    @FindBy(xpath = "//span[contains(text(),'Ok')]")
    private WebElement ok;
    @FindBy(xpath = "(//span[contains(text(),'Finish')]/..)[2]")
    private WebElement finish;

    public void clickResRoofing() {
       resRoofing.click();
       driver.switchTo().activeElement();
        CommonUtils.waitDefininte(3);
        atlas.click();
        ok.click();

    }

    public void clickFinish() {
        CommonUtils.waitDefininte(2);
        WebElement ele = driver.findElement(By.xpath("//div[@class='container d-flex flex-column']//span[normalize-space()='Finish']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", ele);
    }
}

