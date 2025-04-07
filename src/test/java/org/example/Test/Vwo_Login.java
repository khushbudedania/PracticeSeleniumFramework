package org.example.Test;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Base.CommonToAllTest;
import org.example.Pages.Dashboard_POM;
import org.example.Pages.VwoLogin_POM;
import org.example.Utils.PropertiesReader;
import org.example.Utils.UtilExcelReader;
import org.example.driver.DriverManger;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import java.io.IOException;


public class Vwo_Login extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(VwoLogin_POM.class);

    @Description("Verify that valid Creds Suceesfully login")
    @Test
    public static void testValid_User() throws IOException, InterruptedException
    {
        logger.info("starting of the testcase");

        VwoLogin_POM vwoLoginPom = new VwoLogin_POM(DriverManger.getDriver());
        vwoLoginPom.LoginToVWO_ValidCreds(PropertiesReader.ReadKey("username"), PropertiesReader.ReadKey("password"));

        Dashboard_POM dashboardPom = new Dashboard_POM(DriverManger.getDriver());
        String LoggedInUserName = dashboardPom.LoggedInUserName();

        assertThat(LoggedInUserName).isEqualTo(PropertiesReader.ReadKey("expected_username"));
        System.out.println(LoggedInUserName);

        logger.info("End of the TestCase");



    }

    @Description("Verify that valid Creds Suceesfully login")
    @Test
    public void testInvalid_User() throws IOException, InterruptedException
    {
        logger.info("starting of the testcase");

        VwoLogin_POM vwoLoginPom = new VwoLogin_POM(DriverManger.getDriver());
        String Error_message = vwoLoginPom.LoginToVWO_InvalidCreds(PropertiesReader.ReadKey("invalid_username"),PropertiesReader.ReadKey("invalid_password"));

        Thread.sleep(3000);

        assertThat(Error_message).isEqualTo(PropertiesReader.ReadKey("error_message"));
        System.out.println(Error_message);

        logger.info("End of the testcase");
    }

    }
