//package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TestarPaginaSoma {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    String localChromeDriver = "F:\\chromedriver.exe";
    System.setProperty("webdriver.chrome.driver", localChromeDriver);
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test1() throws Exception {
    driver.get("http://localhost:8080/Somarparcelas/");
    driver.findElement(By.name("p1")).click();
    driver.findElement(By.name("p1")).clear();
    driver.findElement(By.name("p1")).sendKeys("10");
    driver.findElement(By.name("p2")).click();
    driver.findElement(By.name("p2")).clear();
    driver.findElement(By.name("p2")).sendKeys("20");
    driver.findElement(By.name("calcuar")).click();
    driver.findElement(By.xpath("//h1")).click();
    assertEquals("O resultado foi:30", driver.findElement(By.xpath("//h1")).getText());
  }

    @Test
  public void test2() throws Exception {
    driver.get("http://localhost:8080/Somarparcelas/");
    driver.findElement(By.name("p1")).click();
    driver.findElement(By.name("p1")).clear();
    driver.findElement(By.name("p1")).sendKeys("13");
    driver.findElement(By.name("p2")).click();
    driver.findElement(By.name("p2")).clear();
    driver.findElement(By.name("p2")).sendKeys("50");
    driver.findElement(By.name("calcuar")).click();
    driver.findElement(By.xpath("//h1")).click();
    assertEquals("O resultado foi:53", driver.findElement(By.xpath("//h1")).getText());
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
