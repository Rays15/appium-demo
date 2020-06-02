package com.rays.appium;

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
import org.apache.http.util.TextUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

/**
 * Created on 2020/5/27.
 */
public class FindNameTest {

  public static void main(String[] args) throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
        capabilities.setCapability(MobileCapabilityType.APP, "A:\\workspace\\idea\\appium-demo\\apk\\alignpro-lib-app-release.apk");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mosai.smartmedical");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
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

    List<MobileElement> elements = driver
        .findElements(ByAndroidUIAutomator.AndroidUIAutomator("new UiSelector().textMatches(\"[\\s\\S]+\")"));
    System.out.println("elements size: " + elements.size());
    elements.forEach(item -> {
      System.out.println("elements text: " + item.getText());
    });

    List<MobileElement> appiumTest = driver.findElements(By.className("android.widget.Button"));
    System.out.println("button size: " + appiumTest.size());
    appiumTest.forEach(item -> {
      System.out.println("button text: " + item.getText());
    });

    Page1 page1 = new Page1();
    PageFactory.initElements(new AppiumFieldDecorator(driver), page1);

    System.out.println("page1 buttons size: " + page1.buttons.size());
    System.out.println("page1 btnAppium: " + page1.btnAppium);
    page1.btnAppium.click();


//    List<MobileElement> customs = driver
//        .findElementsByCustom("new UiSelector().text(\"Appium Test\")");
//    System.out.println("customs size: " + customs.size());
//    customs.forEach(item -> {
//      System.out.println("customs text: " + item.getText());
//    });


//    List<MobileElement> inputs = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
//        .until(appiumDriver -> {
//          List<MobileElement> elements = appiumDriver
//              .findElementsByClassName("android.widget.EditText");
//          System.out.println("inputs: " + elements);
//          if (elements != null && elements.size() == 3) {
//            return elements;
//          }
//          return null;
//        });
//
//    driver.findElement(By.id("etAccountId")).setValue("88888888");
//    driver.findElement(By.id("etAmount")).setValue("100.00");
//    driver.findElement(By.id("etPassword")).setValue("123456");
//
//    new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1)).until(appiumDriver -> {
//      boolean allMatch = inputs.stream()
//          .allMatch(mobileElement -> {
//            String text = mobileElement.getAttribute("text");
//            System.out.println("getAttribute text: " + text);
//            return !TextUtils.isEmpty(text);
//          });
//      System.out.println("allMatch: " + allMatch);
//      return allMatch;
//    });
//
//    driver.findElement(By.id("btnSubmit")).click();
//
//    MobileElement tvContent = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
//        .until(appiumDriver -> {
//          System.out.println("findElement tvContent");
//          List<MobileElement> elements = driver.findElementsById("tvContent");
//          if (!elements.isEmpty()) {
//            return elements.get(0);
//          }
//          return null;
//        });
//    System.out.println("findElement tvContent: " + tvContent);
//
//    System.out.println(tvContent.getText());
  }


  static WindowEventListener windowEventListener = new MyWindowEventListener();

  static NavigationEventListener navigationEventListener = new MyNavigationEventListener();

  static ContextEventListener contextEventListener = new MyContextEventListener();

  static ElementEventListener elementEventListener = new MyElementEventListener();

}
