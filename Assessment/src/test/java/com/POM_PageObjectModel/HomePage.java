package com.POM_PageObjectModel;

import DataProvider.ConfigFileReader;
import com.StepDefinations.BaseClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    ConfigFileReader configFileReader;
    public static WebDriver driver=BaseClass.driver;
    Logger log=Logger.getLogger(HomePage.class.getName());
    public HomePage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[contains(text(),'Choose your location')]")
    public WebElement chooseYourLocation;
    @FindBy(xpath = "//a[@aria-label='English']")
    public WebElement englishCountry;

    public void countries()
    {
        List<WebElement>list=driver.findElements(By.xpath("//div[@class='fxg-geo-locator__countries']"));
        for (WebElement value:list) {
            String listvalue= value.getText();
            log.info(listvalue);
            englishCountry.click();

        }
    }

    @FindBy(xpath = "//h5[contains(text(),'FedEx is using cookies')]")
    public WebElement cookiesPageTitle;

    @FindBy(xpath = "//button[contains(text(),'ACCEPT ALL COOKIES')]")
    public WebElement AcceptTheCookies;

    public void handlingCookies() throws InterruptedException {

        Thread.sleep(4000);
        AcceptTheCookies.click();
    }
    @FindBy(xpath = "//h1[contains(text(),'Where  now')]")
    public WebElement homePageTitle;

    @FindBy(xpath = "//div[@class='fxg-wrapper']/ul")
    public WebElement fedex_services;

    @FindBy(xpath = "//a[contains(text(),'Ship without account')]")
    public WebElement ship_Without_account;

    @FindBy(xpath = "//div[contains(@class,'fxg-dropdown__sub-menu')]/div[2]")
    public WebElement shipping_list_linkSecond;

    @FindBy(xpath = "//a[@aria-label='Ship Quick & Simple']")
    public WebElement ShipQuick_Simple;

    @FindBy(xpath = "//div[@class='link section']/div//a[@aria-label='Ship without account']")
    public WebElement ship_Without_account_Link;

    @FindBy(xpath = "//div[@class='fxg-wrapper']/ul/div/li[1]/a/span[contains(text(),'Shipping')]")
    public WebElement ShippingService;

    @FindBy(xpath = "//div[@class='dropdown section']/li/a/span[contains(text(),'Shipping')]")
    public WebElement Shipping_List_from_loginpage;

    @FindBy(xpath = "//div[@class='fxg-wrapper']/ul/div/li[1]/a/span[contains(text(),'Tracking')]")
    public WebElement TrackingService;

    @FindBy(xpath = "//input[@id='trackingModuleTrackingNum']")
    public WebElement TrackingID;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement TrackingSubmit;

    @FindBy(xpath = "//div[@class='notification notification--error']/div[2]")
    public WebElement TrackingNotification;

    public void shippingServicesList() throws InterruptedException {
        servicesList();
        configFileReader=new ConfigFileReader();
        configFileReader.waitmethod();
        ShippingService.click();
        List<WebElement> Shipping_Services_list = driver.findElements(By.xpath("//li[contains(@class,'fxg-dropdown__item fxg-dropdown__item--open')]/div"));
        WebDriverWait wait=new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfAllElements(Shipping_Services_list));
        for (WebElement shippingerviceList:Shipping_Services_list)
        {
            System.out.println();
            configFileReader.waitmethod();
            log.info(shippingerviceList.getText());
            System.out.println();
            System.out.println(shippingerviceList.getText());
            wait.until(ExpectedConditions.visibilityOfAllElements(shippingerviceList));
            String shiplistSecondlink=shipping_list_linkSecond.getText();
            log.info(shiplistSecondlink);
            wait.until(ExpectedConditions.elementToBeClickable(shipping_list_linkSecond));
            shipping_list_linkSecond.click();
//            String Ship_without_account=ship_Without_account.getText();
//            String ShipSimple=ShipQuick_Simple.getText();
//            System.out.println();
//            if (shippingerviceList.getText().contains(Ship_without_account))
//            {
//                System.out.println("searching for the link ship without account");
//                Thread.sleep(2000);
//                ship_Without_account_Link.click();
//                log.info("clicking on Ship without account option");
//            }
//            else
//            {
//                String ShipSimple=ShipQuick_Simple.getText();
//                if (shippingerviceList.getText().contains(ShipSimple))
//                {
//                    wait.until(ExpectedConditions.elementToBeClickable(ShipQuick_Simple));
//                    ShipQuick_Simple.click();
//                }
//            }
        }
    }
    public void shippingServicesListfromloginpage() throws InterruptedException {

        configFileReader=new ConfigFileReader();
        configFileReader.waitmethod();
        List<WebElement> Shipping_Services_list = driver.findElements(By.xpath("//li[contains(@class,'fxg-dropdown__item fxg-dropdown__item--open')]/div"));
        WebDriverWait wait=new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfAllElements(Shipping_Services_list));
        for (WebElement shippingerviceList:Shipping_Services_list) {
            System.out.println();

            configFileReader.waitmethod();
            log.info(shippingerviceList.getText());
            System.out.println();
            System.out.println(shippingerviceList.getText());
            wait.until(ExpectedConditions.visibilityOfAllElements(shippingerviceList));
            String shiplistSecondlink = shipping_list_linkSecond.getText();
            log.info(shiplistSecondlink);
            wait.until(ExpectedConditions.elementToBeClickable(shipping_list_linkSecond));
            shipping_list_linkSecond.click();

        }}

    public void servicesListfromloginpage()  {

        WebDriverWait wait=new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfAllElements(Shipping_List_from_loginpage));
        Shipping_List_from_loginpage.click();
    }


    public void servicesList()  {
        List<WebElement> Services_list = driver.findElements(By.xpath("//div[@class='fxg-wrapper']/ul"));
        WebDriverWait wait=new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfAllElements(Services_list));
        for (WebElement serviceList:Services_list)
        {
            System.out.println(serviceList.getText());
            log.info(serviceList.getText());
            wait.until(ExpectedConditions.elementToBeClickable(ShippingService));
            ShippingService.click();

        }
    }

    public void trackingService(String trackID ) throws InterruptedException {
        configFileReader= new ConfigFileReader();
        configFileReader.waitmethod();
        List<WebElement> Services_list = driver.findElements(By.xpath("//div[@class='fxg-wrapper']/ul"));
        WebDriverWait wait=new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfAllElements(Services_list));
        for (WebElement serviceList:Services_list)
        {
            System.out.println(serviceList.getText());
            log.info(serviceList.getText());
            wait.until(ExpectedConditions.elementToBeClickable(TrackingService));
            TrackingService.click();
            configFileReader.waitmethod();
            TrackingID.sendKeys(trackID);
            TrackingSubmit.click();
            System.out.println(driver.getTitle());
            configFileReader.waitmethod();

        }
    }
}
