package page.login;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page.BaseTest;
import pageobject.header.HeaderPageObject;
import pageobject.login.LoginPageObject;
import pageobject.main.MainPageObject;
import pageobject.passwordrecovery.PasswordRecoveryPageObject;
import pageobject.register.RegisterPageObject;
import user.create.UserCreateRequest;

public class LoginPageTest extends BaseTest {

  @Before
  public void setUp() {
    UserCreateRequest userCreateRequest = new UserCreateRequest(NAME, EMAIL, PASSWORD);
    userClient.create(userCreateRequest);
  }

  @Test
  @DisplayName("Test user login with private office button")
  public void signInWithPrivateOfficeButtonTest() {
    basePageObject.wait(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    basePageObject.click(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    login(basePageObject);
    loginTest(basePageObject);
  }

  @Test
  @DisplayName("Test user login with sign in button")
  public void signInWithSignInButtonTest() {
    basePageObject.wait(MainPageObject.SIGN_IN_BUTTON);
    basePageObject.click(MainPageObject.SIGN_IN_BUTTON);
    login(basePageObject);
    loginTest(basePageObject);
  }

  @Test
  @DisplayName("Test user login with register button")
  public void signInWithRegisterButtonTest() {
    basePageObject.wait(MainPageObject.SIGN_IN_BUTTON);
    basePageObject.click(MainPageObject.SIGN_IN_BUTTON);
    basePageObject.wait(LoginPageObject.SIGN_IN_BUTTON);
    basePageObject.click(LoginPageObject.SIGN_UP_BUTTON);
    basePageObject.wait(RegisterPageObject.SIGN_IN_BUTTON);
    basePageObject.click(RegisterPageObject.SIGN_IN_BUTTON);
    login(basePageObject);
    loginTest(basePageObject);
  }

  @Test
  @DisplayName("Test user login with password recovery button")
  public void signInWithPasswordRecoveryButtonTest() {
    basePageObject.wait(MainPageObject.SIGN_IN_BUTTON);
    basePageObject.click(MainPageObject.SIGN_IN_BUTTON);
    basePageObject.wait(LoginPageObject.PASSWORD_RECOVERY_BUTTON);
    basePageObject.click(LoginPageObject.PASSWORD_RECOVERY_BUTTON);
    basePageObject.wait(PasswordRecoveryPageObject.SIGN_IN_BUTTON);
    basePageObject.click(PasswordRecoveryPageObject.SIGN_IN_BUTTON);
    login(basePageObject);
    loginTest(basePageObject);
  }

  @After
  public void cleanUp() {
    userClient.deleteTestData(EMAIL, PASSWORD);
  }
}
