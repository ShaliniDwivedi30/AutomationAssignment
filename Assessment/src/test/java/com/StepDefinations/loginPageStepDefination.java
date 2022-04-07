package com.StepDefinations;

import DataProvider.ConfigFileReader;
import com.POM_PageObjectModel.HomePage;
import com.POM_PageObjectModel.loginPage;
import commonUtilities.takeScreenShotUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        olopginpage.login();
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
        driver.navigate().back();
        configFileReader=new ConfigFileReader();
        configFileReader.waitmethod();
        olopginpage=new loginPage();
        WebDriverWait wait=new WebDriverWait(driver,30);
        olopginpage.loginPage_details(arg0,arg1);
        configFileReader.waitmethod();
        driver.navigate().refresh();
        configFileReader.waitmethod();
        screenshot=new takeScreenShotUtility();
        screenshot.captureScreenshot(driver,"passingthevalues");
    }

    @And("clicks on the Forgot your user name or password link")
    public void clicksOnTheForgotYourUserNameOrPasswordLink() throws InterruptedException {
        olopginpage=new loginPage();
        configFileReader= new ConfigFileReader();
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(olopginpage.forgotUserIDlink));
        configFileReader.waitmethod();
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
        configFileReader= new ConfigFileReader();
        configFileReader.waitmethod();
        oHomePage.servicesListfromloginpage();
        oHomePage.shippingServicesListfromloginpage();
        configFileReader.waitmethod();
        screenshot=new takeScreenShotUtility();
        screenshot.captureScreenshot(driver,"ShipServicefromlogin");

    }

    @And("clicks on the signIn CTA and verify the user navigate to the login page")
    public void clicksOnTheSignInCTAAndVerifyTheUserNavigateToTheLoginPage() throws IOException, InterruptedException {

        olopginpage=new loginPage();
        configFileReader=new ConfigFileReader();
        WebDriverWait wait=new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.elementToBeClickable(olopginpage.userLogin));
        olopginpage.userLogin.click();
        wait.until(ExpectedConditions.elementToBeClickable(olopginpage.LoginLink));
        olopginpage.LoginLink.click();
        // olopginpage.login();
        log.info("clicking on sign in link");
        wait.until(ExpectedConditions.visibilityOf(olopginpage.userLoginPage_title_text));
        String userLoginPagetitletext=olopginpage.userLoginPage_title_text.getText();
        Assert.assertEquals(configFileReader.ConfigReaderfile("loginPagetitle"),userLoginPagetitletext);
        screenshot=new takeScreenShotUtility();
        screenshot.captureScreenshot(driver,"loginpageassesrssion");
    }

    @When("user clicks on create a user id for an existing account")
    public void userClicksOnCreateAUserIdForAnExistingAccount(){
        olopginpage=new loginPage();
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(olopginpage.createUser));
        olopginpage.createUser.click();

    }

    @Then("user will navigate to the login registration page")
    public void userWillNavigateToTheLoginRegistrationPage() {
        olopginpage=new loginPage();
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(olopginpage.loginInformation));
        System.out.println(olopginpage.loginInformation.getText());
    }
    @And("fills the required details")
    public void fillsTheRequiredDetails() throws InterruptedException, IOException {
        olopginpage=new loginPage();
        configFileReader= new ConfigFileReader();
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(olopginpage.loginInformation));
        olopginpage.loginUsername.sendKeys(configFileReader.ConfigReaderfile("loginUsername"));
        olopginpage.loginPassword.sendKeys(configFileReader.ConfigReaderfile("loginPassword"));
        olopginpage.loginrePassword.sendKeys(configFileReader.ConfigReaderfile("loginrePassword"));
        olopginpage.selectSecretQuestion();
        olopginpage.contactFirstName.sendKeys(configFileReader.ConfigReaderfile("contactFirstName"));
        olopginpage.contactLastName.sendKeys(configFileReader.ConfigReaderfile("contactLastName"));
        olopginpage.contactCompany.sendKeys(configFileReader.ConfigReaderfile("contactCompany"));
        olopginpage.selectCountry();
        Thread.sleep(5000);
        driver.navigate().back();

    }
}
