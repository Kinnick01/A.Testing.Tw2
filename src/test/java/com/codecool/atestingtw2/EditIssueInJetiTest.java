package com.codecool.atestingtw2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditIssueInJetiTest {
        static WebDriver driver;
        WebElement toucan;
        WebElement coala;
        WebElement jeti;

        @BeforeEach
        public void setUp() {

            //driver setup
            System.setProperty("webdriver.chrome.driver", "/Users/krausadam/Desktop/codecool/Advanced/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //page navigation
            driver.get("https://jira-auto.codecool.metastage.net/login.jsp?os_destination=%2Fsecure%2FTests.jspa#/design?projectId=10101");

            // precondition login
            driver.findElement(By.name("os_username")).sendKeys("automation47");

            driver.findElement(By.name("os_password")).sendKeys("CCAutoTest19.");

            driver.findElement(By.name("login")).click();

            //settign up variables
            //toucan = driver.findElement(By.xpath("//*[text()='TOUCAN']"));


        }


        @Test
        public void editIssueJETI1(){
            driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-1");
            driver.findElement(By.id("edit-issue")).click();
            // driver.findElement(By.id("description")).click();

            // driver.findElement(By.id("description"));

            driver.findElement(By.id("description")).sendKeys("               edit was good");
            driver.findElement(By.id("edit-issue-submit")).click();
        }

        @Test
        public void editIssueJETI2()  throws InterruptedException  {
            driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-2");
            driver.findElement(By.id("edit-issue")).click();

            assertTrue(driver.findElement(By.id("edit-issue-dialog")).isDisplayed());
        }

        @Test
        public void editIssueJETI3() {
            driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-3");
            driver.findElement(By.id("edit-issue")).click();
            assertTrue(driver.findElement(By.id("edit-issue-dialog")).isDisplayed());
        }

        @AfterEach
        public void closeup(){
            driver.close();
        }
    }




