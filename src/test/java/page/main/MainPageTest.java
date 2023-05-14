package page.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.BaseTest;
import pageobject.main.MainPageObject;

public class MainPageTest extends BaseTest {

  private static final String EXPECTED_CLASS = "tab_tab_type_current__2BEPc";
  private static final String ROLLS_TITLE_EXPECTED_TEXT = "Булки";
  private static final String SAUCES_TITLE_EXPECTED_TEXT = "Соусы";
  private static final String FILLINGS_TITLE_EXPECTED_TEXT = "Начинки";

  @Test
  @DisplayName("Test click rolls button")
  public void clickRollsButtonTest() {
    basePageObject.wait(MainPageObject.FILLINGS_BUTTON);
    basePageObject.click(MainPageObject.FILLINGS_BUTTON);
    testClick(
        MainPageObject.ROLLS_BUTTON,
        MainPageObject.ROLLS_TITLE,
        MainPageObject.ROLLS_BUTTON_PARENT,
        ROLLS_TITLE_EXPECTED_TEXT);
  }

  @Test
  @DisplayName("Test click sauces button")
  public void clickSaucesButtonTest() {
    testClick(
        MainPageObject.SAUCES_BUTTON,
        MainPageObject.SAUCES_TITLE,
        MainPageObject.SAUCES_BUTTON_PARENT,
        SAUCES_TITLE_EXPECTED_TEXT);
  }

  @Test
  @DisplayName("Test click fillings button")
  public void clickFillingsButtonTest() {
    testClick(
        MainPageObject.FILLINGS_BUTTON,
        MainPageObject.FILLINGS_TITLE,
        MainPageObject.FILLINGS_BUTTON_PARENT,
        FILLINGS_TITLE_EXPECTED_TEXT);
  }

  private void testClick(By button, By title, By parent, String expectedText) {
    basePageObject.wait(button);
    basePageObject.click(button);
    basePageObject.wait(title);

    WebElement rollsButtonParent = basePageObject.find(parent);
    assertTrue(rollsButtonParent.getAttribute("class").contains(EXPECTED_CLASS));

    WebElement rollsTitle = basePageObject.find(title);
    assertTrue(rollsTitle.isDisplayed());
    assertEquals(expectedText, rollsTitle.getText());
  }
}
