package pageobject.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.BasePageObject;

public class LoginPageObject extends BasePageObject {

  public static final By SIGN_UP_BUTTON = By.xpath(".//a[@href='/register']");
  public static final By SIGN_IN_BUTTON = By.xpath(".//button[text()='Войти']");
  public static final By EMAIL_INPUT = By.xpath(".//label[text()='Email']/parent::div/input");
  public static final By PASSWORD_RECOVERY_BUTTON = By.xpath(".//a[@href='/forgot-password']");
  public static final By PASSWORD_INPUT = By.xpath(".//label[text()='Пароль']/parent::div/input");

  public LoginPageObject(WebDriver driver) {
    super(driver);
  }
}
