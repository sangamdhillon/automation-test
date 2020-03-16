package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MobileDriver;

public class JukeboxListPage {

    public JukeboxListPage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.touchtunes.android:id/item_venue_name' and @text='The Sports Page']")
    public MobileElement jukeBoxListItem;

    @FindBy(id = "com.touchtunes.android:id/idb_text_view")
    public MobileElement confirmBtn;

    public void clickJukeBoxListItem() {
        jukeBoxListItem.click();
    }

    public void clickConfirmBtn() {
        confirmBtn.click();
    }
}
