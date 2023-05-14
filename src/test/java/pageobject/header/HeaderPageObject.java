package pageobject.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.BasePageObject;

public class HeaderPageObject extends BasePageObject {

  public static final By LOGO =
      By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']");
  public static final By PRIVATE_OFFICE_BUTTON = By.xpath(".//a[@href='/account']");
  public static final By CONSTRUCTOR_BUTTON =
      By.xpath(".//a[(@href='/' and @class='AppHeader_header__link__3D_hX')]");

  public HeaderPageObject(WebDriver driver) {
    super(driver);
  }
}
