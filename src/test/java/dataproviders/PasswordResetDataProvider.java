package dataproviders;

import org.testng.annotations.DataProvider;

public class PasswordResetDataProvider {
    @DataProvider
    public Object[][] resetPassword(){
        Object[][] data = {{"Admin"}};
        return data;
    }
}
