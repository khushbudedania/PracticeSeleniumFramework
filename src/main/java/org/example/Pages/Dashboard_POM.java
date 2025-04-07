package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard_POM {

    WebDriver driver;

    public Dashboard_POM(WebDriver driver) {
        this.driver = driver;
    }

   //Page Locators

    By Dashboard_Name = By.xpath("//span[@data-qa=\"lufexuloga\"]");
    By Logout_button = By.xpath("//vwo-menu[@ng-if='!(isShareView && !isImpersonatedWithoutVwoAccess)']//button[@title='User menu']");
    By Logout = By.xpath("//li[@no-async-loader='true']");

    //Page Actions

    public String LoggedInUserName() throws InterruptedException {

        Thread.sleep(3000);

        return driver.findElement(Dashboard_Name).getText();
    }

    public  void Logout_Page()
    {
        driver.findElement(Logout_button).click();
        driver.findElement(Logout).click();
    }

}
//WebElement Logout_Button = driver.findElement(By.xpath("//vwo-menu[@ng-if='!(isShareView && !isImpersonatedWithoutVwoAccess)']//button[@title='User menu']"));
//        Logout_Button.click();
//
//        WebElement Logout = driver.findElement(By.xpath("//li[@no-async-loader='true']"));
//        Logout.click();