package com.codecool.atestingtw2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    static WebDriver driver;

/* @BeforeEach
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/Users/krausadam/Desktop/codecool/Advanced/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
       // options.addExtensions(new File("/Users/krausadam/Desktop/codecool/Advanced/adblockerPlus.crx"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");*/

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/krausadam/Desktop/codecool/Advanced/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp?os_destination=%2Fsecure%2FTests.jspa#/design?projectId=10101");
    }

    @Test
    public void checkHappyPath() {
       WebElement userName = driver.findElement(By.name("os_username"));
       userName.sendKeys("");//test things
        WebElement passWord = driver.findElement(By.name("os_password"));
        passWord.sendKeys("");
        driver.findElement(By.name("login")).click();
    }



}