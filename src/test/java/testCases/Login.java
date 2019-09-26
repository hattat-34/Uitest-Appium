package testCases;

import screens.LoginScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;

public class Login extends BaseTest {

    @Test
 public void login_Successful(){
     LoginScreen login = new LoginScreen(driver);

     login.InputCredentials("TEST90016932","1111");
     login.ClickLogin();
     login.WaitLoadingAndPassAlert();
     Assert.assertFalse(login.IsLoginPresent());
 }
}
