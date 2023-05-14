package page.privateoffice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import page.BaseTest;
import pageobject.header.HeaderPageObject;
import pageobject.login.LoginPageObject;
import pageobject.profile.ProfilePageObject;
import user.create.UserCreateRequest;

public class PrivateOfficePageTest extends BaseTest {

  private static final String EXPECTED_PROFILE_PAGE_DESCRIPTION =
      "В этом разделе вы можете изменить свои персональные данные";

  private static final String EXPECTED_BUTTON_TEXT = "Войти";

  private static final String EXPECTED_CLICK_URL =
      "https://stellarburgers.nomoreparties.site/account/profile";

  private static final String EXPECTED_EXIT_URL = "https://stellarburgers.nomoreparties.site/login";

  @Before
  public void setUp() {
    UserCreateRequest userCreateRequest = new UserCreateRequest(NAME, EMAIL, PASSWORD);
    userClient.create(userCreateRequest);
  }

  @Test
  @DisplayName("Test private office button click")
  public void privateOfficeButtonClickTest() {
    basePageObject.wait(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    basePageObject.click(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    login(basePageObject);

    basePageObject.wait(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    basePageObject.click(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    basePageObject.wait(ProfilePageObject.PROFILE_PAGE_DESCRIPTION);

    String currentUrl = webDriver.getCurrentUrl();
    assertEquals(EXPECTED_CLICK_URL, currentUrl);

    WebElement profilePageDescriptionElement =
        basePageObject.find(ProfilePageObject.PROFILE_PAGE_DESCRIPTION);

    assertTrue(profilePageDescriptionElement.isDisplayed());

    String profilePageDescription = profilePageDescriptionElement.getText();
    assertEquals(EXPECTED_PROFILE_PAGE_DESCRIPTION, profilePageDescription);
  }

  @Test
  @DisplayName("Test exit button click")
  public void exitButtonClickTest() {
    basePageObject.wait(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    basePageObject.click(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    login(basePageObject);

    basePageObject.wait(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    basePageObject.click(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    basePageObject.wait(ProfilePageObject.EXIT_BUTTON);
    basePageObject.click(ProfilePageObject.EXIT_BUTTON);
    basePageObject.wait(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    basePageObject.click(HeaderPageObject.PRIVATE_OFFICE_BUTTON);
    basePageObject.wait(LoginPageObject.SIGN_IN_BUTTON);

    String currentUrl = webDriver.getCurrentUrl();
    assertEquals(EXPECTED_EXIT_URL, currentUrl);

    WebElement signInButton = basePageObject.find(LoginPageObject.SIGN_IN_BUTTON);

    assertTrue(signInButton.isDisplayed());

    String profilePageDescription = signInButton.getText();
    assertEquals(EXPECTED_BUTTON_TEXT, profilePageDescription);
  }

  @After
  public void cleanUp() {
    userClient.deleteTestData(EMAIL, PASSWORD);
  }
}
