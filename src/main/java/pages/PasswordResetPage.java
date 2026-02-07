package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordResetPage {
    WebDriver driver;
    WebDriverWait wait;

    public PasswordResetPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By usernameField = By.name("username");
    private  By resetPasswordButton = By.xpath("//button[@type='submit']");
    private By successMessage = By.xpath("//div[@class='orangehrm-card-container']/h6");

    public void enterUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }
    public void clickResetPassword(){
        wait.until(ExpectedConditions.elementToBeClickable(resetPasswordButton)).click();
    }
    public void resetPassword(String username){
        enterUsername(username);
        clickResetPassword();
    }

    public boolean isPasswordResetPageLoaded() {
        return driver.getCurrentUrl().contains("requestPasswordResetCode");
    }
    public String getSuccessMessage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessage));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

    public boolean isSendPasswordResetPageLoaded(){
        return driver.getCurrentUrl().contains("sendPasswordReset");
    }
}
