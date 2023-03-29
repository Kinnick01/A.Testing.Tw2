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
    WebElement username;
    WebElement passWord;
    WebElement loginButton;


    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/krausadam/Desktop/codecool/Advanced/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp?os_destination=%2Fsecure%2FTests.jspa#/design?projectId=10101");
        username = driver.findElement(By.name("os_username"));
        passWord = driver.findElement(By.name("os_password"));
        loginButton = driver.findElement(By.name("login"));
    }

    @Test
    public void successfulLogin() {
        username.sendKeys("automation47");//add username
        passWord.sendKeys("CCAutoTest19.");//add Password
        loginButton.click();
        driver.findElement(By.id("user-options")).click();
        assertTrue(driver.findElement(By.id("log_out")).isDisplayed());

    }

    @Test
    public void noPassWord() {
        username.sendKeys("");// add username
        loginButton.click();
    }

    @Test
    public void noCredentials() {
        loginButton.click();
    }

    @Test
    public void Captcha() throws InterruptedException {
        username.sendKeys("automation47");//leave empty
        loginButton.click();
        loginButton.click();
        loginButton.click();
        WebElement cptcha = driver.findElement(By.xpath("//*[@id=\"captcha\"]/div/img"));
        System.out.println(cptcha.isDisplayed());
    }

    @AfterEach
    public void close() {
        driver.quit();
    }
}