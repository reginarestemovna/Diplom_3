package page.header;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.BaseTest;
import pageobject.header.HeaderPageObject;
import pageobject.login.LoginPageObject;
import pageobject.main.MainPageObject;

@RunWith(Parameterized.class)
public class HeaderTest extends BaseTest {

  private static final String EXPECTED_TEXT = "Соберите бургер";

  private final By headerButton;

  public HeaderTest(By headerButton) {
    this.headerButton = headerButton;
  }

  @Parameterized.Parameters(name = "button: {0}")
  public static Object[][] getLocatorsAndText() {
    return new Object[][] {
      {HeaderPageObject.CONSTRUCTOR_BUTTON}, {HeaderPageObject.LOGO},
    };
  }

  @Test
  @DisplayName("Test user login with private office button")
  public void signInWithPrivateOfficeButtonTest() {
    basePageObject.wait(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    basePageObject.click(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    basePageObject.wait(LoginPageObject.SIGN_IN_BUTTON);
    basePageObject.click(headerButton);

    basePageObject.wait(MainPageObject.ORDER_TITLE);

    String currentUrl = webDriver.getCurrentUrl();
    assertEquals(URL, currentUrl);

    WebElement profilePageDescriptionElement = basePageObject.find(MainPageObject.ORDER_TITLE);

    assertTrue(profilePageDescriptionElement.isDisplayed());

    String profilePageDescription = profilePageDescriptionElement.getText();
    assertEquals(EXPECTED_TEXT, profilePageDescription);
  }
}
