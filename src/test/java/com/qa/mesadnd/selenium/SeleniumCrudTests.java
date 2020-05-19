package com.qa.mesadnd.selenium;


import com.qa.mesadnd.MesaDND;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumCrudTests {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    MesaDND mesaDND;

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

    @Test
    public void testACharacterAbilityCreateRead() throws InterruptedException, IOException{
        test = report.startTest("Open to Mesa Home Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://localhost:8181/html/maker.html");
        test.log(LogStatus.INFO, "Navigating to the Character Maker Page");
        assertEquals(driver.getTitle(), "Character Maker");
        sleep(2000);
        test.log(LogStatus.PASS, "The page name is exactly the same, Character Maker");

        WebElement name = driver.findElement(By.id("name"));
        test.log(LogStatus.PASS, "Name field found");
        name.sendKeys("Christian Redfern");
        sleep(500);

        WebElement strength = driver.findElement(By.id("strength"));
        test.log(LogStatus.PASS, "Strength field found");
        strength.sendKeys("6");
        sleep(500);

        WebElement dexterity = driver.findElement(By.id("dexterity"));
        test.log(LogStatus.PASS, "Dexterity field found");
        dexterity.sendKeys("7");
        sleep(500);

        WebElement constitution = driver.findElement(By.id("constitution"));
        test.log(LogStatus.PASS, "Constitution field found");
        constitution.sendKeys("8");
        sleep(500);

        WebElement intelligence = driver.findElement(By.id("intelligence"));
        test.log(LogStatus.PASS, "Intelligence field found");
        intelligence.sendKeys("9");
        sleep(500);

        WebElement wisdom = driver.findElement(By.id("wisdom"));
        test.log(LogStatus.PASS, "Wisdom field found");
        wisdom.sendKeys("10");
        sleep(500);

        WebElement charisma = driver.findElement(By.id("charisma"));
        test.log(LogStatus.PASS, "Charisma field found");
        charisma.sendKeys("11");
        sleep(500);

        WebElement postButton = driver.findElement(By.id("postButton"));
        postButton.click();
        test.log(LogStatus.PASS, "Character submit clicked");
        sleep(500);

        WebElement navSheet = driver.findElement(By.id("navSheet"));
        navSheet.click();
        assertEquals(driver.getTitle(), "Character Sheet");
        sleep(2000);

        WebElement characterName = driver.findElement(By.id("charactername"));
        assertEquals(characterName.getText(), "Christian Redfern");
        test.log(LogStatus.PASS, "Character name correct");

        WebElement characterStrength = driver.findElement(By.id("strength"));
        assertEquals(characterStrength.getText(), "6");
        test.log(LogStatus.PASS, "Character strength clicked");

        WebElement characterDexterity = driver.findElement(By.id("dexterity"));
        assertEquals(characterDexterity.getText(), "7");
        test.log(LogStatus.PASS, "Character dexterity clicked");

        WebElement characterConstitution = driver.findElement(By.id("constitution"));
        assertEquals(characterConstitution.getText(), "8");
        test.log(LogStatus.PASS, "Character constitution clicked");

        WebElement characterIntelligence = driver.findElement(By.id("intelligence"));
        assertEquals(characterIntelligence.getText(), "9");
        test.log(LogStatus.PASS, "Character intelligence clicked");

        WebElement characterWisdom = driver.findElement(By.id("wisdom"));
        assertEquals(characterWisdom.getText(), "10");
        test.log(LogStatus.PASS, "Character wisdom clicked");

        WebElement characterCharisma = driver.findElement(By.id("charisma"));
        assertEquals(characterCharisma.getText(), "11");
        test.log(LogStatus.PASS, "Character charisma clicked");
        sleep(1000);
    }

    @Test
    public void testBCharacterAbilityUpdate() throws InterruptedException {
        test = report.startTest("Open to Character Sheet Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://localhost:8181/html/character.html");
        test.log(LogStatus.INFO, "Navigating to the Character Sheet Page");
        assertEquals(driver.getTitle(), "Character Sheet");
        sleep(2000);
        test.log(LogStatus.PASS, "The page name is exactly the same");

        WebElement characterName = driver.findElement(By.id("charactername"));
        test.log(LogStatus.PASS, "Character name found");
        characterName.clear();
        characterName.sendKeys("Sinnis Dietritchson");

        WebElement characterStrength = driver.findElement(By.id("strength"));
        test.log(LogStatus.PASS, "Character strength found");
        characterStrength.clear();
        characterStrength.sendKeys("11");

        WebElement characterDexterity = driver.findElement(By.id("dexterity"));
        test.log(LogStatus.PASS, "Character dexterity found");
        characterDexterity.clear();
        characterDexterity.sendKeys("10");

        WebElement characterConstitution = driver.findElement(By.id("constitution"));
        test.log(LogStatus.PASS, "Character constitution found");
        characterConstitution.clear();
        characterConstitution.sendKeys("9");

        WebElement characterIntelligence = driver.findElement(By.id("intelligence"));
        test.log(LogStatus.PASS, "Character intelligence found");
        characterIntelligence.clear();
        characterIntelligence.sendKeys("8");

        WebElement characterWisdom = driver.findElement(By.id("wisdom"));
        test.log(LogStatus.PASS, "Character wisdom found");
        characterWisdom.clear();
        characterWisdom.sendKeys("7");

        WebElement characterCharisma = driver.findElement(By.id("charisma"));
        test.log(LogStatus.PASS, "Character charisma found");
        characterCharisma.clear();
        characterCharisma.sendKeys("6");

        WebElement updateCharacter = driver.findElement(By.id("updateCharacter"));
        updateCharacter.click();
        sleep(500);
        driver.navigate().refresh();
        sleep(500);
        int attempts = 0;
        while(attempts < 2) {
            try {
                assertEquals (characterName.getText (), "Sinnis Dietritchson");
                assertEquals (characterStrength.getText (), "11");
                assertEquals (characterDexterity.getText (), "10");
                assertEquals (characterConstitution.getText (), "9");
                assertEquals (characterIntelligence.getText (), "8");
                assertEquals (characterWisdom.getText (), "7");
                assertEquals (characterCharisma.getText (), "6");
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        sleep(2000);

    }

    @Test
    public void testCCharacterAbilityDelete() throws InterruptedException {
        test = report.startTest("Open to Character Sheet Page");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Started chrome browser and made it fullscreen");
        driver.get("http://localhost:8181/html/character.html");
        test.log(LogStatus.INFO, "Navigating to the Character Sheet Page");
        assertEquals(driver.getTitle(), "Character Sheet");
        sleep(2000);
        test.log(LogStatus.PASS, "The page name is exactly the same");

        WebElement characterName = driver.findElement(By.id("charactername"));
        String setName = characterName.getText();
        WebElement characterStrength = driver.findElement(By.id("strength"));
        String setStrength = characterStrength.getText();
        WebElement characterDexterity = driver.findElement(By.id("dexterity"));
        String setDexterity = characterDexterity.getText();
        WebElement characterConstitution = driver.findElement(By.id("constitution"));
        String setConstitution = characterConstitution.getText();
        WebElement characterIntelligence = driver.findElement(By.id("intelligence"));
        String setIntelligence = characterIntelligence.getText();
        WebElement characterWisdom = driver.findElement(By.id("wisdom"));
        String setWisdom = characterWisdom.getText();
        WebElement characterCharisma = driver.findElement(By.id("charisma"));
        String setCharisma = characterCharisma.getText();

        WebElement deleteCharacter = driver.findElement(By.id("deleteCharacter"));
        deleteCharacter.click();
        sleep(500);
        driver.navigate().refresh();

        sleep(500);

        int attempts = 0;
        while(attempts < 2) {
            try {
                assertNotEquals(characterName.getText(), setName);
                assertNotEquals(characterStrength.getText(), setStrength);
                assertNotEquals(characterDexterity.getText(), setDexterity);
                assertNotEquals(characterConstitution.getText(), setConstitution);
                assertNotEquals(characterIntelligence.getText(), setIntelligence);
                assertNotEquals(characterWisdom.getText(), setWisdom);
                assertNotEquals(characterCharisma.getText(), setCharisma);
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        sleep(2000);

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
