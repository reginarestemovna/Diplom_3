package page.registration;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import page.BaseTest;
import pageobject.header.HeaderPageObject;
import pageobject.login.LoginPageObject;
import pageobject.main.MainPageObject;
import pageobject.register.RegisterPageObject;

@RunWith(Parameterized.class)
public class RegisterPageTest extends BaseTest {

  private final By privateOfficeButton;

  public RegisterPageTest(By privateOfficeButton) {
    this.privateOfficeButton = privateOfficeButton;
  }

  @Parameterized.Parameters(name = "button: {0}")
  public static Object[][] getLocatorsAndText() {
    return new Object[][] {
      {MainPageObject.SIGN_IN_BUTTON}, {HeaderPageObject.PRIVATE_OFFICE_BUTTON},
    };
  }

  @Test
  @DisplayName("Test user registration")
  public void registrationTest() {
    basePageObject.wait(privateOfficeButton);
    basePageObject.click(privateOfficeButton);
    basePageObject.wait(LoginPageObject.SIGN_UP_BUTTON);
    basePageObject.click(LoginPageObject.SIGN_UP_BUTTON);
    basePageObject.setTextValue(NAME, RegisterPageObject.NAME_INPUT);
    basePageObject.setTextValue(EMAIL, RegisterPageObject.EMAIL_INPUT);
    basePageObject.setTextValue(PASSWORD, RegisterPageObject.PASSWORD_INPUT);
    basePageObject.click(RegisterPageObject.SIGN_UP_BUTTON);
    login(basePageObject);
    loginTest(basePageObject);
  }

  @After
  public void cleanUp() {
    userClient.deleteTestData(EMAIL, PASSWORD);
  }
}
