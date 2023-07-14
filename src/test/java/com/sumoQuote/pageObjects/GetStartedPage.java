package com.sumoQuote.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GetStartedPage extends LoginPage{
    private WebDriver driver;
    public GetStartedPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }
    public void clickGetStarted(){
        FluentWait<WebDriver> fw = new WebDriverWait(driver, Duration.ofSeconds(1L));//upcasting
        fw.pollingEvery(Duration.ofSeconds(2)); //ctp
        fw.ignoring(NoSuchElementException.class);  //ctp
        WebElement getStarted = fw.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Get')]")));
        getStarted.click();
    }
}
