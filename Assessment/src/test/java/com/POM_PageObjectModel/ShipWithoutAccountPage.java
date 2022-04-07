package com.POM_PageObjectModel;

import com.StepDefinations.BaseClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShipWithoutAccountPage {

    public static WebDriver driver= BaseClass.driver;
    Logger log=Logger.getLogger(HomePage.class.getName());
    public ShipWithoutAccountPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='fx-from-name']")
    public WebElement enterYourName;

    @FindBy(xpath = "//input[@id='fx-from-zip']")
    public WebElement zipCode;

    List<WebElement> countryList=driver.findElements(By.xpath("//select[@id='fx-from-country']"));
    public void countryList(String county) throws InterruptedException {
        for (WebElement CountryList:countryList)
        {
            System.out.println();

            Thread.sleep(50);
            log.info(CountryList.getText());
            System.out.println();
            WebDriverWait wait=new WebDriverWait(driver,60);
            wait.until(ExpectedConditions.visibilityOfAllElements(CountryList));
            String countrydetails=CountryList.getText();
            System.out.println();
            log.info(countrydetails);
            Select selectCountryDropdown = new Select(driver.findElement(By.xpath("//select[@id='fx-from-country']")));
            selectCountryDropdown.selectByVisibleText(county);

        }}


}
