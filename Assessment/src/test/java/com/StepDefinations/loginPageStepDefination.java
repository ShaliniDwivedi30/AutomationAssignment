package com.StepDefinations;

import DataProvider.ConfigFileReader;
import com.POM_PageObjectModel.HomePage;
import com.POM_PageObjectModel.loginPage;
import commonUtilities.takeScreenShotUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;

public class loginPageStepDefination {

    ConfigFileReader configFileReader;
    loginPage olopginpage;
    public static WebDriver driver=BaseClass.driver;
    Logger log=Logger.getLogger(loginPageStepDefination.class.getName());
    HomePage oHomePage;
    BaseClass base;
    takeScreenShotUtility screenshot;

    @Then("verify the user navigate to the login page")
    public void verifyTheUserNavigateToTheLoginPage() throws IOException, InterruptedException {
        olopginpage=new loginPage();
        configFileReader=new ConfigFileReader();
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(olopginpage.signInLink));
        olopginpage.ligin();
        log.info("clicking on sign in link");
        wait.until(ExpectedConditions.visibilityOf(olopginpage.userLoginPage_title_text));
        String userLoginPagetitletext=olopginpage.userLoginPage_title_text.getText();
        Assert.assertEquals(configFileReader.ConfigReaderfile("loginPagetitle"),userLoginPagetitletext);
        screenshot=new takeScreenShotUtility();
        screenshot.captureScreenshot(driver,"loginpageassesrssion");
    }

    @And("verify the login page details")
    public void verifyTheLoginPageDetails() throws IOException, InterruptedException {
        olopginpage=new loginPage();
        configFileReader=new ConfigFileReader();
        //olopginpage.ligin();
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(olopginpage.loginPageTitle));
        String loginPagetitle=olopginpage.loginPageTitle.getText();
        Assert.assertEquals(configFileReader.ConfigReaderfile("loginPagetitle"),loginPagetitle);
        screenshot=new takeScreenShotUtility();
        screenshot.captureScreenshot(driver,"LoginPage");

    }

    @And("click on back button from the ship manager page")
    public void clickOnBackButtonFromTheShipManagerPage() {

        driver.navigate().back();
        driver.navigate().back();
        log.info("after clicking on backward cta");
    }

    @And("Enter the {string} and {string} and clicks on login button")
    public void enterTheAndAndClicksOnLoginButton(String arg0, String arg1) throws InterruptedException, IOException {

        olopginpage=new loginPage();
        configFileReader=new ConfigFileReader();
        WebDriverWait wait=new WebDriverWait(driver,30);
        olopginpage.loginPage_details(arg0,arg1);
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(4000);
        screenshot=new takeScreenShotUtility();
        screenshot.captureScreenshot(driver,"passingthevalues");
    }

    @And("clicks on the Forgot your user name or password link")
    public void clicksOnTheForgotYourUserNameOrPasswordLink() throws InterruptedException {
        olopginpage=new loginPage();
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(olopginpage.forgotUserIDlink));
        Thread.sleep(3000);
        olopginpage.setForgotUserIDlink();

    }

    @Then("user clicks on the reset password CTA and navigate to other page")
    public void userClicksOnTheResetPasswordCTAAndNavigateToOtherPage() {
        olopginpage=new loginPage();
        WebDriverWait wait=new WebDriverWait(driver,20);
        olopginpage.forgotpasswordbutton.click();
        wait.until(ExpectedConditions.visibilityOf(olopginpage.forgot_password_Back_button));
        screenshot=new takeScreenShotUtility();
        screenshot.captureScreenshot(driver,"forgotpasswordpage");
        olopginpage.forgot_password_Back_button.click();

    }

    @And("clicks on the Retrive user ID CTA")
    public void clicksOnTheRetriveUserIDCTA() {
        olopginpage=new loginPage();
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(olopginpage.forgotuserIDbutton));
        olopginpage.forgotuserIDbutton.click();

    }

    @Then("click on the Shipping option from the login page")
    public void clickOnTheShippingOptionFromTheLoginPage() throws InterruptedException {
        oHomePage=new HomePage();
        Thread.sleep(5000);
        oHomePage.servicesListfromloginpage();
        oHomePage.shippingServicesListfromloginpage();
        Thread.sleep(5000);
        screenshot=new takeScreenShotUtility();
        screenshot.captureScreenshot(driver,"ShipServicefromlogin");

    }
}
