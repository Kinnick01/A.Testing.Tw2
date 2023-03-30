package com.codecool.atestingtw2;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.Key;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateIssueTest {
    static WebDriver driver;


    @BeforeEach
    public void setUp() {
        //driver setup
        System.setProperty("webdriver.chrome.driver", "url");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //page navigation
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp?os_destination=%2Fsecure%2FTests.jspa#/design?projectId=10101");

        // precondition login
        driver.findElement(By.name("os_username")).sendKeys("lol");

        driver.findElement(By.name("os_password")).sendKeys("lol");

        driver.findElement(By.name("login")).click();


    }

    @Test
    public void canCreateIssue() {
        driver.findElement(By.id("create_link")).click();
        WebElement dialog = driver.findElement(By.id("create-issue-dialog"));
        assertTrue(dialog.isDisplayed());
    }

    @Test
    public void createBug() {
        driver.findElement(By.id("create_link")).click();
        WebElement summary = driver.findElement(By.xpath("//*[@id=\"summary\"]"));
        summary.sendKeys("atest01");
        driver.findElement(By.name("Edit")).click();
        //WebElement dialog = driver.findElement(By.id("create-issue-dialog"));
        //assertFalse(dialog.isDisplayed());
    }

    @Test
    public void createTask() {
        driver.findElement(By.id("create_link")).click();
        WebElement dialog = driver.findElement(By.id("create-issue-dialog"));
        driver.findElement(By.id("issuetype-field")).sendKeys(Keys.CLEAR);
        driver.findElement(By.id("issuetype-field")).sendKeys("Task" + Keys.TAB);
        driver.findElement(By.id("summary")).sendKeys("atest01");
        driver.findElement(By.name("Edit")).click();
        //assertFalse(dialog.isDisplayed());
    }

    @Test
    public void createStory() {
        driver.findElement(By.id("create_link")).click();
        WebElement dialog = driver.findElement(By.id("create-issue-dialog"));
        driver.findElement(By.id("issuetype-field")).click();
        driver.findElement(By.id("issuetype-field")).sendKeys(Keys.CLEAR);
        driver.findElement(By.id("issuetype-field")).sendKeys("Story" + Keys.TAB);
        driver.findElement(By.id("summary")).sendKeys("atest01_story");
        driver.findElement(By.name("Edit")).click();
       // assertFalse(dialog.isDisplayed());
    }

    @AfterEach
    public void close() {
        driver.quit();
    }

}
