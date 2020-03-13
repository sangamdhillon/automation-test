package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileDriver {

    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static AppiumDriver<MobileElement> getDriver(){
        return driver.get();
    }

    static void setDriver(AppiumDriver<MobileElement> Driver){
        driver.set(Driver);
    }
}
