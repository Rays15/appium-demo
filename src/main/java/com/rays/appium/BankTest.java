package com.rays.appium;

import com.rays.appium.bank.HomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.events.api.general.ElementEventListener;
import io.appium.java_client.events.api.general.NavigationEventListener;
import io.appium.java_client.events.api.general.WindowEventListener;
import io.appium.java_client.events.api.mobile.ContextEventListener;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

/**
 * Created on 2020/5/27.
 */
public class BankTest {

  public static void main(String[] args) throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
    capabilities.setCapability(MobileCapabilityType.UDID, "7f096bf4");
//    capabilities.setCapability(MobileCapabilityType.APP,
//        "A:\\workspace\\idea\\appium-demo\\apk\\bank_abc_4.2.4_54_com.android.bankabc_main_standalo.apk");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.bankabc");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
        "com.alipay.mobile.quinox.LauncherActivity");
//    capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
//        "com.alipay.mobile.quinox.LauncherActivity");
    capabilities
        .setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
    //you are free to set additional capabilities
    AppiumDriver<MobileElement> baseDriver = new AppiumDriver<>(
        new URL("http://127.0.0.1:4723/wd/hub"),
        capabilities);

    System.out.println("baseDriver: " + baseDriver);

    AppiumDriver<MobileElement> driver = EventFiringWebDriverFactory
        .getEventFiringWebDriver(baseDriver, contextEventListener,
            navigationEventListener);

    System.out.println("driver: " + driver);

    MobileElement btnTransfer = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
        .until(appiumDriver -> {
          List<MobileElement> appiumTest = driver
              .findElements(By.className("android.widget.Button"));
          System.out.println("button size: " + appiumTest.size());
          appiumTest.forEach(item -> {
            System.out.println("button text: " + item.getText());
          });

          HomePage homePage = new HomePage();
          PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), homePage);

          System.out.println("homePage.buttons.size: " + homePage.buttons.size());
          homePage.buttons.forEach(item -> {
            System.out.println("homePage.buttons button text: " + item.getText());
          });

          System.out.println("homePage.textMatches size: " + homePage.textMatches.size());
          homePage.textMatches.forEach(item -> {
            System.out.println("textMatches text: " + item.getText());
          });

          List<MobileElement> elementList = homePage.textViews;
          System.out.println("homePage.btnTransfer: " + elementList.size());
          if (!elementList.isEmpty()) {
            for (MobileElement element : elementList) {
              String text = element.getText();
              System.out.println("homePage.btnTransfer text: " + text);
              if ("转账".equals(text)) {
                return element;
              }
            }
          }
          return null;
        });
    System.out.println("btnTransfer: " + btnTransfer);
    btnTransfer.click();

    MobileElement transfer = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
        .until(appiumDriver -> {
          HomePage homePage = new HomePage();
          PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), homePage);
          System.out.println("homePage.textMatches size: " + homePage.textMatches.size());
          MobileElement result = null;
          for (MobileElement item : homePage.textMatches) {
            String text = item.getText();
            System.out.println("textMatches text: " + text);
            if ("转账".equals(text)) {
              result = item;
            }
          }
          return result;
        });
    System.out.println("btnTransfer: " + transfer);
    transfer.click();

    List<MobileElement> elements = driver
        .findElements(ByAndroidUIAutomator.AndroidUIAutomator("new UiSelector().textMatches(\"请输入登录密码\")"));
    if (elements.isEmpty()) {
      return;
    }
    elements.get(0).setValue(".....");

    MobileElement btnLogin = driver
        .findElement(ByAndroidUIAutomator.AndroidUIAutomator("new UiSelector().text(\"登录\").clickable(true)"));
    btnLogin.click();
  }


  static WindowEventListener windowEventListener = new MyWindowEventListener();

  static NavigationEventListener navigationEventListener = new MyNavigationEventListener();

  static ContextEventListener contextEventListener = new MyContextEventListener();

  static ElementEventListener elementEventListener = new MyElementEventListener();

}
