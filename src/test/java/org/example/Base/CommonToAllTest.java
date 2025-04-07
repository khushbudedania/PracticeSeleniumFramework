package org.example.Base;

import org.example.driver.DriverManger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class CommonToAllTest {


    @BeforeTest
    public void Setup() throws IOException
    {
        DriverManger.init();
    }

    @AfterTest
    public void TearDown()
    {
        DriverManger.down();
    }

}
