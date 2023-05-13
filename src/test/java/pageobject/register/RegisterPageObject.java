package pageobject.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.BasePageObject;

public class RegisterPageObject extends BasePageObject {

  public static final By SIGN_IN_BUTTON = By.xpath(".//a[@href='/login']");
  public static final By NAME_INPUT = By.xpath(".//label[text()='Имя']/parent::div/input");
  public static final By SIGN_UP_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
  public static final By EMAIL_INPUT = By.xpath(".//label[text()='Email']/parent::div/input");
  public static final By ERROR_PASSWORD_INPUT = By.xpath(".//p[text()='Некорректный пароль']");
  public static final By PASSWORD_INPUT = By.xpath(".//label[text()='Пароль']/parent::div/input");

  public RegisterPageObject(WebDriver driver) {
    super(driver);
  }
}
