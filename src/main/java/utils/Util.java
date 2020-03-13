package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class Util {

    public static void scrollDown(){

        Dimension dimension = MobileDriver.getDriver().manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.5);
        int scrollEnd = (int) (dimension.getHeight() * 0.1);

        new TouchAction((PerformsTouchActions) MobileDriver.getDriver())
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }

    public static void scrollNClick(By listItems, String Text){
        boolean flag = false;

        while(true){
            for(MobileElement el: MobileDriver.getDriver().findElements(listItems)){
                if(el.getAttribute("text").equals(Text)){
                    el.click();
                    flag=true;
                    break;
                }
            }
            if(flag)
                break;
            else
                scrollDown();
        }
    }

    public static void scrollRight(){
        Dimension dimension = MobileDriver.getDriver().manage().window().getSize();
        int scrollStart = (int) (dimension.getWidth() * 0.5);
        int scrollEnd = (int) (dimension.getWidth() * 0.1);

        new TouchAction((PerformsTouchActions) MobileDriver.getDriver())
                .press(PointOption.point(scrollStart, 0))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(scrollEnd, 0))
                .release().perform();
    }

    public static void scrollRightNClick(By listItems, String Text){
        boolean flag = false;

        while(true){
            for(MobileElement el: MobileDriver.getDriver().findElements(listItems)){
                if(el.getAttribute("text").equals(Text)){
                    el.click();
                    flag=true;
                    break;
                }
            }
            if(flag)
                break;
            else
                scrollRight();
        }
    }
}
