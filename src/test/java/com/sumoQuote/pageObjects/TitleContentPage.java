package com.sumoQuote.pageObjects;

import com.sumoQuote.utilities.CommonUtils;
import com.sumoQuote.utilities.PropertyFileReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class TitleContentPage extends GetStartedPage {
    private WebDriver driver;

    public TitleContentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "capabilities")
    WebElement capabilities1;
    @FindBy(id = "capabilities2")
    WebElement capabilities2;
    @FindBy(xpath = "(//span[contains(text(),'See my')])[2]/..")
    private WebElement seeMyBrandButton;
    @FindBy(xpath = "//input[@class='input-file']")
    private WebElement logoFile;

    public void uploadImage() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", logoFile);


        try {
            Robot  robot = new Robot();
            StringSelection s=new StringSelection("D:\\QA\\TakeAwayAssaignments\\sumoQuoteHW\\sumoQuoteHW\\sampleLogo.jpg");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        Wait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);
        // Wait for the file upload to complete (add an appropriate delay if necessary)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='far fa-trash']")));

    }

    public void enterFirstCapability(String firstCapab) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", capabilities1);
        try {
            Robot  robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_DELETE);
            robot.keyRelease(KeyEvent.VK_DELETE);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        capabilities1.sendKeys(firstCapab);
    }

    public void enterSecondCapability(String secondCapab) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", capabilities2);
        try {
            Robot  robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_DELETE);
            robot.keyRelease(KeyEvent.VK_DELETE);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
       capabilities2.sendKeys(secondCapab);
    }

    public void clickOnSeemybrand() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", seeMyBrandButton);
//        hitTab();
//        hitSpace();
    }
}
