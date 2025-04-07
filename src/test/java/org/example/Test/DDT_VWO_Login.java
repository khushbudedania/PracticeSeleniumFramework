package org.example.Test;

import io.qameta.allure.Description;
import org.example.Base.CommonToAllTest;
import org.example.Pages.DDT_VWO_Login_POM;
import org.example.Pages.Dashboard_POM;
import org.example.Pages.VwoLogin_POM;
import org.example.Utils.PropertiesReader;
import org.example.Utils.UtilExcelReader;
import org.example.driver.DriverManger;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class DDT_VWO_Login extends CommonToAllTest {

    @Description("Verify that valid Creds Suceesfully login")
    @Test(dataProvider = "getData", dataProviderClass = UtilExcelReader.class)
    public static void testValid_User(String email, String Pass, String expectedResult) throws IOException, InterruptedException {
        DDT_VWO_Login_POM ddt_vwo_login_pom = new DDT_VWO_Login_POM(DriverManger.getDriver());
        ddt_vwo_login_pom.LoginToVWO(email, Pass, expectedResult);


        if (expectedResult.equalsIgnoreCase("Invalid")) {
            Thread.sleep(3000);

            String Error_message = ddt_vwo_login_pom.LoginToVWO_InvalidCreds(email, Pass, expectedResult);
            Thread.sleep(3000);

            assertThat(Error_message).isEqualTo(PropertiesReader.ReadKey("error_message"));
            System.out.println(Error_message);

        } else if (expectedResult.equalsIgnoreCase("valid")) {
            Thread.sleep(3000);

            Dashboard_POM dashboardPom = new Dashboard_POM(DriverManger.getDriver());
            String LoggedInUserName = dashboardPom.LoggedInUserName();

            assertThat(LoggedInUserName).isEqualTo(PropertiesReader.ReadKey("expected_username"));
            System.out.println(LoggedInUserName);

            dashboardPom.Logout_Page();
        }
    }
}
