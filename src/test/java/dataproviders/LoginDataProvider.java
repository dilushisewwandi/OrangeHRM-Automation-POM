package dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider
    public Object [][] validLoginData(){
        Object[][] loginData = {{"Admin","admin123"}};
        return loginData;
    }
    @DataProvider
    public Object [][] invalidUsername(){
        Object[][] loginData = {{"incorrect","admin123"}};
        return loginData;
    }
    @DataProvider
    public Object [][] lowerCaseUsername(){
        Object[][] loginData = {{"admin","admin123"}};
        return loginData;
    }
    @DataProvider
    public Object [][] invalidPassword(){
        Object[][] loginData = {{"Admin","admin1234"}};
        return loginData;
    }
    @DataProvider
    public Object [][] emptyFields(){
        Object[][] loginData = {{"",""}};
        return loginData;
    }
}
