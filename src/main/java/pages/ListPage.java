package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListPage {

    public ListPage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.android:id/item_venue_name' and @text='Test']")
    public MobileElement listItem;

    @FindBy(id = "com.android:id/idb_text_view")
    public MobileElement confirmBtn;

    public void clickListItem() {
        listItem.click();
    }

    public void clickConfirmBtn() {
        confirmBtn.click();
    }
}
