package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BaseScreen {
    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public BaseScreen (AppiumDriver<MobileElement> driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,15);
    }

    // <editor-fold desc = "Common Components">
    protected String androidOK = "android:id/button1";
    protected String loading = "loadingActivity";
    protected String androidAlertMessage = "android:id/message";
    protected String androidAlertPanel = "android:id/parentPanel";
    // </editor-fold>

    protected  void Click(By by){

        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void SendText(By by, String msg){

        getByVisibleElement(by).sendKeys(msg);
    }

    protected String GetText(By by){

        return getByVisibleElement(by).getText();
    }

// <editor-fold desc = "Get-by Functions">
    protected WebElement getByVisibleElement(By by){
    return  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement getByPrecenseOfElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected MobileElement getByFindElement(By by){
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        return driver.findElement(by);
    }
// </editor-fold>

    protected boolean IsElementPresent(By by){
        try{
            driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public void WaitLoading(){
        while(true) {
            if(!IsElementPresent(MobileBy.AccessibilityId(loading))){
                break;
            }
        }
    }

    public void WaitLoadingAndPassAlert(){

        WaitLoading();
        if(IsElementPresent(MobileBy.id(androidAlertPanel)))
            Click(MobileBy.id(androidOK));
        WaitLoading();
    }
}
