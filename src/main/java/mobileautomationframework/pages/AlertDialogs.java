package mobileautomationframework.pages;

import mobileautomationframework.base.BaseTestClass;
import org.openqa.selenium.By;

public class AlertDialogs extends BaseTestClass {
    // Title Text
    public static final String TITLE_TEXT = "//android.widget.TextView[@text='App/Alert Dialogs']";

    // Buttons
    public static final String OK_CANCEL_DIALOG_MESSAGE = "//android.widget.Button[@resource-id='io.appium.android.apis:id/two_buttons']";
    public static final String OK_CANCEL_DIALOG_LONG_MESSAGE = "//android.widget.Button[@resource-id='io.appium.android.apis:id/two_buttons2']";
    public static final String OK_CANCEL_DIALOG_ULTRA_LONG_MESSAGE = "//android.widget.Button[@resource-id='io.appium.android.apis:id/two_buttons2ultra']";
    public static final String LIST_DIALOG = "//android.widget.Button[@resource-id='io.appium.android.apis:id/select_button']";
    public static final String PROGRESS_DIALOG = "//android.widget.Button[@resource-id='io.appium.android.apis:id/progress_button']";
    public static final String SINGLE_CHOICE_LIST = "//android.widget.Button[@resource-id='io.appium.android.apis:id/radio_button']";
    public static final String REPEAT_ALARM = "//android.widget.Button[@resource-id='io.appium.android.apis:id/checkbox_button']";
    public static final String SEND_CALL_TO_VOICEMAIL = "//android.widget.Button[@resource-id='io.appium.android.apis:id/checkbox_button2']";
    public static final String TEXT_ENTRY_DIALOG = "//android.widget.Button[@resource-id='io.appium.android.apis:id/text_entry_button']";
    public static final String OK_CANCEL_DIALOG_TRADITIONAL_THEME = "//android.widget.Button[@resource-id='io.appium.android.apis:id/two_buttons_old_school']";
    public static final String OK_CANCEL_DIALOG_HOLO_LIGHT_THEME = "//android.widget.Button[@resource-id='io.appium.android.apis:id/two_buttons_holo_light']";

    // ScrollView (Container of all buttons)
    public static final String SCROLL_VIEW = "//android.widget.ScrollView[@resource-id='io.appium.android.apis:id/screen']";

    public static final By SHORT_MESSAGE = By.id("android:id/alertTitle");

}
