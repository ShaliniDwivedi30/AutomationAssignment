package com.POM_PageObjectModel;

import DataProvider.ConfigFileReader;
import com.StepDefinations.BaseClass;
import com.StepDefinations.HomePageStepDefination;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class loginPage {

    public static WebDriver driver= BaseClass.driver;
    Logger log=Logger.getLogger(loginPage.class.getName());
    ConfigFileReader configFileReader;
    public loginPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='fxg-dropdown-signIn']")
    public WebElement signInLink;

    @FindBy(xpath = "//a[@id='fxg-dropdown-signIn']/span")
    public WebElement getSignInLink;
    @FindBy(xpath = "//div[contains(@class,'fxg-dropdown__sub-menu u')]")
    public WebElement signIndropdown;

    @FindBy(xpath = "//div[@class='link section']/div/a[@aria-label='LOG IN']")
    public WebElement logInLink;

    @FindBy(xpath = "//span[contains(text(),' CREATE A USER ID FOR AN EXISTING ')]")
    public WebElement loginPageTitle;

    @FindBy(xpath = "//a[@id='createUserId']/span")
    public WebElement userLoginPage_title_text;

    @FindBy(xpath = "//input[@id='userId']")
    public WebElement userLogin_inputfield;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement userPassword_inputfield;

    @FindBy(xpath = "//button[@id='login-btn']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@id='requestCode-btn']")
    public WebElement forgotUserIDlink;

    @FindBy(xpath = "//h1[@id='loginSolutionsTitle']")
    public WebElement forgotUserIDTitle;

    @FindBy(xpath = "//button[@id='reset-btn']")
    public WebElement forgotpasswordbutton;

    @FindBy(xpath = "//button[@id='back-btn']")
    public WebElement forgot_password_Back_button;

    @FindBy(xpath = "//button[@id='retrieve-btn']")
    public WebElement forgotuserIDbutton;

    public void ligin() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.elementToBeClickable(getSignInLink));
        getSignInLink.click();
        Thread.sleep(3000);
      //  signInLink.click();
        wait.until(ExpectedConditions.elementToBeClickable(logInLink));
        logInLink.click();
    }

    public void loginPage_details(String username, String password) throws IOException {
        configFileReader=new ConfigFileReader();
        String str=configFileReader.ConfigReaderfile(username);
        userLogin_inputfield.sendKeys(str);
        String str2=configFileReader.ConfigReaderfile(password);
        userPassword_inputfield.sendKeys(str2);
        loginButton.click();
    }

    public void setForgotUserIDlink()
    {   WebDriverWait wait=new WebDriverWait(driver,40);
        forgotUserIDlink.click();
        wait.until(ExpectedConditions.visibilityOf(forgotUserIDTitle));
        String forgotIDTitle=forgotUserIDTitle.getText();
        String forgotIDTitlefromDOM=driver.getTitle();
        log.info(forgotIDTitlefromDOM);

    }




}
