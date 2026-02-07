package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //locators
    private By userDropDown = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private By menuOptions = By.xpath("//ul[@class='oxd-dropdown-menu']/li");

    //actions
    public void userDropdownClick(){
        wait.until(ExpectedConditions.elementToBeClickable(userDropDown)).click();
    }
    public void logout(){
        List<WebElement> menuListValues = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuOptions));
        for(WebElement menuList: menuListValues){
            String option = menuList.getText();
            if (option.equals("Logout")){
                menuList.click();
                break;
            }
        }
    }
}

