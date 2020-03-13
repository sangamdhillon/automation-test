package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MobileDriver;

public class LocationPage {

    public LocationPage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.touchtunes.android:id/location_access_got_it_button")
    public WebElement gotItBtn;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public WebElement allowBtn;

    public void clickGotItBtn() {
        gotItBtn.click();
    }

    public void clickAllowBtn() {
        allowBtn.click();
    }
}
