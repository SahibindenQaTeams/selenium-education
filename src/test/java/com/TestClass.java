package com;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestClass {

  @Test
  public void createChromeDriver() {
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("headless");
    chromeOptions.addArguments("window-size=1000,500");
    chromeOptions.addArguments("pageLoadStrategy=eager");

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

    chromeOptions.merge(capabilities);

    ChromeDriver driver = new ChromeDriver(chromeOptions);
    driver.quit();
  }


  @Test
  public void createFirefoxDriver() {
    System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
    FirefoxDriver driver = new FirefoxDriver();
    driver.quit();
  }



  @Test
  public void testSelector() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");

    ChromeOptions chromeOptions = new ChromeOptions();
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    chromeOptions.merge(capabilities);

    ChromeDriver driver = new ChromeDriver(chromeOptions);



    //driver oluştuktan sonra sayfa boş olarak açılmaktadır get ile ilgili sayfayı açar.
    driver.get("https://www.sahibinden.com/");


    // Sayfa içersinde birden fazla locator 'e etki yapan bir locator tanımının findElement ile kaç tane bulursa bulsun ilk elementi getirir.
    // sahibinden.com Anasayfa vitrininde bulunan ilan listesininden örnek aşağıdaki gibidir.
    String ilanIsmi = driver.findElement(By.cssSelector(".vitrin-list li a span")).getText();
    System.out.println(ilanIsmi);


    //-------------------------------


    // Sayfa içersinde birden fazla locator 'e etki yapan bir locator tanımının findElements ile bulduğu locator lerin hepsini liste biçiminde geri verir.
    // sahibinden.com Anasayfa vitrininde bulunan ilan listesininden örnek aşağıdaki gibidir.
    List<WebElement> listeIlanIsmi = driver.findElements(By.cssSelector(".vitrin-list li a span"));

    //foreach ile gösterimi
    //ilgili locator den bulunan elementlerin içeriğinde bulunan metini almak için getText methodunu çağırdık.
    for (WebElement ismi : listeIlanIsmi) {
      System.out.println(ismi.getText());
    }

    //for ile gösterimi
    //ilgili locator den bulunan elementlerin içeriğinde bulunan metini almak için getText methodunu çağırdık.
    for (int i = 0; i < listeIlanIsmi.size(); i++) {
      System.out.println(listeIlanIsmi.get(i).getText());
    }

    //-------------------------------

    //css ile anaysayfada Giriş Yap elementinin locatorünün css ile ve id ile tıklama işlemi yapıyor.
    driver.findElement(By.cssSelector("#secure-login")).click();
    //driver.findElement(By.id("secure-login")).click();

    Thread.sleep(10*1000);


    driver.quit();
  }


}
