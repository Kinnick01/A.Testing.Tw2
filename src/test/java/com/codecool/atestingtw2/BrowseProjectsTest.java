package com.codecool.atestingtw2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class BrowseProjectsTest {

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
        driver.findElement(By.id("user-options")).click();
    }

    @Test
    public void genericBrowseProjects() {
        driver.get("https://jira-auto.codecool.metastage.net/projects/MTP/issues/");
        driver.findElement(By.xpath("//*[text()='Main Testing Project']")).click();
        WebElement mtp = driver.findElement(By.xpath("//*[text()='MTP']"));
        assertTrue(mtp.isDisplayed());
    }

    @Test
    public void viewAllProjects() {
        driver.get("https://jira-auto.codecool.metastage.net/secure/BrowseProjects.jspa?selectedCategory=all&selectedProjectType=all");
        WebElement toucan = driver.findElement(By.xpath("//*[text()='TOUCAN']"));
        WebElement coala = driver.findElement(By.xpath("//*[text()='COALA']"));
        WebElement jeti = driver.findElement(By.xpath("//*[text()='JETI']"));
        assertTrue(toucan.isDisplayed());
        assertTrue(coala.isDisplayed());
        assertTrue(jeti.isDisplayed());
    }

    @Test
    public void browseCoala() {
        driver.get("https://jira-auto.codecool.metastage.net/projects/COALA/summary");
        WebElement coala = driver.findElement(By.xpath("//*[text()='COALA']"));
        assertTrue(coala.isDisplayed());
    }

    @Test
    public void browseJeti() {
        driver.get("https://jira-auto.codecool.metastage.net/projects/JETI/summary");
        WebElement jeti = driver.findElement(By.xpath("//*[text()='JETI']"));
        assertTrue(jeti.isDisplayed());
    }

    @Test
    public void browseToucan() {
        driver.get("https://jira-auto.codecool.metastage.net/projects/TOUCAN/summary");
        WebElement toucan = driver.findElement(By.xpath("//*[text()='TOUCAN']"));
        assertTrue(toucan.isDisplayed());
    }

}
