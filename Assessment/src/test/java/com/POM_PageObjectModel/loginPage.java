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
import org.openqa.selenium.support.ui.Select;
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

    @FindBy(xpath = "//span[contains(text(),' Sign Up/Log In')]")
    public WebElement userLogin;

    @FindBy(xpath = "//a[contains(text(),'LOG IN')]")
    public WebElement LoginLink;

    @FindBy(xpath = "//a[@id='createUserId']")
    public WebElement createUser;

    @FindBy(xpath = "//b[contains(text(),'Login Information')]")
    public WebElement loginInformation;

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

    @FindBy(xpath = "//input[contains(@name,'loginId')]")
    public WebElement loginUsername;

    @FindBy(xpath = "//input[contains(@name,'password')]")
    public WebElement loginPassword;

    @FindBy(xpath = "//input[contains(@id,'retypePassword')]")
    public WebElement loginrePassword;

    @FindBy(xpath = "//select[contains(@name,'reminderQuestion')]")
    public WebElement selectreminderQuestion;

    @FindBy(xpath = "//input[contains(@id,'reminderAnswer')]")
    public WebElement reminderAnswer;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement contactFirstName;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement contactLastName;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement contactCompany;

    @FindBy(xpath = "//select[@name='country']")
    public WebElement contactCountry;

    @FindBy(xpath = "//input[@name='zip']")
    public WebElement contactCountryzip;

    @FindBy(xpath = "//input[@name='address1']")
    public WebElement contactAddress1;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement contactCity;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement contactState;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement contactEmail;

    @FindBy(xpath = "//input[@name='retypeEmail']")
    public WebElement contactretypeEmail;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement contactPhone;

    @FindBy(xpath = "//input[@name='cboptin']")
    public WebElement contactTermsCheck;

    @FindBy(xpath = "//input[@id='iacceptbutton']")
    public WebElement contactAcceptButton;


    public void login() throws InterruptedException {
        configFileReader=new ConfigFileReader();
        WebDriverWait wait=new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.elementToBeClickable(getSignInLink));
        getSignInLink.click();
        configFileReader.waitmethod();
        // Thread.sleep(3000);
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

    public void selectSecretQuestion() throws IOException {
        configFileReader= new ConfigFileReader();
        selectreminderQuestion.click();
        Select select=new Select(selectreminderQuestion);
        select.selectByVisibleText("What is your mother's first name?");
        reminderAnswer.sendKeys(configFileReader.ConfigReaderfile("momName"));
    }

    public void selectCountry() throws IOException {
        configFileReader= new ConfigFileReader();
        contactCountry.click();
        Select select=new Select(contactCountry);
        select.selectByVisibleText("India");
        contactCountryzip.sendKeys(configFileReader.ConfigReaderfile("contactCountryzip"));
        contactAddress1.sendKeys(configFileReader.ConfigReaderfile("contactAddress1"));
        contactCity.sendKeys(configFileReader.ConfigReaderfile("contactCity"));
        contactState.sendKeys(configFileReader.ConfigReaderfile("contactState"));
        contactEmail.sendKeys(configFileReader.ConfigReaderfile("contactEmail"));
        contactretypeEmail.sendKeys(configFileReader.ConfigReaderfile("contactretypeEmail"));
        contactPhone.sendKeys(configFileReader.ConfigReaderfile("contactPhone"));
        contactTermsCheck.click();
        contactAcceptButton.click();

    }





}
