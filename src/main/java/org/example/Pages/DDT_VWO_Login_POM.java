package org.example.Pages;

import org.example.Utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DDT_VWO_Login_POM {

    WebDriver driver;

    public DDT_VWO_Login_POM(WebDriver driver) {
        this.driver = driver;
    }

    //page Locators

    private By Email = By.xpath("//input[@id='login-username']");
    private By Password = By.xpath("//input[@id='login-password']");
    private By Sign_Button = By.xpath("//button[@id='js-login-btn']");
    private By Error_Msg = By.id("js-notification-box-msg");


    //page Actions

    public void LoginToVWO(String email, String Pass, String expectedResult) throws IOException, InterruptedException {
        driver.get(PropertiesReader.ReadKey("url"));
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Password).sendKeys(Pass);
        driver.findElement(Sign_Button).click();


        Thread.sleep(3000);

    }

    public String LoginToVWO_InvalidCreds(String email, String Pass, String expectedResult) throws InterruptedException {
        driver.get(PropertiesReader.ReadKey("url"));
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Password).sendKeys(Pass);
        driver.findElement(Sign_Button).click();

        Thread.sleep(3000);

        String Error_Message = driver.findElement(Error_Msg).getText();
        return Error_Message;
    }



}

