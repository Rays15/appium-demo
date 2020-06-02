package com.rays.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.events.api.general.ElementEventListener;
import io.appium.java_client.events.api.general.NavigationEventListener;
import io.appium.java_client.events.api.general.WindowEventListener;
import io.appium.java_client.events.api.mobile.ContextEventListener;
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
import org.openqa.selenium.support.ui.FluentWait;

/**
 * Created on 2020/5/27.
 */
public class AndroidTest {

  public static void main(String[] args) throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
        capabilities.setCapability(MobileCapabilityType.APP, "A:\\workspace\\AndroidStudioProjects\\SmartMedical\\alignpro-lib-app\\release\\alignpro-lib-app-release.apk");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mosai.smartmedical");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
    capabilities
        .setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
    //you are free to set additional capabilities
    AppiumDriver<MobileElement> baseDriver = new AppiumDriver<>(
        new URL("http://127.0.0.1:4723/wd/hub"),
        capabilities);

    System.out.println("baseDriver: " + baseDriver);

    AppiumDriver<MobileElement> driver = EventFiringWebDriverFactory
        .getEventFiringWebDriver(baseDriver, contextEventListener,
            navigationEventListener);

    System.out.println("driver: " + driver);

    driver.findElement(By.id("btnAppiumTest")).click();

    List<MobileElement> inputs = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
        .until(appiumDriver -> {
          List<MobileElement> elements = appiumDriver
              .findElementsByClassName("android.widget.EditText");
          System.out.println("inputs: " + elements);
          if (elements != null && elements.size() == 3) {
            return elements;
          }
          return null;
        });

    driver.findElement(By.id("etAccountId")).setValue("88888888");
    driver.findElement(By.id("etAmount")).setValue("100.00");
    driver.findElement(By.id("etPassword")).setValue("123456");

    new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1)).until(appiumDriver -> {
      boolean allMatch = inputs.stream()
          .allMatch(mobileElement -> {
            String text = mobileElement.getAttribute("text");
            System.out.println("getAttribute text: " + text);
            return !TextUtils.isEmpty(text);
          });
      System.out.println("allMatch: " + allMatch);
      return allMatch;
    });

    driver.findElement(By.id("btnSubmit")).click();

    MobileElement tvContent = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
        .until(appiumDriver -> {
          System.out.println("findElement tvContent");
          List<MobileElement> elements = driver.findElementsById("tvContent");
          if (!elements.isEmpty()) {
            return elements.get(0);
          }
          return null;
        });
    System.out.println("findElement tvContent: " + tvContent);

    System.out.println(tvContent.getText());
  }

  static WindowEventListener windowEventListener = new MyWindowEventListener();

  static NavigationEventListener navigationEventListener = new MyNavigationEventListener();

  static ContextEventListener contextEventListener = new MyContextEventListener();

  static ElementEventListener elementEventListener = new MyElementEventListener();

}
