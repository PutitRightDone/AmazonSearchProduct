package org.putitrightdone.TestCases;

import com.google.gson.Gson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.putitrightdone.POM.HomePage;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.putitrightdone.Data.JSONParcingData;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;

public class TestCaseSearchProduct {
    private WebDriver driver;
    private HomePage loginToAmazon;
    final String path = "src/test/java/org/putitrightdone/Data/TestData.json";
    final Path filePath = Path.of(path);

    @BeforeSuite
    public void setUp() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()));
        JSONParcingData loginTestData = new Gson().fromJson(br, JSONParcingData.class);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions
                .addArguments("--profile-directory=Default").addArguments("--remote-allow-origins=*");
        //.addArguments("headless");
        // chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(chromeOptions);
        //HomePage homePage = new HomePage(driver, JSONParcingData.loginUrl);
    }

    // Pre-requisit step : Order is placed with order
    @Test(priority = 0)
    public void TestCase_PlacingNewOrder_Amazon() throws FileNotFoundException, InterruptedException {
        BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()));
        JSONParcingData loginTestData = new Gson().fromJson(br, JSONParcingData.class);
        HomePage homePage = new HomePage(driver, loginTestData.loginUrl);
        homePage.login(loginTestData.username, loginTestData.password);
        Reporter.log("================= Placing order For  ============ <br>", true);
        Reporter.log("Test case : Placing order for Product - Table Fan<br>", true);
        //driver.get(loginTestData.loginUrl);

    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
