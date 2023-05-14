package pageobject.passwordrecovery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.BasePageObject;

public class PasswordRecoveryPageObject extends BasePageObject {

  public static final By SIGN_IN_BUTTON = By.xpath(".//a[@href='/login']");

  public PasswordRecoveryPageObject(WebDriver driver) {
    super(driver);
  }
}
