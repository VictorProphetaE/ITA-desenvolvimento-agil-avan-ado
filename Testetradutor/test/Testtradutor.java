package Testetradutor;

import org.junit.Test;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Testtradutor {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    String localChromeDriver = "F:\\chromedriver.exe";
    System.setProperty("webdriver.chrome.driver", localChromeDriver);
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTradutor() throws Exception {
    driver.get("http://localhost:8080/PratiTradutor/");
    driver.findElement(By.name("palavra")).click();
    driver.findElement(By.name("palavra")).clear();
    driver.findElement(By.name("palavra")).sendKeys("sobre");
    driver.findElement(By.name("traduzir")).click();
    driver.findElement(By.xpath("//html")).click();
    assertEquals("sobre", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='A palavra traduzida sobre do portugues para o inglês'])[1]/following::h1[1]")).getText());
  }

    @Test
  public void testTradutor1() throws Exception {
    driver.get("http://localhost:8080/PratiTradutor/");
    driver.findElement(By.name("palavra")).click();
    driver.findElement(By.name("palavra")).clear();
    driver.findElement(By.name("palavra")).sendKeys("about");
    driver.findElement(By.name("traduzir")).click();
    driver.findElement(By.xpath("//html")).click();
    assertEquals("about", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='A palavra traduzida sobre do portugues para o inglês'])[1]/following::h1[1]")).getText());
  }
  
    @Test
  public void testTradutor2() throws Exception {
    driver.get("http://localhost:8080/PratiTradutor/");
    driver.findElement(By.name("palavra")).click();
    driver.findElement(By.name("palavra")).clear();
    driver.findElement(By.name("palavra")).sendKeys("sobre");
    driver.findElement(By.name("traduzir")).click();
    driver.findElement(By.xpath("//html")).click();
    assertEquals("about", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='A palavra traduzida sobre do portugues para o inglês'])[1]/following::h1[1]")).getText());
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
