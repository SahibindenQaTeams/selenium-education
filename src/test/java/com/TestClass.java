package com;

import org.junit.jupiter.api.Test;
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
  }

}
