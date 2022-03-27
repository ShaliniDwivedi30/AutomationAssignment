package com.StepDefinations;

import DataProvider.ConfigFileReader;
import com.POM_PageObjectModel.HomePage;
import commonUtilities.takeScreenShotUtility;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class HomePageStepDefination {
    ConfigFileReader configFileReader;
    public static WebDriver driver=BaseClass.driver;
    Logger log=Logger.getLogger(HomePageStepDefination.class.getName());
    HomePage oHomePage;
    BaseClass base;
    takeScreenShotUtility screenshot;

    @Given("user launch the fedex url")
    public void userLaunchTheFedexUrl()  {

        log.info("after launching the set up");
    }
    @Then("user will get location modal")
    public void userWillGetLocationModal() throws InterruptedException {
        oHomePage=new HomePage();

        try {
            log.info(oHomePage.chooseYourLocation.getText());
            oHomePage.countries();
            oHomePage.handlingCookies();
        }
         catch (Exception e)
         {
             log.info("Not getting modal");
             oHomePage.handlingCookies();
         }
        
    }

    @When("user clicks on english option from the location modal")
    public void userClicksOnEnglishOptionFromTheLocationModal() throws InterruptedException {
        oHomePage=new HomePage();
        screenshot=new takeScreenShotUtility();
        screenshot.captureScreenshot(driver,"homePagescreen");

    }

    @Then("verify the all services available on home page")
    public void verifyTheAllServicesAvailableOnHomePage() throws InterruptedException {
        oHomePage=new HomePage();
        Thread.sleep(3000);
        oHomePage.servicesList();

    }

    @Then("user will navigate to the fedex {string} home page")
    public void userWillNavigateToTheFedexHomePage(String arg0) throws IOException {
        configFileReader= new ConfigFileReader();
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(oHomePage.homePageTitle));
        String actualTitle=oHomePage.homePageTitle.getText();
        log.info(actualTitle);
        Assert.assertEquals(configFileReader.ConfigReaderfile(arg0),actualTitle);
    }


}
