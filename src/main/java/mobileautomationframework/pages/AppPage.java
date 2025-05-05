package mobileautomationframework.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import mobileautomationframework.base.BaseTestClass;
import org.openqa.selenium.WebElement;

public class AppPage extends BaseTestClass {

    @AndroidFindBy(id = "android:id/action_bar")
    public WebElement actionBar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='API Demos']")
    public WebElement titleApiDemos;

    @AndroidFindBy(id = "android:id/list")
    public WebElement listView;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Action Bar']")
    public WebElement actionBarOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Activity']")
    public WebElement activityOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Alarm']")
    public WebElement alarmOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Alert Dialogs']")
    public WebElement alertDialogsOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Device Admin']")
    public WebElement deviceAdminOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Fragment']")
    public WebElement fragmentOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Launcher Shortcuts']")
    public WebElement launcherShortcutsOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Loader']")
    public WebElement loaderOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Menu']")
    public WebElement menuOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Notification']")
    public WebElement notificationOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search']")
    public WebElement searchOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Service']")
    public WebElement serviceOption;
}
