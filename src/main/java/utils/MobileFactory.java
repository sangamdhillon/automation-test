package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileFactory {

    static AppiumDriver<MobileElement> driver;

    @BeforeTest
    public static void launchApp() throws MalformedURLException {
        String apkPath = "/src/test/resources/apps/TouchTunes_v3.20.0-2685_apkpure.com.apk";
        File app = new File(System.getProperty("user.dir").concat(apkPath));
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.UDID, "");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, caps);

        MobileDriver.setDriver(driver);
    }

    @AfterTest
    public static void closeApp(){
        driver.quit();
    }
}
