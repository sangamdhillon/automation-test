package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MobileDriver;

import java.util.ArrayList;
import java.util.List;

public class JukeBoxPage {

    public JukeBoxPage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.touchtunes.android:id/widget_item_round_title']")
    public List<MobileElement> hotItemsCircleList;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.touchtunes.android:id/home_row_title']")
    public MobileElement hotItemsBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Hot Artists']")
    public MobileElement hotArtistsBtn;

    @FindBy(xpath = "//android.widget.ListView/descendant::android.widget.TextView")
    public List<MobileElement> hotItemsList;

    By by_homeRow = By.xpath("//android.widget.TextView[@resource-id='com.touchtunes.android:id/home_row_title']");

    public List<String> getHotItemsCircleList() {
        List<String> itemsList = new ArrayList<String>();
        for(MobileElement hotItem: hotItemsCircleList) {
            itemsList.add(hotItem.getText());
        }
        return itemsList;
    }

    public void clickHotItemsBtn() {
        hotItemsBtn.click();
    }

    public void clickHotArtistsBtn() {
        hotArtistsBtn.click();
    }

    public List<String> getHotItemsVerticalList() {
        List<String> itemsList = new ArrayList<String>();
        for(MobileElement hotItem: hotItemsList) {
            itemsList.add(hotItem.getText());
        }
        return itemsList;
    }

    public By getBy_homeRow() {
        return by_homeRow;
    }
}
