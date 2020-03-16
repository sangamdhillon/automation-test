package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ItemPage {

    public ItemPage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.android:id/widget_item_round_title']")
    public List<MobileElement> circleList;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.android:id/home_row_title']")
    public MobileElement itemsBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Hot Artists']")
    public MobileElement hotItemBtn;

    @FindBy(xpath = "//android.widget.ListView/descendant::android.widget.TextView")
    public List<MobileElement> itemsList;

    By by_homeRow = By.xpath("//android.widget.TextView[@resource-id='com.android:id/home_row_title']");

    public List<String> getCircleList() {
        List<String> itemsList = new ArrayList<String>();
        for(MobileElement hotItem: circleList) {
            itemsList.add(hotItem.getText());
        }
        return itemsList;
    }

    public void clickHotItemsBtn() {
        itemsBtn.click();
    }

    public void clickHotArtistsBtn() {
        hotItemBtn.click();
    }

    public List<String> getVerticalList() {
        List<String> list = new ArrayList<String>();
        for(MobileElement hotItem: itemsList) {
            list.add(hotItem.getText());
        }
        return list;
    }

    public By getBy_homeRow() {
        return by_homeRow;
    }
}
