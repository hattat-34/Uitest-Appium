package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    //Components
    private String _login = "loginBtn";
    private String _username = "userInput";
    private String _password = "passwordInput";
    private String _forgotPw = "forgotPasswordBtn";
    private String _back = "backToLoginScreenBtn";
    private String _send = "submitForgotPasswordBtn";
    private String _email = "emailInput";

    public void InputCredentials(String user, String pass){
        SendText(MobileBy.AccessibilityId(_username),user);
        SendText(MobileBy.AccessibilityId(_password),pass);
    }

    public void ClickLogin(){
        Click(MobileBy.AccessibilityId(_login));
    }

    public boolean IsLoginPresent(){

        return IsElementPresent(MobileBy.AccessibilityId(_login));
    }
}
