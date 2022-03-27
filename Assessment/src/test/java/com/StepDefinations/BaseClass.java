package com.StepDefinations;

import DataProvider.ConfigFileReader;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import java.util.concurrent.TimeUnit;


public class BaseClass {
    ConfigFileReader configFileReader;
    public static WebDriver driver;
    static Logger log=Logger.getLogger(BaseClass.class.getName());
    public BaseClass()
    {
        PageFactory.initElements(driver, this);
    }
    @Before
    public void setup()
    {
        configFileReader= new ConfigFileReader();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get(configFileReader.getApplicationUrl());
        driver.manage().window().maximize();
        log.info("In login page");
    }


    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
