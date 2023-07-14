package com.sumoQuote.testRunners;

import com.sumoQuote.pageObjects.*;
import com.sumoQuote.utilities.BrowserFactory;
import com.sumoQuote.utilities.CommonUtils;
import com.sumoQuote.utilities.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.sumoQuote.extentReports.ExtentTestManager.startTest; //important

import java.lang.reflect.Method;
import java.time.Duration;

public class SampleTest {
    WebDriver driver;
    String currentPageTitle;
    String loginId = PropertyFileReader.getPropertyValue("sumoQuote.data.loginId");
    String loginPass = PropertyFileReader.getPropertyValue("sumoQuote.data.enterConfirmPass");

    public WebDriver getDriver() {
        return driver;
    }

    @Test(groups = "high", description = "Verifying New User Creation using dummy email ID ")
    public void accountCreationTest(Method method) {
        startTest(method.getName(), "Verifying New User Creation using dummy email ID");
        BrowserFactory.openChrome();
        driver = BrowserFactory.getDriver();
        BrowserFactory.launchUrl(PropertyFileReader.getPropertyValue("sumoQuote.url"));
        BasePage bp = new BasePage(driver);
        bp.enterOrgName(PropertyFileReader.getPropertyValue("sumoQuote.data.enterOrgName"));
        bp.enterFirstName(PropertyFileReader.getPropertyValue("sumoQuote.data.enterFirstName"));
        bp.enterLastName(PropertyFileReader.getPropertyValue("sumoQuote.data.enterLastName"));
        bp.enterEmail(loginId);
        bp.enterPhoneNumber(PropertyFileReader.getPropertyValue("sumoQuote.data.enterPhoneNumber"));
        bp.enterPass(loginPass);
        bp.enterConfirmPass(loginPass);
        bp.selectOption(PropertyFileReader.getPropertyValue("sumoQuote.data.selectOption"));
        bp.clickTermsAndSave();
        bp.clickSave();
        currentPageTitle=driver.getTitle();
        Assert.assertEquals(currentPageTitle, "SumoQuote - SumoQuote", "Page Titles are not matching as per Design Document");
        System.out.println("Current Page Title is : "+currentPageTitle);
        CommonUtils.waitDefininte(3);
        BrowserFactory.closeAllWindows();
    }

    @Test(groups = "medium", description = "Verifying Dashboard Setup")
    public void loginAndSetupTest( Method method) {
        startTest(method.getName(), "Verifying Dashboard Setup");
        BrowserFactory.openChrome();
        BrowserFactory.launchUrl(PropertyFileReader.getPropertyValue("sumoQuote.loginUrl"));
        driver = BrowserFactory.getDriver();

        LoginPage lp = new LoginPage(driver);
        GetStartedPage getStartedPage = new GetStartedPage(driver);
        CommonUtils.waitDefininte(3);
        lp.enterCredentialsAndLogin(loginId, loginPass);

        currentPageTitle=driver.getTitle();
        Assert.assertEquals(currentPageTitle, "Sign In To SUMOQUOTE!", "Page Titles are not matching as per Design Document");
        System.out.println("Current Page Title is : "+currentPageTitle);
        getStartedPage.clickGetStarted();

        CommonUtils.waitDefininte(3);
        currentPageTitle=driver.getTitle();
        Assert.assertEquals(currentPageTitle, "SumoQuote - SumoQuote", "Page Titles are not matching as per Design Document");
        System.out.println("Current Page Title is : "+currentPageTitle);

        TitleContentPage titleContentPage = new TitleContentPage(driver);
        titleContentPage.uploadImage();
        titleContentPage.enterFirstCapability(PropertyFileReader.getPropertyValue("sumoQuote.data.firstCapability"));
        titleContentPage.enterSecondCapability( PropertyFileReader.getPropertyValue("sumoQuote.data.secondCapability"));
       titleContentPage.clickOnSeemybrand();
       CommonUtils.waitDefininte(3);
        currentPageTitle=driver.getTitle();
        Assert.assertEquals(currentPageTitle, "SumoQuote - SumoQuote", "Page Titles are not matching as per Design Document");
        System.out.println("Current Page Title is : "+currentPageTitle);

        BrandingPage brandingPage = new BrandingPage(driver);
        CommonUtils.waitDefininte(3);
        brandingPage.clickConfirm();
        currentPageTitle=driver.getTitle();
        Assert.assertEquals(currentPageTitle, "SumoQuote - SumoQuote", "Page Titles are not matching as per Design Document");
        System.out.println("Current Page Title is : "+currentPageTitle);

        YourWorkPage yourWorkPage = new YourWorkPage(driver);
        yourWorkPage.clickResRoofing();
        yourWorkPage.clickFinish();
        currentPageTitle=driver.getTitle();
        Assert.assertEquals(currentPageTitle, "SumoQuote - SumoQuote", "Page Titles are not matching as per Design Document");
        System.out.println("Current Page Title is : "+currentPageTitle);
        BrowserFactory.closeAllWindows();

    }
}
