package tests;

import dataproviders.LoginDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest {
    WebDriver driver;
    SoftAssert softAssert;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    @BeforeMethod
    public void openLoginPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }
    @Test(dataProvider = "validLoginData", dataProviderClass = LoginDataProvider.class)
    public void logout(String username, String password){
        loginPage.login(username, password);
        softAssert.assertTrue(loginPage.isDashboardLoaded(), "Inventory page not loaded");

        dashboardPage.userDropdownClick();
        dashboardPage.logout();

        softAssert.assertTrue(driver.getCurrentUrl().contains("auth/login"),"User not redirected to login page");
        softAssert.assertAll();
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
