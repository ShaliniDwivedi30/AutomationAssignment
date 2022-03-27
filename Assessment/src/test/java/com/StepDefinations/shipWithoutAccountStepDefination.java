package com.StepDefinations;

import DataProvider.ConfigFileReader;
import com.POM_PageObjectModel.HomePage;
import com.POM_PageObjectModel.ShipWithoutAccountPage;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;

public class shipWithoutAccountStepDefination{

    ConfigFileReader configFileReader;

    public static WebDriver driver=BaseClass.driver;
    Logger log=Logger.getLogger(HomePageStepDefination.class.getName());
    HomePage oHomePage;
    ShipWithoutAccountPage oshipWithoutAccountPage;

    @When("user clicks on the Ship without account option from shipping services")
    public void userClicksOnTheShipWithoutAccountOptionFromShippingServices() throws InterruptedException {
        oHomePage=new HomePage();
        oHomePage.servicesList();
        oHomePage.shippingServicesList();

    }

    @Then("verify the {string} of ship without account")
    public void verifyTheOfShipWithoutAccount(String arg0) throws IOException, InterruptedException {
        Thread.sleep(8000);
        oHomePage=new HomePage();
        oshipWithoutAccountPage=new ShipWithoutAccountPage();
        String ship=driver.getCurrentUrl();
        System.out.println(ship);
        configFileReader=new ConfigFileReader();
        String str=configFileReader.ConfigReaderfile(arg0);
        Assert.assertEquals(configFileReader.ConfigReaderfile(arg0),ship);
        oshipWithoutAccountPage.enterYourName.sendKeys("hi@shalini");
    }

    @Then("verify {string} and {string} fields from the ShipManager lite page")
    public void verifyAndFieldsFromTheShipManagerLitePage(String arg0, String arg1) {
        oHomePage=new HomePage();
        oshipWithoutAccountPage=new ShipWithoutAccountPage();
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(oshipWithoutAccountPage.enterYourName));
        oshipWithoutAccountPage.enterYourName.sendKeys("hello");
        oshipWithoutAccountPage.enterYourName.clear();
        oshipWithoutAccountPage.enterYourName.sendKeys(arg0);
        oshipWithoutAccountPage.zipCode.sendKeys(arg1);

    }

    @Then("verify the {string}  field from the ShipManager lite page")
    public void verifyTheFieldFromTheShipManagerLitePage(String arg0) throws InterruptedException {
        oHomePage=new HomePage();
        oshipWithoutAccountPage=new ShipWithoutAccountPage();
        Thread.sleep(3000);
        oshipWithoutAccountPage.countryList("India");
    }


}
