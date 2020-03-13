package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MobileDriver;

import java.util.concurrent.TimeUnit;

public class WelcomePage {

    public WelcomePage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.touchtunes.android:id/tt_action_bar_right_action_text")
    public WebElement skipBtn;

    public void clickSkip() {
        skipBtn.click();
    }

}
