package page.registration;

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
import pageobject.register.RegisterPageObject;

@RunWith(Parameterized.class)
public class RegisterPageWithIncorrectPasswordTest extends BaseTest {

  private static final String EMAIL = "test@test.ru";
  private static final String INCORRECT_PASSWORD = "123";
  private static final String EXPECTED_PROFILE_PAGE_DESCRIPTION = "Некорректный пароль";

  private final By privateOfficeButton;

  public RegisterPageWithIncorrectPasswordTest(By privateOfficeButton) {
    this.privateOfficeButton = privateOfficeButton;
  }

  @Parameterized.Parameters(name = "button: {0}")
  public static Object[][] getLocatorsAndText() {
    return new Object[][] {
      {MainPageObject.SIGN_IN_BUTTON}, {HeaderPageObject.PRIVATE_OFFICE_BUTTON},
    };
  }

  @Test
  @DisplayName("Test user registration with incorrect password")
  public void signIn() {
    basePageObject.wait(privateOfficeButton);
    basePageObject.click(privateOfficeButton);
    basePageObject.wait(LoginPageObject.SIGN_UP_BUTTON);
    basePageObject.click(LoginPageObject.SIGN_UP_BUTTON);
    basePageObject.setTextValue(NAME, RegisterPageObject.NAME_INPUT);
    basePageObject.setTextValue(EMAIL, RegisterPageObject.EMAIL_INPUT);
    basePageObject.setTextValue(INCORRECT_PASSWORD, RegisterPageObject.PASSWORD_INPUT);
    basePageObject.click(RegisterPageObject.SIGN_UP_BUTTON);
    basePageObject.wait(RegisterPageObject.ERROR_PASSWORD_INPUT);

    WebElement profilePageDescriptionElement =
        basePageObject.find(RegisterPageObject.ERROR_PASSWORD_INPUT);

    assertTrue(profilePageDescriptionElement.isDisplayed());

    String profilePageDescription = profilePageDescriptionElement.getText();
    assertEquals(EXPECTED_PROFILE_PAGE_DESCRIPTION, profilePageDescription);
  }
}
