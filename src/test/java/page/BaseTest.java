package page;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import api.UserClient;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.BasePageObject;
import pageobject.login.LoginPageObject;
import pageobject.main.MainPageObject;

public class BaseTest {

  protected static final String URL = "https://stellarburgers.nomoreparties.site/";
  protected static final String EMAIL = UUID.randomUUID() + "@test.ru";
  protected static final String NAME = UUID.randomUUID().toString();
  protected static final String PASSWORD = UUID.randomUUID().toString();

  private static final String EXPECTED_PROFILE_PAGE_DESCRIPTION = "Оформить заказ";

  protected UserClient userClient;
  protected WebDriver webDriver;
  protected BasePageObject basePageObject;

  @Before
  public void setUpParent() {
    WebDriverManager.chromedriver().setup();
    RestAssured.baseURI = URL;

    userClient = new UserClient();
    webDriver = buildDriver();
    basePageObject = new BasePageObject(webDriver);
  }

  protected WebDriver buildDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    WebDriver driver = new ChromeDriver(options);
    driver.get(URL);
    return driver;
  }

  protected void login(BasePageObject basePageObject) {
    basePageObject.wait(LoginPageObject.SIGN_IN_BUTTON);
    basePageObject.setTextValue(EMAIL, LoginPageObject.EMAIL_INPUT);
    basePageObject.setTextValue(PASSWORD, LoginPageObject.PASSWORD_INPUT);
    basePageObject.click(LoginPageObject.SIGN_IN_BUTTON);
    basePageObject.wait(MainPageObject.ORDER_BUTTON);
  }

  protected void loginTest(BasePageObject basePageObject) {
    String currentUrl = webDriver.getCurrentUrl();
    assertEquals(URL, currentUrl);

    WebElement orderButton = basePageObject.find(MainPageObject.ORDER_BUTTON);

    assertTrue(orderButton.isDisplayed());

    String profilePageDescription = orderButton.getText();
    assertEquals(EXPECTED_PROFILE_PAGE_DESCRIPTION, profilePageDescription);
  }

  @After
  public void cleanup() {
    webDriver.quit();
  }
}
