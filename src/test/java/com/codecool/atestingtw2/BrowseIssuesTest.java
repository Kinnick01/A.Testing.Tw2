package com.codecool.atestingtw2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowseIssuesTest {
    static WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "url");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp?os_destination=%2Fsecure%2FTests.jspa#/design?projectId=10101");

        //login precondition

        driver.findElement(By.name("os_username")).sendKeys("lol");//add username
        driver.findElement(By.name("os_password")).sendKeys("lol");//add Password
        driver.findElement(By.name("login")).click();

    }

    /*
    @Test
    public void genericBrowseIssues() {
        driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/div[1]/ul/li[3]/a")).click();
        driver.findElement(By.id("issues_new_search_link_lnk")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/main/div/div[1]/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/ul/li[1]/div/div/span")).click();
        driver.findElement(By.id("10101-1")).click();
        driver.findElement(By.id("searcher-query")).click();
        driver.findElement(By.id("searcher-query")).sendKeys("Jaj");
        driver.findElement(By.id("searcher-query")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/main/div/div[2]/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/ol/li/a/div")).click();
        assertTrue(driver.findElement(By.name("Edit")).isDisplayed());
    }
     */

    @Test
    public void mtpBrowseIssue() {
        driver.get("https://jira-auto.codecool.metastage.net/browse/MTP-3503");
        assertTrue(driver.findElement(By.xpath("//*[text()='Jaj']")).isDisplayed());
        assertTrue(driver.findElement(By.id("edit-issue")).isDisplayed());
    }

    @Test
    public void browseToucan1Issue() {
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-1");
        assertTrue(driver.findElement(By.xpath("//*[text()='This is a task']")).isDisplayed());
        assertTrue(driver.findElement(By.id("edit-issue")).isDisplayed());
    }

    @Test
    public void browseToucan2Issue() {
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-2");
        assertTrue(driver.findElement(By.xpath("//*[text()='This is a bug']")).isDisplayed());
        assertTrue(driver.findElement(By.id("edit-issue")).isDisplayed());
    }

    @Test
    public void browseToucan3Issue() {
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-3");
        assertTrue(driver.findElement(By.xpath("//*[text()='This is a Story']")).isDisplayed());
        assertTrue(driver.findElement(By.id("edit-issue")).isDisplayed());
    }

    @Test
    public void browseJeti1Issue() {
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-1");
        assertTrue(driver.findElement(By.xpath("//*[text()='Jeti Story']")).isDisplayed());
        assertTrue(driver.findElement(By.id("edit-issue")).isDisplayed());
    }

    @Test
    public void browseJeti2Issue() {
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-2");
        assertTrue(driver.findElement(By.xpath("//*[text()='Jeti Bug']")).isDisplayed());
        assertTrue(driver.findElement(By.id("edit-issue")).isDisplayed());
    }

    @Test
    public void browseJeti3Issue() {
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-3");
        assertTrue(driver.findElement(By.xpath("//*[text()='Jeti Task']")).isDisplayed());
        assertTrue(driver.findElement(By.id("edit-issue")).isDisplayed());
    }

    @Test
    public void browseCoala1Issue() {
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-1");
        assertTrue(driver.findElement(By.xpath("//*[text()='Coala Bug']")).isDisplayed());
        assertTrue(driver.findElement(By.id("edit-issue")).isDisplayed());
    }

    @Test
    public void browseCoala2Issue() {
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-2");
        assertTrue(driver.findElement(By.xpath("//*[text()='Coala Story']")).isDisplayed());
        assertTrue(driver.findElement(By.id("edit-issue")).isDisplayed());
    }

    @Test
    public void browseCoala3Issue() {
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-3");
        assertTrue(driver.findElement(By.xpath("//*[text()='Coala Task']")).isDisplayed());
        assertTrue(driver.findElement(By.id("edit-issue")).isDisplayed());
    }

    @AfterEach
    public void close() {
        driver.quit();
    }

}
