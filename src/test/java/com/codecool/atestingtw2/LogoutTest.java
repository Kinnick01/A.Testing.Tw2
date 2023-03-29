package com.codecool.atestingtw2;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LogoutTest {

    static WebDriver driver;
    WebElement username;
    WebElement passWord;
    WebElement loginButton;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "url");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp?os_destination=%2Fsecure%2FTests.jspa#/design?projectId=10101");
        username = driver.findElement(By.name("os_username"));
        passWord = driver.findElement(By.name("os_password"));
        loginButton = driver.findElement(By.name("login"));

        //login precondition
        username.sendKeys("lol");//add username
        passWord.sendKeys("lol");//add Password
        loginButton.click();
        driver.findElement(By.id("user-options")).click();
    }

    @Test
    public void checkIfLogoutWorks() {
        driver.get("https://jira-auto.codecool.metastage.net/projects/MTP/issues/");
        driver.findElement(By.id("header-details-user-fullname")).click();
        driver.findElement(By.id("log_out")).click();
        WebElement logoutText = driver.findElement(By.xpath("//*[text()='Log in again.']"));
        assertTrue(logoutText.isDisplayed());
    }
}
