package pageobjectmodel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobjectmodel.page.CategoryAutomobilePage;
import pageobjectmodel.page.ClassifiedDetailPage;
import pageobjectmodel.page.HomePage;
import pageobjectmodel.page.SearchResultPage;

public class POMTestClass1 extends BaseClass {

  HomePage homePage;
  CategoryAutomobilePage categoryAutomobilePage;
  SearchResultPage searchResultPage;
  ClassifiedDetailPage classifiedDetailPage;

  @BeforeEach
  public void before() {
    homePage = new HomePage(driver);
    categoryAutomobilePage = new CategoryAutomobilePage(driver);
    searchResultPage = new SearchResultPage(driver);
    classifiedDetailPage = new ClassifiedDetailPage(driver);
  }

  @Test
  public void test1() {
    homePage.clickOtomobil();
    categoryAutomobilePage.clickAllClassifiedLink();

    Assertions.assertTrue(searchResultPage.getClassifiedSize() > 0);

    String title = searchResultPage.getFirstClassifiedTitle();
    String KM = searchResultPage.getFirstClassifiedKM();
    String price = searchResultPage.getFirstClassifiedPrice();

    System.out.println(title);
    System.out.println(KM);
    System.out.println(price);

    searchResultPage.clickFirstClassified();

    String classifiedTitle = classifiedDetailPage.getClassifiedTitle();

    Assertions.assertEquals(title, classifiedTitle);
  }
}
