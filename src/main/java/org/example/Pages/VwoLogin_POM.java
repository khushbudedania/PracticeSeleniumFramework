package org.example.Pages;

import org.example.Utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class VwoLogin_POM {

    WebDriver driver;

    public VwoLogin_POM(WebDriver driver) {
        this.driver = driver;
    }

    //page Locators

        private By Email = By.xpath("//input[@id='login-username']");
        private By Password = By.xpath("//input[@id='login-password']");
        private By Sign_Button = By.xpath("//button[@id='js-login-btn']");
        private By Error_Msg = By.id("js-notification-box-msg");



    //page Actions

    public void LoginToVWO_ValidCreds(String email,String Pass) throws IOException, InterruptedException {
        driver.get(PropertiesReader.ReadKey("url"));
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Password).sendKeys(Pass);
        driver.findElement(Sign_Button).click();


        Thread.sleep(3000);

    }

    public String LoginToVWO_InvalidCreds(String email,String Pass) throws InterruptedException {
        driver.get(PropertiesReader.ReadKey("url"));
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Password).sendKeys(Pass);
        driver.findElement(Sign_Button).click();

        Thread.sleep(3000);

        String Error_Message = driver.findElement(Error_Msg).getText();
        return Error_Message;
    }


}
