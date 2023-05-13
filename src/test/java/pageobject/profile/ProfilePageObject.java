package pageobject.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.BasePageObject;

public class ProfilePageObject extends BasePageObject {

  public static final By EXIT_BUTTON = By.xpath(".//button[text()='Выход']");
  public static final By PROFILE_PAGE_DESCRIPTION =
      By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");

  public ProfilePageObject(WebDriver driver) {
    super(driver);
  }
}
