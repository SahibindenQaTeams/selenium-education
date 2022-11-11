package pageobjectmodel.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassifiedDetailPage extends BasePage {

  public ClassifiedDetailPage(WebDriver webDriver) {
    super(webDriver);
  }

  @FindBy(css = ".classifiedDetailTitle h1")
  public WebElement classifiedTitle;

  public String getClassifiedTitle() {
    return classifiedTitle.getText();
  }
}
