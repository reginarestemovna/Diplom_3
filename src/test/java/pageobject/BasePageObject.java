package pageobject;

import io.qameta.allure.Step;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

  private final WebDriver driver;

  public BasePageObject(WebDriver driver) {
    this.driver = driver;
  }

  @Step("Click to element")
  public void click(By by) {
    driver.findElement(by).click();
  }

  @Step("Find element")
  public WebElement find(By by) {
    return driver.findElement(by);
  }

  @Step("Wait element displayed")
  public void wait(By by) {
    new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS))
        .until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  @Step("Set text value to element")
  public void setTextValue(String value, By by) {
    driver.findElement(by).sendKeys(value);
  }
}
