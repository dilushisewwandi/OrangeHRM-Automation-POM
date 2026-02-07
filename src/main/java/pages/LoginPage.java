package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private  By loginButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//div[@role='alert']");
    private By requiredText = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");

    private By forgotPasswordLink = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");

    public void enterUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }
    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }
    public void clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
    public void login(String username, String password){
        if (!username.isEmpty()){
            enterUsername(username);
        }
        if (!password.isEmpty()){
            enterPassword(password);
        }
        clickLogin();
    }

    public String getErrorMessage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
    public String getRequiredText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(requiredText)).getText();
    }
    public boolean isDashboardLoaded(){
        return driver.getCurrentUrl().contains("dashboard");
    }

    public PasswordResetPage clickForgotPassword(){
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink)).click();
        return new PasswordResetPage(driver);
    }
}
