package tests;

import dataproviders.PasswordResetDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.PasswordResetPage;

public class PasswordResetTest {

    WebDriver driver;
    SoftAssert softAssert;
    PasswordResetPage passwordResetPage;
    LoginPage loginPage;
    @BeforeMethod
    public void openLoginPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        softAssert = new SoftAssert();
        passwordResetPage = new PasswordResetPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "resetPassword", dataProviderClass = PasswordResetDataProvider.class)
    public void resetPassword(String username){
        passwordResetPage = loginPage.clickForgotPassword();
        softAssert.assertTrue(passwordResetPage.isPasswordResetPageLoaded(),"User not navigated to the password reset page.");
        passwordResetPage.resetPassword(username);
        softAssert.assertTrue(passwordResetPage.isSendPasswordResetPageLoaded(), "User was not redirected to send password reset page");
        softAssert.assertTrue(passwordResetPage.getSuccessMessage().contains("Reset Password link sent successfully"),"Reset password confirmation message was not displayed or text did not match.");
        softAssert.assertAll();

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
