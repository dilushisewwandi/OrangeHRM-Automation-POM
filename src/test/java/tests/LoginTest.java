package tests;

import dataproviders.LoginDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class LoginTest {
    WebDriver driver;
    SoftAssert softAssert;
    LoginPage loginPage;
    @BeforeMethod
    public void openLoginPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
    }

    //Login with valid data
    @Test(priority = 0, dataProvider = "validLoginData", dataProviderClass = LoginDataProvider.class)
    public void loginWithValidData(String username, String password){
        loginPage.login(username, password);
        softAssert.assertTrue(loginPage.isDashboardLoaded(), "Dashboard page not loaded");
        softAssert.assertAll();
    }

    //    Login with invalid username
    @Test(priority = 1, dataProvider = "invalidUsername", dataProviderClass = LoginDataProvider.class)
    public void loginWithInvalidUsername(String username, String password){
        loginPage.login(username, password);
        softAssert.assertTrue(loginPage.getErrorMessage().contains("Invalid credentials"),"Invalid credentials error message not displayed");
        softAssert.assertFalse(loginPage.isDashboardLoaded(), "User navigated to the dashboard page with invalid username");
        softAssert.assertAll();
    }

    //Login with invalid password
    @Test(priority = 2, dataProvider = "invalidPassword", dataProviderClass = LoginDataProvider.class)
    public void loginWithInvalidPassword(String username, String password){
        loginPage.login(username, password);
        softAssert.assertTrue(loginPage.getErrorMessage().contains("Invalid credentials"),"Invalid credentials error message not displayed");
        softAssert.assertFalse(loginPage.isDashboardLoaded(),"User navigated to the dashboard page with invalid password");
        softAssert.assertAll();
    }

    //Login with required fields empty
    @Test(priority = 4, dataProvider = "emptyFields", dataProviderClass = LoginDataProvider.class)
    public void loginWithEmptyFields(String username, String password){
        loginPage.login(username, password);
        softAssert.assertTrue(loginPage.getRequiredText().contains("Required"),"Required validation msg not displayed");
        softAssert.assertFalse(loginPage.isDashboardLoaded(), "User navigated to the dashboard page with empty fields");
        softAssert.assertAll();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}



