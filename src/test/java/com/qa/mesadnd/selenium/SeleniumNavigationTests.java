package com.qa.mesadnd.selenium;


import com.qa.mesadnd.MesaDND;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class SeleniumNavigationTests {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;

    @BeforeTest
    public void startReport(){
        report = new ExtentReports(
                System.getProperty("user.dir") + "/test-output/Report.html",
                true
        );
        report
                .addSystemInfo("Host Name", "QA")
                .addSystemInfo("Tester", "Christian");
        report.loadConfig(new File (System.getProperty("user.dir") + "\\extent-report.xml"));
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver ();
    }

    @Test(enabled = false, description = "Disabled until 'server.port in use' issue is resolved")
    public void testMesaHomeTitle() throws InterruptedException {
        test = report.startTest("Open to Mesa Home Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://localhost:8181/");
        test.log(LogStatus.INFO, "Navigating to the MesaDND homepage");
        assertEquals(driver.getTitle(), "Mesa Home Page");
        sleep(2000);
        test.log(LogStatus.PASS, "The page name is exactly the same");
    }

    @Test(enabled = false, description = "Disabled until 'server.port in use' issue is resolved")
    public void testCharacterSheetTitle() throws InterruptedException {
        test = report.startTest("Open to Character Sheet Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://localhost:8181/html/character.html");
        test.log(LogStatus.INFO, "Navigating to the Character Sheet Page");
        assertEquals(driver.getTitle(), "Character Sheet");
        sleep(2000);
        test.log(LogStatus.PASS, "The page name is exactly the same");
    }

    @Test(enabled = false, description = "Disabled until 'server.port in use' issue is resolved")
    public void testCharacterMakerTitle() throws InterruptedException {
        test = report.startTest("Open to Character Maker Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://localhost:8181/html/maker.html");
        test.log(LogStatus.INFO, "Navigating to the Character Maker Page");
        assertEquals(driver.getTitle(), "Character Maker");
        sleep(2000);
        test.log(LogStatus.PASS, "The page name is exactly the same");
    }

    @Test(enabled = false, description = "Disabled until 'server.port in use' issue is resolved")
    public void testHomeSheetMaker() throws InterruptedException {
        test = report.startTest("Open to Mesa Home Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://localhost:8181/");
        test.log(LogStatus.INFO, "Navigating to the MesaDND homepage");
        sleep(2000);
        WebElement navSheet = driver.findElement(By.id("navSheet"));
        navSheet.click();
        assertEquals(driver.getTitle(), "Character Sheet");
        sleep(2000);
        test.log(LogStatus.PASS, "The page name is exactly the same, Character Sheet");
        WebElement navMaker = driver.findElement(By.id("navMaker"));
        navMaker.click();
        assertEquals(driver.getTitle(), "Character Maker");
        sleep(2000);
        test.log(LogStatus.PASS, "The page name is exactly the same, Character Maker");
        WebElement navHome = driver.findElement(By.id("navHome"));
        navHome.click();
        assertEquals(driver.getTitle(), "Mesa Home Page");
        sleep(2000);
        test.log(LogStatus.PASS, "Definitely the Mesa Home Page. " +
                " pages can navigated using the buttons in this order.");
    }

    @Test
    public void testMakerSheetHome() throws InterruptedException {
        test = report.startTest("Open to Mesa Home Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://localhost:8181/");
        test.log(LogStatus.INFO, "Navigating to the MesaDND homepage");
        sleep(2000);
        WebElement navMaker = driver.findElement(By.id("navMaker"));
        navMaker.click();
        assertEquals(driver.getTitle(), "Character Maker");
        sleep(2000);
        test.log(LogStatus.PASS, "The page name is exactly the same, Character Maker");
        WebElement navSheet = driver.findElement(By.id("navSheet"));
        navSheet.click();
        assertEquals(driver.getTitle(), "Character Sheet");
        sleep(2000);
        test.log(LogStatus.PASS, "The page name is exactly the same, Character Sheet");
        WebElement navHome = driver.findElement(By.id("navHome"));
        navHome.click();
        assertEquals(driver.getTitle(), "Mesa Home Page");
        sleep(2000);
        test.log(LogStatus.PASS, "Definitely the Mesa Home Page. " +
                " pages can navigated using the buttons in this order.");
    }

    @AfterMethod
    public void getResult(ITestResult result){
        driver.close();
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(LogStatus.FAIL, "Test has failed " + result.getName());
            test.log(LogStatus.FAIL, "Test has failed " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(LogStatus.PASS, "Test has passed " + result.getName());
        }
        report.endTest(test);
    }

    @AfterTest
    public void endReport(){
        report.flush();
        report.close();
    }
}
