package com.sumoQuote.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class BrowserFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void openChrome() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }

    public static void newWindow(WebDriver driver) {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public static void launchUrl(String passUrl) {
        driver.get().get(passUrl);
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.get().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeAllWindows() {
        driver.get().quit();
    }


}
