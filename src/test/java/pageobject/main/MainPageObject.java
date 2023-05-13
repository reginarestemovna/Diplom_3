package pageobject.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.BasePageObject;

public class MainPageObject extends BasePageObject {

  public static final By ROLLS_TITLE = By.xpath(".//h2[text()='Булки']");
  public static final By SAUCES_TITLE = By.xpath(".//h2[text()='Соусы']");
  public static final By FILLINGS_TITLE = By.xpath(".//h2[text()='Начинки']");
  public static final By ROLLS_BUTTON = By.xpath(".//span[text()='Булки']");
  public static final By SAUCES_BUTTON = By.xpath(".//span[text()='Соусы']");
  public static final By FILLINGS_BUTTON = By.xpath(".//span[text()='Начинки']");
  public static final By ORDER_TITLE = By.xpath(".//h1[text()='Соберите бургер']");
  public static final By ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");
  public static final By SIGN_IN_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
  public static final By ROLLS_BUTTON_PARENT = By.xpath(".//span[text()='Булки']/parent::div");
  public static final By SAUCES_BUTTON_PARENT = By.xpath(".//span[text()='Соусы']/parent::div");
  public static final By FILLINGS_BUTTON_PARENT = By.xpath(".//span[text()='Начинки']/parent::div");

  public MainPageObject(WebDriver driver) {
    super(driver);
  }
}
